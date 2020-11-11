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
-module(element_style).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#style.accesskey},
      {<<"class">>, Record#style.class},
      {<<"contenteditable">>, case Record#style.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#style.contextmenu},
      {<<"dir">>, case Record#style.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#style.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#style.dropzone},
      {<<"hidden">>, case Record#style.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#style.id},
      {<<"lang">>, Record#style.lang},
      {<<"spellcheck">>, case Record#style.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#style.style},
      {<<"tabindex">>, Record#style.tabindex},
      {<<"title">>, Record#style.title},
      {<<"translate">>, case Record#style.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"media">>, Record#style.media},
      {<<"scoped">>, case Record#style.scoped of true -> "scoped"; _ -> undefined end},      
      {<<"type">>, Record#style.type} | Record#style.data_fields
    ],
    wf_tags:emit_tag(<<"style">>, nitro:render(case Record#style.body of undefined -> []; B -> B end), List).
 */

public class NitroStyle extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String media = null;
   private String scoped = null;
   private String type = null;

   static public class B extends NitroElement.B
   {
      private String media = null;
      private String scoped = null;
      private String type = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withMedia(String amedia)
      {
         media = amedia;
      
         return this;
      }

      public B withScoped(String ascoped)
      {
         scoped = ascoped;
      
         return this;
      }

      public B withType(String atype)
      {
         type = atype;
      
         return this;
      }

      @Override
      public NitroStyle body(NitroElement bd)
      {
         body = bd;
         return new NitroStyle(this);
      }
   }

   public NitroStyle(B b)
   {
      super(b);

      media = b.media;
      scoped = b.scoped;
      type = b.type;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroStyle.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("style", bodystr,
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

            { "media" , media},
            { "scoped" , scoped},
            { "type" , type},
         });

      return str;
   }
}

