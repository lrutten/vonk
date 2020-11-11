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
-module(element_map).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#map.accesskey},
      {<<"class">>, Record#map.class},
      {<<"contenteditable">>, case Record#map.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#map.contextmenu},
      {<<"dir">>, case Record#map.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#map.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#map.dropzone},
      {<<"hidden">>, case Record#map.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#map.id},
      {<<"lang">>, Record#map.lang},
      {<<"spellcheck">>, case Record#map.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#map.style},
      {<<"tabindex">>, Record#map.tabindex},
      {<<"title">>, Record#map.title},
      {<<"translate">>, case Record#map.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"name">>,Record#map.name} | Record#map.data_fields
    ],
    wf_tags:emit_tag(<<"map">>, nitro:render(case Record#map.body of undefined -> []; B -> B end), List).
 */

public class NitroMap extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String name = null;

   static public class B extends NitroElement.B
   {
      private String name = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withName(String aname)
      {
         name = aname;
      
         return this;
      }

      @Override
      public NitroMap body(NitroElement bd)
      {
         body = bd;
         return new NitroMap(this);
      }
   }

   public NitroMap(B b)
   {
      super(b);

      name = b.name;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroMap.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("map", bodystr,
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

            { "name" , name},
         });

      return str;
   }
}

