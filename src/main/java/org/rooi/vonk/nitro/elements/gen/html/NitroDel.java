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
-module(element_del).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#del.accesskey},
      {<<"class">>, Record#del.class},
      {<<"contenteditable">>, case Record#del.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#del.contextmenu},
      {<<"dir">>, case Record#del.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#del.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#del.dropzone},
      {<<"hidden">>, case Record#del.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#del.id},
      {<<"lang">>, Record#del.lang},
      {<<"spellcheck">>, case Record#del.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#del.style},
      {<<"tabindex">>, Record#del.tabindex},
      {<<"title">>, Record#del.title},
      {<<"translate">>, case Record#del.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"cite">>, Record#del.cite},
      {<<"datetime">>, Record#del.datetime} | Record#del.data_fields
    ],
    wf_tags:emit_tag(<<"del">>, nitro:render(case Record#del.body of undefined -> []; B -> B end), List).
 */

public class NitroDel extends NitroElement
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
      public NitroDel body(NitroElement bd)
      {
         body = bd;
         return new NitroDel(this);
      }
   }

   public NitroDel(B b)
   {
      super(b);

      cite = b.cite;
      datetime = b.datetime;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroDel.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("del", bodystr,
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

