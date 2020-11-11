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
-module(element_ins).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#ins.accesskey},
      {<<"class">>, Record#ins.class},
      {<<"contenteditable">>, case Record#ins.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#ins.contextmenu},
      {<<"dir">>, case Record#ins.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#ins.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#ins.dropzone},
      {<<"hidden">>, case Record#ins.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#ins.id},
      {<<"lang">>, Record#ins.lang},
      {<<"spellcheck">>, case Record#ins.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#ins.style},
      {<<"tabindex">>, Record#ins.tabindex},
      {<<"title">>, Record#ins.title},
      {<<"translate">>, case Record#ins.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"cite">>, Record#ins.cite},
      {<<"datetime">>, Record#ins.datetime} | Record#ins.data_fields
    ],
    wf_tags:emit_tag(<<"ins">>, nitro:render(case Record#ins.body of undefined -> []; B -> B end), List).
 */

public class NitroIns extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String cite = null;
   private String datetime = null;

   static public class B extends NitroElement.B
   {
      private String cite = null;
      private String datetime = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withCite(String acite)
      {
         cite = acite;
      
         return this;
      }

      public B withDatetime(String adatetime)
      {
         datetime = adatetime;
      
         return this;
      }

      @Override
      public NitroIns body(NitroElement bd)
      {
         body = bd;
         return new NitroIns(this);
      }
   }

   public NitroIns(B b)
   {
      super(b);

      cite = b.cite;
      datetime = b.datetime;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroIns.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("ins", bodystr,
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
            { "datetime" , datetime},
         });

      return str;
   }
}

