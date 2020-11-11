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
-module(element_button).
-author('Andrew Zadorozhny').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
   io:format("element_button:render_element ~p~n", [Record]),
   Id = 
   case Record#button.postback of
      undefined ->
         Record#button.id;
      [] ->
         Record#button.id;
      Postback ->
         ID = 
         case Record#button.id of 
            undefined -> 
               nitro:temp_id(); 
            I ->
               I
         end,
         nitro:wire(#event{type=click, postback=Postback, target=ID,
                  source=Record#button.source, delegate=Record#button.delegate }),
         ID
    end,
    wf_tags:emit_tag(<<"button">>, nitro:render(Record#button.body), [
        {<<"id">>, Id},
        {<<"type">>, Record#button.type},
        {<<"name">>, Record#button.name},
        {<<"class">>, Record#button.class},
        {<<"style">>, Record#button.style},
        {<<"onchange">>, Record#button.onchange},
        {<<"onclick">>, Record#button.onclick},
        {<<"disabled">>, if Record#button.disabled == true -> "disabled"; true -> undefined end},
        {<<"value">>, Record#button.value}  | Record#button.data_fields ]).
 */

public class NitroButton extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String autofocus = null;
   private String disabled = null;
   private String form = null;
   private String formaction = null;
   private String formenctype = null;
   private String formmethod = null;
   private String formtarget = null;
   private String formnovalidate = null;
   private String name = null;
   private String type = "button";
   private String value = null;

   static public class B extends NitroElement.B
   {
      private String autofocus = null;
      private String disabled = null;
      private String form = null;
      private String formaction = null;
      private String formenctype = null;
      private String formmethod = null;
      private String formtarget = null;
      private String formnovalidate = null;
      private String name = null;
      private String type = "button";
      private String value = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withAutofocus(String aautofocus)
      {
         autofocus = aautofocus;
      
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

      public B withFormaction(String aformaction)
      {
         formaction = aformaction;
      
         return this;
      }

      public B withFormenctype(String aformenctype)
      {
         formenctype = aformenctype;
      
         return this;
      }

      public B withFormmethod(String aformmethod)
      {
         formmethod = aformmethod;
      
         return this;
      }

      public B withFormtarget(String aformtarget)
      {
         formtarget = aformtarget;
      
         return this;
      }

      public B withFormnovalidate(String aformnovalidate)
      {
         formnovalidate = aformnovalidate;
      
         return this;
      }

      public B withName(String aname)
      {
         name = aname;
      
         return this;
      }

      public B withType(String atype)
      {
         type = atype;
      
         return this;
      }

      public B withValue(String avalue)
      {
         value = avalue;
      
         return this;
      }

      @Override
      public NitroButton body(NitroElement bd)
      {
         body = bd;
         return new NitroButton(this);
      }
   }

   public NitroButton(B b)
   {
      super(b);

      autofocus = b.autofocus;
      disabled = b.disabled;
      form = b.form;
      formaction = b.formaction;
      formenctype = b.formenctype;
      formmethod = b.formmethod;
      formtarget = b.formtarget;
      formnovalidate = b.formnovalidate;
      name = b.name;
      type = b.type;
      value = b.value;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroButton.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("button", bodystr,
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
            { "disabled" , disabled},
            { "form" , form},
            { "formaction" , formaction},
            { "formenctype" , formenctype},
            { "formmethod" , formmethod},
            { "formtarget" , formtarget},
            { "formnovalidate" , formnovalidate},
            { "name" , name},
            { "type" , type},
            { "value" , value},
         });

      return str;
   }
}

