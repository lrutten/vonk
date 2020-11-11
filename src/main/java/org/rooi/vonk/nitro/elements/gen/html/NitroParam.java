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
-module(element_param).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#param.accesskey},
      {<<"class">>, Record#param.class},
      {<<"contenteditable">>, case Record#param.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#param.contextmenu},
      {<<"dir">>, case Record#param.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#param.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#param.dropzone},
      {<<"hidden">>, case Record#param.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#param.id},
      {<<"lang">>, Record#param.lang},
      {<<"spellcheck">>, case Record#param.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#param.style},
      {<<"tabindex">>, Record#param.tabindex},
      {<<"title">>, Record#param.title},
      {<<"translate">>, case Record#param.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"name">>,Record#param.name},
      {<<"value">>,Record#param.value} | Record#param.data_fields
    ],
    wf_tags:emit_tag(<<"param">>, List).
 */

public class NitroParam extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String name = null;
   private String value = null;

   static public class B extends NitroElement.B
   {
      private String name = null;
      private String value = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withName(String aname)
      {
         name = aname;
      
         return this;
      }

      public B withValue(String avalue)
      {
         value = avalue;
      
         return this;
      }

      @Override
      public NitroParam body(NitroElement bd)
      {
         body = bd;
         return new NitroParam(this);
      }
   }

   public NitroParam(B b)
   {
      super(b);

      name = b.name;
      value = b.value;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroParam.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("param", bodystr,
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

            { "name" , name},
            { "value" , value},
         });

      return str;
   }
}

