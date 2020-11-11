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
-module (element_blockquote).
-author('Andrew Zadorozhny').
-include("nitro.hrl").
-compile(export_all).

render_element(Record) ->
  wf_tags:emit_tag(<<"blockquote">>, nitro:render(Record#blockquote.body), [
      {<<"id">>, Record#blockquote.id},
      {<<"class">>, Record#blockquote.class},
      {<<"style">>, Record#blockquote.style},
      {<<"cite">>, Record#blockquote.cite}  | Record#blockquote.data_fields
  ]).
 */

public class NitroBlockquote extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String cite = null;

   static public class B extends NitroElement.B
   {
      private String cite = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withCite(String acite)
      {
         cite = acite;
      
         return this;
      }

      @Override
      public NitroBlockquote body(NitroElement bd)
      {
         body = bd;
         return new NitroBlockquote(this);
      }
   }

   public NitroBlockquote(B b)
   {
      super(b);

      cite = b.cite;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroBlockquote.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("blockquote", bodystr,
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

            { "cite" , cite},
         });

      return str;
   }
}

