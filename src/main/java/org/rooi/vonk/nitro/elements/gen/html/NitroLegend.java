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
-module(element_legend).
-author('Rusty Klophaus').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) -> 
  wf_tags:emit_tag(<<"legend">>, nitro:render(Record#legend.body), [
    {<<"id">>, Record#legend.id},
    {<<"class">>, Record#legend.class},
    {<<"style">>, Record#legend.style} | Record#legend.data_fields
  ]).
 */

public class NitroLegend extends NitroElement
{
   private static Logger logger = LogManager.getLogger();

   static public class B extends NitroElement.B
   {
      public B(String pid)
      {
         super(pid);
      }

      @Override
      public NitroLegend body(NitroElement bd)
      {
         body = bd;
         return new NitroLegend(this);
      }
   }

   public NitroLegend(B b)
   {
      super(b);
   }

   // has no fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroLegend.render");

      return default_render(ni, "legend");
   }
}

