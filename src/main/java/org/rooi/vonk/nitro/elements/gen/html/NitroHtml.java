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
-module(element_html).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#html.accesskey},
      {<<"class">>, Record#html.class},
      {<<"contenteditable">>, case Record#html.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#html.contextmenu},
      {<<"dir">>, case Record#html.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#html.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#html.dropzone},
      {<<"hidden">>, case Record#html.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#html.id},
      {<<"lang">>, Record#html.lang},
      {<<"spellcheck">>, case Record#html.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#html.style},
      {<<"tabindex">>, Record#html.tabindex},
      {<<"title">>, Record#html.title},
      {<<"translate">>, case Record#html.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"manifest">>, Record#html.manifest} | Record#html.data_fields
    ],
    wf_tags:emit_tag(<<"html">>, nitro:render(case Record#html.body of undefined -> []; B -> B end), List).
 */

public class NitroHtml extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String manifest = null;

   static public class B extends NitroElement.B
   {
      private String manifest = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withManifest(String amanifest)
      {
         manifest = amanifest;
      
         return this;
      }

      @Override
      public NitroHtml body(NitroElement bd)
      {
         body = bd;
         return new NitroHtml(this);
      }
   }

   public NitroHtml(B b)
   {
      super(b);

      manifest = b.manifest;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroHtml.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("html", bodystr,
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

            { "manifest" , manifest},
         });

      return str;
   }
}

