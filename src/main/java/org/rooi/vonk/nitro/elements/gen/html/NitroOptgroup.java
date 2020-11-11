package org.rooi.vonk.nitro.elements.gen.html;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.rooi.vonk.nitro.Nitro;
import org.rooi.vonk.nitro.actions.NitroActionEvent;
import org.rooi.vonk.nitro.render.NitroWfTag;
import org.rooi.vonk.nitro.elements.NitroElement;
import org.rooi.vonk.nitro.elements.NitroElement.B;
import org.rooi.vonk.nitro.actions.NitroAction;

public class NitroOptgroup extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String disabled = null;
   private String label = null;

   static public class B extends NitroElement.B
   {
      private String disabled = null;
      private String label = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withDisabled(String adisabled)
      {
         disabled = adisabled;
      
         return this;
      }

      public B withLabel(String alabel)
      {
         label = alabel;
      
         return this;
      }

      @Override
      public NitroOptgroup body(NitroElement bd)
      {
         body = bd;
         return new NitroOptgroup(this);
      }
   }

   public NitroOptgroup(B b)
   {
      super(b);

      disabled = b.disabled;
      label = b.label;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroOptgroup.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("optgroup", bodystr,
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

            { "disabled" , disabled},
            { "label" , label},
         });

      return str;
   }
}

