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
-module(element_tr).
-include("nitro.hrl").
-compile(export_all).

render_element(Record = #tr{postback= Postback}) ->
  Id = case Record#tr.id of undefined -> nitro:temp_id(); I->I end,
  Cursor = case Postback of undefined -> "";
    P -> nitro:wire(#event {type=click, postback=P, target=Id, delegate=Record#tr.delegate}), "cursor:pointer;"
  end,
  wf_tags:emit_tag(<<"tr">>, nitro:render(Record#tr.cells), [
    {<<"id">>, Id},
    {<<"class">>, Record#tr.class},
    {<<"style">>, [Record#tr.style, Cursor]} | Record#tr.data_fields
  ]).
 */

public class NitroTr extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String cells = null;

   static public class B extends NitroElement.B
   {
      private String cells = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withCells(String acells)
      {
         cells = acells;
      
         return this;
      }

      @Override
      public NitroTr body(NitroElement bd)
      {
         body = bd;
         return new NitroTr(this);
      }
   }

   public NitroTr(B b)
   {
      super(b);

      cells = b.cells;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroTr.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("tr", bodystr,
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

            { "cells" , cells},
         });

      return str;
   }
}

