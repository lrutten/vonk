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
-module(element_list).
-author('Rusty Klophaus').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record = #list{}) -> 
  Tag = case Record#list.numbered of true -> <<"ol">>; _ -> <<"ul">> end,

  wf_tags:emit_tag(Tag, nitro:render(Record#list.body), [
    {<<"id">>, Record#list.id},
    {<<"class">>, Record#list.class},
    {<<"style">>, Record#list.style} | Record#list.data_fields
  ]).

 */

public class NitroList extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String numbered = "false";

   static public class B extends NitroElement.B
   {
      private String numbered = "false";

      public B(String pid)
      {
         super(pid);
      }

      public B withNumbered(String anumbered)
      {
         numbered = anumbered;
      
         return this;
      }

      @Override
      public NitroList body(NitroElement bd)
      {
         body = bd;
         return new NitroList(this);
      }
   }

   public NitroList(B b)
   {
      super(b);

      numbered = b.numbered;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroList.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("list", bodystr,
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

            { "numbered" , numbered},
         });

      return str;
   }
}

