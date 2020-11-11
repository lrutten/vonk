package org.rooi.vonk;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.net.URL;
import java.net.HttpCookie;
import java.nio.file.Files;
import java.nio.ByteBuffer;

import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.Version;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import spark.Spark;
import spark.Request;
import spark.Session;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.redirect;
import static spark.Spark.notFound;
import static spark.Spark.halt;
import static spark.Spark.webSocket;
import static spark.Spark.port;
import static spark.Spark.secure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.eclipse.jetty.websocket.api.UpgradeRequest;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketFrame;
import org.eclipse.jetty.websocket.api.extensions.Frame;

//import com.google.gson.Gson;
import com.google.gson.JsonObject;

import com.ericsson.otp.erlang.OtpErlangObject;
import com.ericsson.otp.erlang.OtpErlangTuple;
import com.ericsson.otp.erlang.OtpErlangAtom;
import com.ericsson.otp.erlang.OtpErlangString;
import com.ericsson.otp.erlang.OtpErlangList;
import com.ericsson.otp.erlang.OtpInputStream;
import com.ericsson.otp.erlang.OtpErlangDecodeException;

import org.rooi.vonk.sessies.Sessie;


public class VonkMain
{
   private static Logger logger = LogManager.getLogger();
   private Configuration            conf;
   private FreeMarkerEngine         fme;
   //private MQTTConnector          connector;
   private HashMap<String, Sessie>  sessies;
   private static VonkMain          single;

   public VonkMain()
   {
      logger.debug("mainstart");
      
      sessies = new HashMap<String, Sessie>();

      conf = new Configuration(new Version(2, 3, 28));
      try
      {
         conf.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
      }
      catch (IOException e)
      {
      }
      fme = new FreeMarkerEngine(conf);
       
      /*
      connector = new MQTTConnector(this);
      connector.start();
       */
      single = this;
   }

   public static VonkMain singleMain()
   {
      return single;
   }

   public Configuration getConfiguration()
   {
      return conf;
   }

   public String getPackagename()
   {
      return "org.rooi.vonk";
   }

   public FreeMarkerEngine getFME()
   {
      return fme;
   }

   synchronized public void addSessie(Sessie se)
   {
      logger.debug("sessionid addSessie " + se.id());
      sessies.put(se.id(), se);
   }

   synchronized public Sessie getSessie(String id)
   {
      logger.debug("sessionid getSessie "  + id);
      return sessies.get(id);
   }


   @WebSocket
   public static class RediscoverWebSocket
   {
      public String getCookie(org.eclipse.jetty.websocket.api.Session session, String name)
      {
         UpgradeRequest ur = session.getUpgradeRequest();
         List<HttpCookie> cookies = ur.getCookies();
         if (cookies != null)
         {
            for (HttpCookie cookie: cookies)
            {
               logger.debug("websocketcookie " + cookie.getName() + " " + cookie.getValue());
               if (cookie.getName().equals(name))
               {
                  return cookie.getValue();
               }
            }
            return null;
         }
         else
         {
            return null;
         }
      }

      public Sessie getSessie(org.eclipse.jetty.websocket.api.Session session)
      {
         String cookieval_long = getCookie(session, "JSESSIONID");
         String cookieval = null;
         if (cookieval_long != null)
         {
            logger.debug("sessionid cookie long found " + cookieval_long);
            int last = cookieval_long.indexOf('.');
            if (last != -1)
            {
               cookieval = cookieval_long.substring(0, last);
               logger.debug("sessionid cookie found " + cookieval);
            }
         }
         if (cookieval != null)
         {
            Sessie se = singleMain().getSessie(cookieval);
            if (se != null)
            {
               logger.debug("sessionid sessie found");
               return se;
            }
            else
            {
               logger.debug("sessionid sessie not found");
               return null;
            }
         }
         else
         {
            return null;
         }
      }
      
      // Store sessions if you want to, for example, broadcast a message to all users
      //private static final Queue<Session> sessions = new ConcurrentLinkedQueue<>();

      @OnWebSocketConnect
      public void connected(org.eclipse.jetty.websocket.api.Session session)
      {
         logger.debug("RedWebSocket connected");

         // returns null
         //Object obj = ur.getSession();
         //logger.debug("sessieobject " + obj);
         
         Sessie se = getSessie(session);
         if (se != null)
         {
            se.ws_connected(session);
         }
      }

      @OnWebSocketClose
      public void closed(org.eclipse.jetty.websocket.api.Session session, int statusCode, String reason)
      {
         logger.debug("RedWebSocket closed");
         Sessie se = getSessie(session);

         if (se != null)
         {
            se.ws_closed(session, statusCode, reason);
         }
      }

      @OnWebSocketMessage
      public void message(org.eclipse.jetty.websocket.api.Session session, String message) throws IOException
      {
         logger.debug("RedWebSocket got message: " + message);

         Sessie se = getSessie(session);
         if (se != null)
         {
            se.ws_message(session, message);
         }
      }

      @OnWebSocketFrame
      public void frame(org.eclipse.jetty.websocket.api.Session session, Frame frame) throws IOException
      {
         logger.debug("RedWebSocket got frame: " + frame);
         logger.debug("RedWebSocket frame type: " + frame.getType());
         
         if (frame.getType() == Frame.Type.BINARY)
         {
            logger.debug("RedWebSocket frame is binary");
            ByteBuffer bytes = frame.getPayload();
            
            OtpInputStream in = new OtpInputStream(bytes.array());
            try
            {
               //   t1     t2
               // {nitro,{event,click,"login","loginButton"},[{{"loginButton",detail},[]},{"voornaam","aaa"},{"naam","ezr"}]}
               
               OtpErlangObject obj = OtpErlangObject.decode(in);
               logger.debug("RedWebSocket frame decoded " + obj);
               
               if (obj instanceof OtpErlangTuple)
               {
                  OtpErlangTuple t1 = (OtpErlangTuple) obj;
                  logger.debug("RedWebSocket frame is tuple");
                  
                  OtpErlangObject o2 = t1.elementAt(1);
                  if (o2 instanceof OtpErlangTuple)
                  {
                     // t2 is {event, }
                     OtpErlangTuple  t2     = (OtpErlangTuple)  o2;
                     OtpErlangAtom   type   = (OtpErlangAtom)   t2.elementAt(1);
                     OtpErlangString action = (OtpErlangString) t2.elementAt(2);
                     OtpErlangString target = (OtpErlangString) t2.elementAt(3);

                     logger.debug("RedWebSocket event type " + type.atomValue() +
                                        " action " + action.stringValue() + " target " + target.stringValue() );
                     
                     // l1 is source list
                     OtpErlangObject o3 = t1.elementAt(2);
                     if (o3 instanceof OtpErlangList)
                     {
                        OtpErlangList l1 = (OtpErlangList) o3;
                        
                        HashMap<String, String> map = new HashMap<>();
                        for (int i = 0; i<l1.elements().length; i++)
                        {
                           OtpErlangTuple  s    = (OtpErlangTuple) l1.elementAt(i);
                           OtpErlangObject okey = s.elementAt(0);
                           OtpErlangObject oval = s.elementAt(1);
                           
                           if (okey instanceof OtpErlangString && oval instanceof OtpErlangString)
                           {
                              OtpErlangString key = (OtpErlangString) okey;
                              OtpErlangString val = (OtpErlangString) oval;

                              map.put(key.stringValue(), val.stringValue());
                              logger.debug("RedWebSocket key/val " + key.stringValue() + " " + val.stringValue() );
                           }
                        }
                     
                        Sessie se = getSessie(session);
                        if (se != null)
                        {
                           se.ws_event(session, type.atomValue(), action.stringValue(), target.stringValue(), map);
                        }
                     }
                  }
               }
               
            }
            catch (OtpErlangDecodeException e)
            {
               logger.debug("RedWebSocket frame not decoded");
            }
         }
      }
   }

   protected static Sessie setSessie(Request req, Sessie s)
   {
      logger.debug("setSessie");
      logger.debug("sessionid spark " + req.session().id());

      Sessie sv = req.session().attribute("sessie");
      if (sv != null)
      {
         if (s.getClass() != sv.getClass())
         {
            logger.debug("   different class");
            s.set(sv);

            s.setSparkSession(req.session());
            singleMain().addSessie(s);

            req.session().attribute("sessie", s);
            logger.debug("loginok " + s.getLoginok());
            return s;
         }
         else
         {
            logger.debug("   same class");
            logger.debug("loginok " + sv.getLoginok());
            return sv;
         }
      }
      else
      {
         logger.debug("   null and no copy");

         s.setSparkSession(req.session());
         singleMain().addSessie(s);

         req.session().attribute("sessie", s);
         logger.debug("loginok " + s.getLoginok());
         return s;
      }
   }
}

