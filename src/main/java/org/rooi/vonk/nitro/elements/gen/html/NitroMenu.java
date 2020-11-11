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
-module(element_menu).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#menu.accesskey},
      {<<"class">>, Record#menu.class},
      {<<"contenteditable">>, case Record#menu.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#menu.contextmenu},
      {<<"dir">>, case Record#menu.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#menu.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#menu.dropzone},
      {<<"hidden">>, case Record#menu.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#menu.id},
      {<<"lang">>, Record#menu.lang},
      {<<"spellcheck">>, case Record#menu.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#menu.style},
      {<<"tabindex">>, Record#menu.tabindex},
      {<<"title">>, Record#menu.title},
      {<<"translate">>, case Record#menu.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"label">>, Record#menu.label},
      {<<"type">>, case Record#menu.type of "toolbar" -> "toolbar"; "context" -> "context"; _ -> undefined end} | Record#menu.data_fields
    ],
    wf_tags:emit_tag(<<"menu">>, nitro:render(case Record#menu.body of undefined -> []; B -> B end), List).
 */

public class NitroMenu extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String label = null;
   private String type = null;

   static public class B extends NitroElement.B
   {
      private String label = null;
      private String type = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withLabel(String alabel)
      {
         label = alabel;
      
         return this;
      }

      public B withType(String atype)
      {
         type = atype;
      
         return this;
      }

      @Override
      public NitroMenu body(NitroElement bd)
      {
         body = bd;
         return new NitroMenu(this);
      }
   }

   public NitroMenu(B b)
   {
      super(b);

      label = b.label;
      type = b.type;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroMenu.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("menu", bodystr,
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

            { "label" , label},
            { "type" , type},
         });

      return str;
   }
}

