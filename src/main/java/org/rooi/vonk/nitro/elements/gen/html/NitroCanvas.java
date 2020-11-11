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
-module(element_canvas).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#canvas.accesskey},
      {<<"class">>, Record#canvas.class},
      {<<"contenteditable">>, case Record#canvas.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#canvas.contextmenu},
      {<<"dir">>, case Record#canvas.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#canvas.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#canvas.dropzone},
      {<<"hidden">>, case Record#canvas.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#canvas.id},
      {<<"lang">>, Record#canvas.lang},
      {<<"spellcheck">>, case Record#canvas.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#canvas.style},
      {<<"tabindex">>, Record#canvas.tabindex},
      {<<"title">>, Record#canvas.title},
      {<<"translate">>, case Record#canvas.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"height">>,Record#canvas.height},
      {<<"width">>,Record#canvas.width} | Record#canvas.data_fields
    ],
    wf_tags:emit_tag(<<"canvas">>, nitro:render(case Record#canvas.body of undefined -> []; B -> B end), List).
 */

public class NitroCanvas extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String height = null;
   private String width = null;

   static public class B extends NitroElement.B
   {
      private String height = null;
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

      public B withWidth(String awidth)
      {
         width = awidth;
      
         return this;
      }

      @Override
      public NitroCanvas body(NitroElement bd)
      {
         body = bd;
         return new NitroCanvas(this);
      }
   }

   public NitroCanvas(B b)
   {
      super(b);

      height = b.height;
      width = b.width;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroCanvas.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("canvas", bodystr,
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
            { "width" , width},
         });

      return str;
   }
}

