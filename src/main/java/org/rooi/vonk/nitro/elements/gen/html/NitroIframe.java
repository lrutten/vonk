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
-module(element_iframe).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#iframe.accesskey},
      {<<"class">>, Record#iframe.class},
      {<<"contenteditable">>, case Record#iframe.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#iframe.contextmenu},
      {<<"dir">>, case Record#iframe.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#iframe.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#iframe.dropzone},
      {<<"hidden">>, case Record#iframe.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#iframe.id},
      {<<"lang">>, Record#iframe.lang},
      {<<"spellcheck">>, case Record#iframe.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#iframe.style},
      {<<"tabindex">>, Record#iframe.tabindex},
      {<<"title">>, Record#iframe.title},
      {<<"translate">>, case Record#iframe.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"height">>,Record#iframe.height},      
      {<<"sandbox">>,Record#iframe.sandbox},      
      {<<"seamless">>, if Record#iframe.seamless == true -> "seamless"; true -> undefined end},
      {<<"src">>,Record#iframe.src},
      {<<"srcdoc">>,Record#iframe.srcdoc},            
      {<<"name">>,Record#iframe.name},
      {<<"width">>,Record#iframe.width} | Record#iframe.data_fields
    ],
    wf_tags:emit_tag(<<"iframe">>, [], List).
 */

public class NitroIframe extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String height = null;
   private String name = null;
   private String sandbox = null;
   private String seamless = null;
   private String src = null;
   private String srcdoc = null;
   private String width = null;

   static public class B extends NitroElement.B
   {
      private String height = null;
      private String name = null;
      private String sandbox = null;
      private String seamless = null;
      private String src = null;
      private String srcdoc = null;
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

      public B withName(String aname)
      {
         name = aname;
      
         return this;
      }

      public B withSandbox(String asandbox)
      {
         sandbox = asandbox;
      
         return this;
      }

      public B withSeamless(String aseamless)
      {
         seamless = aseamless;
      
         return this;
      }

      public B withSrc(String asrc)
      {
         src = asrc;
      
         return this;
      }

      public B withSrcdoc(String asrcdoc)
      {
         srcdoc = asrcdoc;
      
         return this;
      }

      public B withWidth(String awidth)
      {
         width = awidth;
      
         return this;
      }

      @Override
      public NitroIframe body(NitroElement bd)
      {
         body = bd;
         return new NitroIframe(this);
      }
   }

   public NitroIframe(B b)
   {
      super(b);

      height = b.height;
      name = b.name;
      sandbox = b.sandbox;
      seamless = b.seamless;
      src = b.src;
      srcdoc = b.srcdoc;
      width = b.width;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroIframe.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("iframe", bodystr,
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
            { "name" , name},
            { "sandbox" , sandbox},
            { "seamless" , seamless},
            { "src" , src},
            { "srcdoc" , srcdoc},
            { "width" , width},
         });

      return str;
   }
}

