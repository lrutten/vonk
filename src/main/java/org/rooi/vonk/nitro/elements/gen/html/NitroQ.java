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
-module(element_q).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#q.accesskey},
      {<<"class">>, Record#q.class},
      {<<"contenteditable">>, case Record#q.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#q.contextmenu},
      {<<"dir">>, case Record#q.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#q.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#q.dropzone},
      {<<"hidden">>, case Record#q.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#q.id},
      {<<"lang">>, Record#q.lang},
      {<<"spellcheck">>, case Record#q.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#q.style},
      {<<"tabindex">>, Record#q.tabindex},
      {<<"title">>, Record#q.title},
      {<<"translate">>, case Record#q.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"cite">>,Record#q.cite} | Record#q.data_fields
    ],
    wf_tags:emit_tag( <<"q">>, nitro:render(case Record#q.body of undefined -> []; B -> B end), List).
 */

public class NitroQ extends NitroElement
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
      public NitroQ body(NitroElement bd)
      {
         body = bd;
         return new NitroQ(this);
      }
   }

   public NitroQ(B b)
   {
      super(b);

      cite = b.cite;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroQ.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("q", bodystr,
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

