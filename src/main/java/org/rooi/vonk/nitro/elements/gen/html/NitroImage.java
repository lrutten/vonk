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
-module(element_image).
-author('Rusty Klophaus').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
  Attributes = [
    {<<"id">>, Record#image.id},
    {<<"class">>, Record#image.class},
    {<<"title">>, Record#image.title},
    {<<"style">>, Record#image.style},
    {<<"alt">>, Record#image.alt},
    {<<"width">>, Record#image.width},
    {<<"height">>, Record#image.height},
    {<<"src">>, nitro:coalesce([Record#image.src, Record#image.image])} | Record#image.data_fields
  ],

  wf_tags:emit_tag(<<"img">>, Attributes).
 */

public class NitroImage extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String alt = null;
   private String height = null;
   private String ismap = null;
   private String src = null;
   private String usemap = null;
   private String width = null;
   private String image = null;

   static public class B extends NitroElement.B
   {
      private String alt = null;
      private String height = null;
      private String ismap = null;
      private String src = null;
      private String usemap = null;
      private String width = null;
      private String image = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withAlt(String aalt)
      {
         alt = aalt;
      
         return this;
      }

      public B withHeight(String aheight)
      {
         height = aheight;
      
         return this;
      }

      public B withIsmap(String aismap)
      {
         ismap = aismap;
      
         return this;
      }

      public B withSrc(String asrc)
      {
         src = asrc;
      
         return this;
      }

      public B withUsemap(String ausemap)
      {
         usemap = ausemap;
      
         return this;
      }

      public B withWidth(String awidth)
      {
         width = awidth;
      
         return this;
      }

      public B withImage(String aimage)
      {
         image = aimage;
      
         return this;
      }

      @Override
      public NitroImage body(NitroElement bd)
      {
         body = bd;
         return new NitroImage(this);
      }
   }

   public NitroImage(B b)
   {
      super(b);

      alt = b.alt;
      height = b.height;
      ismap = b.ismap;
      src = b.src;
      usemap = b.usemap;
      width = b.width;
      image = b.image;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroImage.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("image", bodystr,
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

            { "alt" , alt},
            { "height" , height},
            { "ismap" , ismap},
            { "src" , src},
            { "usemap" , usemap},
            { "width" , width},
            { "image" , image},
         });

      return str;
   }
}

