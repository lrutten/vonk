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
-module(element_source).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#source.accesskey},
      {<<"class">>, Record#source.class},
      {<<"contenteditable">>, case Record#source.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#source.contextmenu},
      {<<"dir">>, case Record#source.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#source.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#source.dropzone},
      {<<"hidden">>, case Record#source.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#source.id},
      {<<"lang">>, Record#source.lang},
      {<<"spellcheck">>, case Record#source.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#source.style},
      {<<"tabindex">>, Record#source.tabindex},
      {<<"title">>, Record#source.title},
      {<<"translate">>, case Record#source.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"media">>,Record#source.media},
      {<<"type">>,Record#source.type},
      {<<"src">>,Record#source.src} | Record#source.data_fields
    ],
    wf_tags:emit_tag(<<"source">>, List).
 */

public class NitroSource extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String media = null;
   private String src = null;
   private String type = null;

   static public class B extends NitroElement.B
   {
      private String media = null;
      private String src = null;
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

      public B withSrc(String asrc)
      {
         src = asrc;
      
         return this;
      }

      public B withType(String atype)
      {
         type = atype;
      
         return this;
      }

      @Override
      public NitroSource body(NitroElement bd)
      {
         body = bd;
         return new NitroSource(this);
      }
   }

   public NitroSource(B b)
   {
      super(b);

      media = b.media;
      src = b.src;
      type = b.type;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroSource.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("source", bodystr,
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
            { "src" , src},
            { "type" , type},
         });

      return str;
   }
}

