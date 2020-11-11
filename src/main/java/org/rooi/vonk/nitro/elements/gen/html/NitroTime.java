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
-module(element_time).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#time.accesskey},
      {<<"class">>, Record#time.class},
      {<<"contenteditable">>, case Record#time.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#time.contextmenu},
      {<<"dir">>, case Record#time.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#time.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#time.dropzone},
      {<<"hidden">>, case Record#time.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#time.id},
      {<<"lang">>, Record#time.lang},
      {<<"spellcheck">>, case Record#time.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#time.style},
      {<<"tabindex">>, Record#time.tabindex},
      {<<"title">>, Record#time.title},
      {<<"translate">>, case Record#time.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"datetime">>,Record#time.datetime} | Record#time.data_fields
    ],
    wf_tags:emit_tag(<<"time">>, nitro:render(Record#time.body), List).
 */

public class NitroTime extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String datetime = null;

   static public class B extends NitroElement.B
   {
      private String datetime = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withDatetime(String adatetime)
      {
         datetime = adatetime;
      
         return this;
      }

      @Override
      public NitroTime body(NitroElement bd)
      {
         body = bd;
         return new NitroTime(this);
      }
   }

   public NitroTime(B b)
   {
      super(b);

      datetime = b.datetime;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroTime.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("time", bodystr,
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

            { "datetime" , datetime},
         });

      return str;
   }
}

