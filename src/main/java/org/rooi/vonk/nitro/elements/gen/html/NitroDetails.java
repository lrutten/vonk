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
-module(element_details).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#details.accesskey},
      {<<"class">>, Record#details.class},
      {<<"contenteditable">>, case Record#details.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#details.contextmenu},
      {<<"dir">>, case Record#details.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#details.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#details.dropzone},
      {<<"hidden">>, case Record#details.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#details.id},
      {<<"lang">>, Record#details.lang},
      {<<"spellcheck">>, case Record#details.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#details.style},
      {<<"tabindex">>, Record#details.tabindex},
      {<<"title">>, Record#details.title},
      {<<"translate">>, case Record#details.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"open">>, case Record#details.open of true -> "open"; _ -> undefined end} | Record#details.data_fields
    ],
    wf_tags:emit_tag(<<"details">>, nitro:render(case Record#details.body of undefined -> []; B -> B end), List).
 */

public class NitroDetails extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String open = null;

   static public class B extends NitroElement.B
   {
      private String open = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withOpen(String aopen)
      {
         open = aopen;
      
         return this;
      }

      @Override
      public NitroDetails body(NitroElement bd)
      {
         body = bd;
         return new NitroDetails(this);
      }
   }

   public NitroDetails(B b)
   {
      super(b);

      open = b.open;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroDetails.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("details", bodystr,
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

            { "open" , open},
         });

      return str;
   }
}

