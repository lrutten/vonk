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
-module(element_radio).
-author('Rusty Klophaus').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    ID = case Record#radio.id of
        undefined -> nitro:temp_id();
        RadioID -> RadioID
    end,

    case Record#radio.postback of
        undefined -> ignore;
        Postback -> nitro:wire(#event{type=change, postback=Postback, target=ID, delegate=Record#radio.delegate })
    end,

    Content = nitro:render(Record#radio.body),
    TypeChecked = case Record#radio.checked of
         true -> [{<<"checked">>, <<"">>},{<<"type">>, <<"radio">>}];
            _ -> [{<<"type">>, <<"radio">>}] end ++ case Record#radio.disabled of
         true -> [{<<"disabled">>, <<"disabled">>}];
            _ -> [] end,

    [
        wf_tags:emit_tag(<<"input">>, Content, TypeChecked ++ [
            {<<"id">>, ID},
            {<<"value">>, Record#radio.value},
            {<<"name">>, nitro:coalesce([Record#radio.html_name,Record#radio.name])},
            {<<"class">>, Record#radio.class},
            {<<"style">>, Record#radio.style},
            {<<"onclick">>, Record#radio.onclick},
            {<<"required">>,if Record#radio.required == true -> "required"; true -> undefined end}
        ])

    ].
 */

public class NitroRadio extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String autofocus = null;
   private String checked = null;
   private String disabled = null;
   private String form = null;
   private String name = null;
   private String required = null;
   private String value = null;
   private String html_name = null;

   static public class B extends NitroElement.B
   {
      private String autofocus = null;
      private String checked = null;
      private String disabled = null;
      private String form = null;
      private String name = null;
      private String required = null;
      private String value = null;
      private String html_name = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withAutofocus(String aautofocus)
      {
         autofocus = aautofocus;
      
         return this;
      }

      public B withChecked(String achecked)
      {
         checked = achecked;
      
         return this;
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

      public B withRequired(String arequired)
      {
         required = arequired;
      
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
      public NitroRadio body(NitroElement bd)
      {
         body = bd;
         return new NitroRadio(this);
      }
   }

   public NitroRadio(B b)
   {
      super(b);

      autofocus = b.autofocus;
      checked = b.checked;
      disabled = b.disabled;
      form = b.form;
      name = b.name;
      required = b.required;
      value = b.value;
      html_name = b.html_name;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroRadio.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("radio", bodystr,
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

            { "autofocus" , autofocus},
            { "checked" , checked},
            { "disabled" , disabled},
            { "form" , form},
            { "name" , name},
            { "required" , required},
            { "value" , value},
            { "html_name" , html_name},
         });

      return str;
   }
}

