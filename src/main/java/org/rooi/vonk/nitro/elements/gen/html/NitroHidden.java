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
-module(element_hidden).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#hidden.accesskey},
      {<<"class">>, Record#hidden.class},
      {<<"contenteditable">>, case Record#hidden.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#hidden.contextmenu},
      {<<"dir">>, case Record#hidden.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#hidden.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#hidden.dropzone},
      {<<"hidden">>, case Record#hidden.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#hidden.id},
      {<<"lang">>, Record#hidden.lang},
      {<<"spellcheck">>, case Record#hidden.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#hidden.style},
      {<<"tabindex">>, Record#hidden.tabindex},
      {<<"title">>, Record#hidden.title},
      {<<"translate">>, case Record#hidden.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"disabled">>, if Record#hidden.disabled == true -> "disabled"; true -> undefined end},
      {<<"form">>,Record#hidden.form},
      {<<"name">>,Record#hidden.name},
      {<<"type">>, <<"hidden">>},
      {<<"value">>, Record#hidden.value} | Record#hidden.data_fields
    ],
    wf_tags:emit_tag(<<"input">>, nitro:render(Record#hidden.body), List).
 */

public class NitroHidden extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String disabled = null;
   private String form = null;
   private String name = null;
   private String value = null;
   private String html_name = null;

   static public class B extends NitroElement.B
   {
      private String disabled = null;
      private String form = null;
      private String name = null;
      private String value = null;
      private String html_name = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withDisabled(String adisabled)
      {
         disabled = adisabled;
      
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

      public B withValue(String avalue)
      {
         value = avalue;
      
         return this;
      }

      public B withHtml_name(String ahtml_name)
      {
         html_name = ahtml_name;
      
         return this;
      }

      @Override
      public NitroHidden body(NitroElement bd)
      {
         body = bd;
         return new NitroHidden(this);
      }
   }

   public NitroHidden(B b)
   {
      super(b);

      disabled = b.disabled;
      form = b.form;
      name = b.name;
      value = b.value;
      html_name = b.html_name;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroHidden.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("hidden", bodystr,
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

            { "disabled" , disabled},
            { "form" , form},
            { "name" , name},
            { "value" , value},
            { "html_name" , html_name},
         });

      return str;
   }
}

