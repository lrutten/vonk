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
-module(element_colgroup).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#colgroup.accesskey},
      {<<"class">>, Record#colgroup.class},
      {<<"contenteditable">>, case Record#colgroup.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#colgroup.contextmenu},
      {<<"dir">>, case Record#colgroup.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#colgroup.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#colgroup.dropzone},
      {<<"hidden">>, case Record#colgroup.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#colgroup.id},
      {<<"lang">>, Record#colgroup.lang},
      {<<"spellcheck">>, case Record#colgroup.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#colgroup.style},
      {<<"tabindex">>, Record#colgroup.tabindex},
      {<<"title">>, Record#colgroup.title},
      {<<"translate">>, case Record#colgroup.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"span">>,Record#colgroup.span} | Record#colgroup.data_fields
    ],
    wf_tags:emit_tag(<<"colgroup">>, nitro:render(case Record#colgroup.body of undefined -> []; B -> B end), List).
 */

public class NitroColgroup extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String col = null;
   private String span = null;

   static public class B extends NitroElement.B
   {
      private String col = null;
      private String span = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withCol(String acol)
      {
         col = acol;
      
         return this;
      }

      public B withSpan(String aspan)
      {
         span = aspan;
      
         return this;
      }

      @Override
      public NitroColgroup body(NitroElement bd)
      {
         body = bd;
         return new NitroColgroup(this);
      }
   }

   public NitroColgroup(B b)
   {
      super(b);

      col = b.col;
      span = b.span;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroColgroup.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("colgroup", bodystr,
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

            { "col" , col},
            { "span" , span},
         });

      return str;
   }
}

