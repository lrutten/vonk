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
-module(element_track).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#track.accesskey},
      {<<"class">>, Record#track.class},
      {<<"contenteditable">>, case Record#track.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#track.contextmenu},
      {<<"dir">>, case Record#track.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#track.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#track.dropzone},
      {<<"hidden">>, case Record#track.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#track.id},
      {<<"lang">>, Record#track.lang},
      {<<"spellcheck">>, case Record#track.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#track.style},
      {<<"tabindex">>, Record#track.tabindex},
      {<<"title">>, Record#track.title},
      {<<"translate">>, case Record#track.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"default">>, case Record#track.default of true -> "default"; _ -> undefined end},
      {<<"kind">>, case Record#track.kind of "subtitles" -> "subtitles"; "captions" -> "captions"; "descriptions" -> "descriptions"; "chapters" -> "chapters"; "metadata" -> "metadata"; _ -> undefined end},
      {<<"label">>, Record#track.label},
      {<<"src">>, Record#track.src},
      {<<"srclang">>, Record#track.srclang} | Record#track.data_fields
    ],
    wf_tags:emit_tag(<<"track">>, List).
 */

public class NitroTrack extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String defaultt = null;
   private String kind = null;
   private String label = null;
   private String src = null;
   private String srclang = null;

   static public class B extends NitroElement.B
   {
      private String defaultt = null;
      private String kind = null;
      private String label = null;
      private String src = null;
      private String srclang = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withDefault(String adefault)
      {
         defaultt = adefault;
      
         return this;
      }

      public B withKind(String akind)
      {
         kind = akind;
      
         return this;
      }

      public B withLabel(String alabel)
      {
         label = alabel;
      
         return this;
      }

      public B withSrc(String asrc)
      {
         src = asrc;
      
         return this;
      }

      public B withSrclang(String asrclang)
      {
         srclang = asrclang;
      
         return this;
      }

      @Override
      public NitroTrack body(NitroElement bd)
      {
         body = bd;
         return new NitroTrack(this);
      }
   }

   public NitroTrack(B b)
   {
      super(b);

      defaultt = b.defaultt;
      kind = b.kind;
      label = b.label;
      src = b.src;
      srclang = b.srclang;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroTrack.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("track", bodystr,
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

            { "default" , defaultt},
            { "kind" , kind},
            { "label" , label},
            { "src" , src},
            { "srclang" , srclang},
         });

      return str;
   }
}

