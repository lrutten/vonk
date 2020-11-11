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
-module(element_progress).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#progress.accesskey},
      {<<"class">>, Record#progress.class},
      {<<"contenteditable">>, case Record#progress.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#progress.contextmenu},
      {<<"dir">>, case Record#progress.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#progress.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#progress.dropzone},
      {<<"hidden">>, case Record#progress.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#progress.id},
      {<<"lang">>, Record#progress.lang},
      {<<"spellcheck">>, case Record#progress.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#progress.style},
      {<<"tabindex">>, Record#progress.tabindex},
      {<<"title">>, Record#progress.title},
      {<<"translate">>, case Record#progress.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"max">>,Record#progress.max},
      {<<"value">>,Record#progress.value} | Record#progress.data_fields
    ],
    wf_tags:emit_tag(<<"progress">>, nitro:render(case Record#progress.body of undefined -> []; B -> B end), List).
 */

public class NitroProgress extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String max = null;
   private String value = null;

   static public class B extends NitroElement.B
   {
      private String max = null;
      private String value = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withMax(String amax)
      {
         max = amax;
      
         return this;
      }

      public B withValue(String avalue)
      {
         value = avalue;
      
         return this;
      }

      @Override
      public NitroProgress body(NitroElement bd)
      {
         body = bd;
         return new NitroProgress(this);
      }
   }

   public NitroProgress(B b)
   {
      super(b);

      max = b.max;
      value = b.value;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroProgress.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("progress", bodystr,
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

            { "max" , max},
            { "value" , value},
         });

      return str;
   }
}

