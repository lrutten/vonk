package org.rooi.vonk.nitro.elements.gen.html;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.rooi.vonk.nitro.Nitro;
import org.rooi.vonk.nitro.actions.NitroActionEvent;
import org.rooi.vonk.nitro.render.NitroWfTag;
import org.rooi.vonk.nitro.elements.NitroElement;
import org.rooi.vonk.nitro.elements.NitroElement.B;
import org.rooi.vonk.nitro.actions.NitroAction;

public class NitroSpinner extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String image = "/priv/static/spinner.gif";

   static public class B extends NitroElement.B
   {
      private String image = "/priv/static/spinner.gif";

      public B(String pid)
      {
         super(pid);
      }

      public B withImage(String aimage)
      {
         image = aimage;
      
         return this;
      }

      @Override
      public NitroSpinner body(NitroElement bd)
      {
         body = bd;
         return new NitroSpinner(this);
      }
   }

   public NitroSpinner(B b)
   {
      super(b);

      image = b.image;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroSpinner.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("spinner", bodystr,
         new String[][]
         {
            { "id" ,             id},
            { "class",           klas},
            { "style",           style},
            { "title",           title},
            { "accesskey",       accesskey},
            { "contenteditable", contenteditable},
            { "contextmenu",     contextmenu},
            { "dir",             dir},
            { "draggable",       draggable},
            { "dropzone",        dropzone},
            { "hidden",          hidden},
            { "lang",            lang},
            { "spellcheck",      spellcheck},
            { "translate",       translate},
            { "tabindex",        tabindex},
            { "role",            role},

            { "image" , image},
         });

      return str;
   }
}

