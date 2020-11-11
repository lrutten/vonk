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
-module(element_col).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#col.accesskey},
      {<<"class">>, Record#col.class},
      {<<"contenteditable">>, case Record#col.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#col.contextmenu},
      {<<"dir">>, case Record#col.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#col.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#col.dropzone},
      {<<"hidden">>, case Record#col.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#col.id},
      {<<"lang">>, Record#col.lang},
      {<<"spellcheck">>, case Record#col.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#col.style},
      {<<"tabindex">>, Record#col.tabindex},
      {<<"title">>, Record#col.title},
      {<<"translate">>, case Record#col.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"span">>,Record#col.span} | Record#col.data_fields
    ],
    wf_tags:emit_tag(<<"col">>, nitro:render(case Record#col.body of undefined -> []; B -> B end), List).
 */

public class NitroCol extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String span = null;

   static public class B extends NitroElement.B
   {
      private String span = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withSpan(String aspan)
      {
         span = aspan;
      
         return this;
      }

      @Override
      public NitroCol body(NitroElement bd)
      {
         body = bd;
         return new NitroCol(this);
      }
   }

   public NitroCol(B b)
   {
      super(b);

      span = b.span;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroCol.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("col", bodystr,
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

            { "span" , span},
         });

      return str;
   }
}

