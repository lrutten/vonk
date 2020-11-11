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
-module(element_embed).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#embed.accesskey},
      {<<"class">>, Record#embed.class},
      {<<"contenteditable">>, case Record#embed.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#embed.contextmenu},
      {<<"dir">>, case Record#embed.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#embed.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#embed.dropzone},
      {<<"hidden">>, case Record#embed.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#embed.id},
      {<<"lang">>, Record#embed.lang},
      {<<"spellcheck">>, case Record#embed.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#embed.style},
      {<<"tabindex">>, Record#embed.tabindex},
      {<<"title">>, Record#embed.title},
      {<<"translate">>, case Record#embed.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"height">>,Record#embed.height},      
      {<<"src">>,Record#embed.src},
      {<<"type">>,Record#embed.type},
      {<<"width">>,Record#embed.width} | Record#embed.data_fields
    ],
    wf_tags:emit_tag(<<"embed">>, List).
 */

public class NitroEmbed extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String height = null;
   private String src = null;
   private String type = null;
   private String width = null;

   static public class B extends NitroElement.B
   {
      private String height = null;
      private String src = null;
      private String type = null;
      private String width = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withHeight(String aheight)
      {
         height = aheight;
      
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

      public B withWidth(String awidth)
      {
         width = awidth;
      
         return this;
      }

      @Override
      public NitroEmbed body(NitroElement bd)
      {
         body = bd;
         return new NitroEmbed(this);
      }
   }

   public NitroEmbed(B b)
   {
      super(b);

      height = b.height;
      src = b.src;
      type = b.type;
      width = b.width;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroEmbed.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("embed", bodystr,
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

            { "height" , height},
            { "src" , src},
            { "type" , type},
            { "width" , width},
         });

      return str;
   }
}

