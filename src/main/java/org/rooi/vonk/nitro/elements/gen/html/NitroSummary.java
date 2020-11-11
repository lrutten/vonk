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
-module(element_summary).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#summary.accesskey},
      {<<"class">>, Record#summary.class},
      {<<"contenteditable">>, case Record#summary.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#summary.contextmenu},
      {<<"dir">>, case Record#summary.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#summary.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#summary.dropzone},
      {<<"hidden">>, case Record#summary.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#summary.id},
      {<<"lang">>, Record#summary.lang},
      {<<"spellcheck">>, case Record#summary.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#summary.style},
      {<<"tabindex">>, Record#summary.tabindex},
      {<<"title">>, Record#summary.title},
      {<<"translate">>, case Record#summary.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end} | Record#summary.data_fields
    ],
    wf_tags:emit_tag(<<"summary">>, nitro:render(case Record#summary.body of undefined -> []; B -> B end), List).
 */

public class NitroSummary extends NitroElement
{
   private static Logger logger = LogManager.getLogger();

   static public class B extends NitroElement.B
   {
      public B(String pid)
      {
         super(pid);
      }

      @Override
      public NitroSummary body(NitroElement bd)
      {
         body = bd;
         return new NitroSummary(this);
      }
   }

   public NitroSummary(B b)
   {
      super(b);
   }

   // has no fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroSummary.render");

      return default_render(ni, "summary");
   }
}

