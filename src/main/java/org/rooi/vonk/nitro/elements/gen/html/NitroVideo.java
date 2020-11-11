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
-module(element_video).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#video.accesskey},
      {<<"class">>, Record#video.class},
      {<<"contenteditable">>, case Record#video.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#video.contextmenu},
      {<<"dir">>, case Record#video.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#video.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#video.dropzone},
      {<<"hidden">>, case Record#video.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#video.id},
      {<<"lang">>, Record#video.lang},
      {<<"spellcheck">>, case Record#video.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#video.style},
      {<<"tabindex">>, Record#video.tabindex},
      {<<"title">>, Record#video.title},
      {<<"translate">>, case Record#video.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"autoplay">>, case Record#video.autoplay of true -> "autoplay"; _ -> undefined end},      
      {<<"controls">>, case Record#video.controls of true -> "controls"; _ -> undefined end},      
      {<<"height">>, Record#video.height},      
      {<<"loop">>, case Record#video.loop of true -> "loop"; _ -> undefined end},            
      {<<"mediagroup">>, Record#video.mediagroup},      
      {<<"muted">>, case Record#video.muted of true -> "muted"; _ -> undefined end},
      {<<"poster">>, Record#video.poster},      
      {<<"preload">>, case Record#video.preload of "auto" -> "auto"; "none" -> "none"; "metadata" -> "metadata"; _ -> undefined end},
      {<<"src">>, Record#video.src},     
      {<<"width">>, Record#video.width} | Record#video.data_fields
    ],
    wf_tags:emit_tag(<<"video">>, nitro:render(case Record#video.body of undefined -> []; B -> B end), List).
 */

public class NitroVideo extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String autoplay = null;
   private String controls = null;
   private String height = null;
   private String loop = null;
   private String mediagroup = null;
   private String muted = null;
   private String poster = null;
   private String preload = null;
   private String src = null;
   private String width = null;

   static public class B extends NitroElement.B
   {
      private String autoplay = null;
      private String controls = null;
      private String height = null;
      private String loop = null;
      private String mediagroup = null;
      private String muted = null;
      private String poster = null;
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

      public B withHeight(String aheight)
      {
         height = aheight;
      
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

      public B withPoster(String aposter)
      {
         poster = aposter;
      
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
      public NitroVideo body(NitroElement bd)
      {
         body = bd;
         return new NitroVideo(this);
      }
   }

   public NitroVideo(B b)
   {
      super(b);

      autoplay = b.autoplay;
      controls = b.controls;
      height = b.height;
      loop = b.loop;
      mediagroup = b.mediagroup;
      muted = b.muted;
      poster = b.poster;
      preload = b.preload;
      src = b.src;
      width = b.width;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroVideo.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("video", bodystr,
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
            { "height" , height},
            { "loop" , loop},
            { "mediagroup" , mediagroup},
            { "muted" , muted},
            { "poster" , poster},
            { "preload" , preload},
            { "src" , src},
            { "width" , width},
         });

      return str;
   }
}

