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
-module(element_output).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#output.accesskey},
      {<<"class">>, Record#output.class},
      {<<"contenteditable">>, case Record#output.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#output.contextmenu},
      {<<"dir">>, case Record#output.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#output.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#output.dropzone},
      {<<"hidden">>, case Record#output.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#output.id},
      {<<"lang">>, Record#output.lang},
      {<<"spellcheck">>, case Record#output.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#output.style},
      {<<"tabindex">>, Record#output.tabindex},
      {<<"title">>, Record#output.title},
      {<<"translate">>, case Record#output.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"for">>,Record#output.for},
      {<<"form">>,Record#output.form},
      {<<"name">>,Record#output.name} | Record#output.data_fields
    ],
    wf_tags:emit_tag(<<"output">>, nitro:render(case Record#output.body of undefined -> []; B -> B end), List).
 */

public class NitroOutput extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String forr = null;
   private String form = null;
   private String name = null;

   static public class B extends NitroElement.B
   {
      private String forr = null;
      private String form = null;
      private String name = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withFor(String afor)
      {
         forr = afor;
      
         return this;
      }

      public B withForm(String aform)
      {
         form = aform;
      
         return this;
      }

      public B withName(String aname)
      {
         name = aname;
      
         return this;
      }

      @Override
      public NitroOutput body(NitroElement bd)
      {
         body = bd;
         return new NitroOutput(this);
      }
   }

   public NitroOutput(B b)
   {
      super(b);

      forr = b.forr;
      form = b.form;
      name = b.name;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroOutput.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("output", bodystr,
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

            { "for" , forr},
            { "form" , form},
            { "name" , name},
         });

      return str;
   }
}

