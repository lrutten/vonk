package org.rooi.vonk.sessies;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.nio.ByteBuffer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

import org.rooi.vonk.VonkMain;
//import org.rooi.vonk.model.User;
//import org.rooi.vonk.model.Canopy;
//import org.rooi.vonk.model.Rediscover;

/**
  Abstract base class for all the user sessions. 
 */
public abstract class Sessie
{
   private static Logger logger = LogManager.getLogger();
   protected Map<String, Object> attributes;
   protected VonkMain            mn;
   protected boolean             loginok;
   protected String              username;
   protected Session             spark_session;
   private   org.eclipse.jetty.websocket.api.Session
                                 ws_session;

   public Sessie(VonkMain m)
   {
      mn            = m;
      attributes    = new HashMap<>();
      loginok       = false;
      spark_session = null;
      ws_session    = null;
   }

   public boolean getLoginok()
   {
      return loginok;
   }

   public String getUsername()
   {
      return username;
   }

   public void set(Sessie s)
   {
      attributes = s.attributes;
      loginok    = s.loginok;
      username   = s.username;
   }

   public void setSparkSession(Session se)
   {
      spark_session = se;
   }

   public String id()
   {
      return spark_session.id();
   }

   @Override
   public String toString()
   {
      String un = "";
      if (username != null)
      {
         un = username;
      }
      return this.getClass().getName() + " " + un;
   }

   public void remoteSendBytes(ByteBuffer buf)
   {
      if (ws_session != null)
      {
         if (ws_session.isOpen())
         {
            if (ws_session.getRemote() != null)
            {
               try
               {
                  ws_session.getRemote().sendBytes(buf);
               }
               catch (IOException e)
               {
                  logger.error("ws session exception on send" + e);
               }
               catch (Exception e)
               {
                  logger.error("ws session exception on send" + e);
               }
            }
            else
            {
               logger.error("ws session remote null on send");
            }
         }
         else
         {
            logger.error("ws session remote not open on send");
         }
      }
      else
      {
         logger.error("ws_session null on send");
      }
   }

   public ModelAndView handle_req(Request req, Response res)
   {
      String template = handle(req, res);
      attributes.put("loginok", loginok);
      if (loginok)
      {
         attributes.put("username", username);
      }
      return new ModelAndView(attributes, template);
   }

   public abstract String handle(Request req, Response res);
   
   public void ws_connected(org.eclipse.jetty.websocket.api.Session session)
   {
      logger.info("sessionid ws_connected " + this);
      ws_session = session;
   }

   public void ws_closed(org.eclipse.jetty.websocket.api.Session session, int statusCode, String reason)
   {
      logger.info("sessionid ws_closed " + this);
      ws_session = null;
   }

   public void ws_message(org.eclipse.jetty.websocket.api.Session session, String message)
   {
      logger.info("sessionid ws_message " + this);
   }

   public void ws_event(org.eclipse.jetty.websocket.api.Session session, String type, String action, String target, HashMap<String, String> values)
   {
      logger.info("sessionid ws_event " + this);
   }
}


