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
-module(element_audio).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#audio.accesskey},
      {<<"class">>, Record#audio.class},
      {<<"contenteditable">>, case Record#audio.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#audio.contextmenu},
      {<<"dir">>, case Record#audio.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#audio.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#audio.dropzone},
      {<<"hidden">>, case Record#audio.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#audio.id},
      {<<"lang">>, Record#audio.lang},
      {<<"spellcheck">>, case Record#audio.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#audio.style},
      {<<"tabindex">>, Record#audio.tabindex},
      {<<"title">>, Record#audio.title},
      {<<"translate">>, case Record#audio.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"autoplay">>, case Record#audio.autoplay of true -> "autoplay"; _ -> undefined end},      
      {<<"controls">>, case Record#audio.controls of true -> "controls"; _ -> undefined end},      
      {<<"loop">>, case Record#audio.loop of true -> "loop"; _ -> undefined end},            
      {<<"mediagroup">>, Record#audio.mediagroup},      
      {<<"muted">>, case Record#audio.muted of true -> "muted"; _ -> undefined end},
      {<<"preload">>, case Record#audio.preload of "auto" -> "auto"; "none" -> "none"; "metadata" -> "metadata"; _ -> undefined end},
      {<<"src">>, Record#audio.src},
      {<<"width">>, Record#audio.width} | Record#audio.data_fields
    ],
    wf_tags:emit_tag(<<"audio">>, nitro:render(case Record#audio.body of undefined -> []; B -> B end), List).
 */

public class NitroAudio extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String autoplay = null;
   private String controls = null;
   private String loop = null;
   private String mediagroup = null;
   private String muted = null;
   private String preload = null;
   private String src = null;
   private String width = null;

   static public class B extends NitroElement.B
   {
      private String autoplay = null;
      private String controls = null;
      private String loop = null;
      private String mediagroup = null;
      private String muted = null;
      private String preload = null;
      private String src = null;
      private String width = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withAutoplay(String aautoplay)
      {
         autoplay = aautoplay;
      
         return this;
      }

      public B withControls(String acontrols)
      {
         controls = acontrols;
      
         return this;
      }

      public B withLoop(String aloop)
      {
         loop = aloop;
      
         return this;
      }

      public B withMediagroup(String amediagroup)
      {
         mediagroup = amediagroup;
      
         return this;
      }

      public B withMuted(String amuted)
      {
         muted = amuted;
      
         return this;
      }

      public B withPreload(String apreload)
      {
         preload = apreload;
      
         return this;
      }

      public B withSrc(String asrc)
      {
         src = asrc;
      
         return this;
      }

      public B withWidth(String awidth)
      {
         width = awidth;
      
         return this;
      }

      @Override
      public NitroAudio body(NitroElement bd)
      {
         body = bd;
         return new NitroAudio(this);
      }
   }

   public NitroAudio(B b)
   {
      super(b);

      autoplay = b.autoplay;
      controls = b.controls;
      loop = b.loop;
      mediagroup = b.mediagroup;
      muted = b.muted;
      preload = b.preload;
      src = b.src;
      width = b.width;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroAudio.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("audio", bodystr,
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

            { "autoplay" , autoplay},
            { "controls" , controls},
            { "loop" , loop},
            { "mediagroup" , mediagroup},
            { "muted" , muted},
            { "preload" , preload},
            { "src" , src},
            { "width" , width},
         });

      return str;
   }
}

