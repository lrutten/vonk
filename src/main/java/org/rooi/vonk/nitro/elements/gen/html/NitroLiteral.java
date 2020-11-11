package org.rooi.vonk.nitro.elements.gen.html;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.rooi.vonk.nitro.Nitro;
import org.rooi.vonk.nitro.actions.NitroActionEvent;
import org.rooi.vonk.nitro.render.NitroWfTag;
import org.rooi.vonk.nitro.elements.NitroElement;
import org.rooi.vonk.nitro.elements.NitroElement.B;
import org.rooi.vonk.nitro.actions.NitroAction;

/*
-module(element_literal).
-author('Rusty Klophaus').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record = #literal{}) ->
	case Record#literal.html_encode of
		true -> nitro:html_encode(Record#literal.body);
		_    -> Record#literal.body
	end.
 */

public class NitroLiteral extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String html_encode = "true";

   static public class B extends NitroElement.B
   {
      private String html_encode = "true";

      public B(String pid)
      {
         super(pid);
      }

      public B withHtml_encode(String ahtml_encode)
      {
         html_encode = ahtml_encode;
      
         return this;
      }

      @Override
      public NitroLiteral body(NitroElement bd)
      {
         body = bd;
         return new NitroLiteral(this);
      }
   }

   public NitroLiteral(B b)
   {
      super(b);

      html_encode = b.html_encode;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroLiteral.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("literal", bodystr,
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

            { "html_encode" , html_encode},
         });

      return str;
   }
}

