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
-module(element_textbox).
-author('Rusty Klophaus').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) -> 
    List = [
      {<<"id">>, Record#textbox.id},
      {<<"type">>, <<"text">>},
      {<<"maxlength">>,Record#textbox.maxlength},
      {<<"style">>,Record#textbox.style},
      {<<"name">>,Record#textbox.name},
      {<<"placeholder">>,Record#textbox.placeholder},
      {<<"value">>, Record#textbox.value},
      {<<"disabled">>,Record#textbox.disabled},
      {<<"autofocus">>,Record#textbox.autofocus},
      {<<"readonly">>,if Record#textbox.readonly == true -> "readonly"; true -> undefined end},
      {<<"required">>,if Record#textbox.required == true -> "required"; true -> undefined end}, 
      {<<"class">>,Record#textbox.class} | Record#textbox.data_fields
  ] ++ case Record#textbox.disabled of undefined -> []; _ -> [{<<"disabled">>,<<"disabled">>}] end,
  wf_tags:emit_tag(<<"input">>, nitro:render(Record#textbox.body), List).

 */

public class NitroTextbox extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String autocomplete = null;
   private String autofocus = null;
   private String dirname = null;
   private String disabled = null;
   private String form = null;
   private String list = null;
   private String maxlength = null;
   private String name = null;
   private String pattern = null;
   private String placeholder = null;
   private String readonly = null;
   private String required = null;
   private String size = null;
   private String value = null;

   static public class B extends NitroElement.B
   {
      private String autocomplete = null;
      private String autofocus = null;
      private String dirname = null;
      private String disabled = null;
      private String form = null;
      private String list = null;
      private String maxlength = null;
      private String name = null;
      private String pattern = null;
      private String placeholder = null;
      private String readonly = null;
      private String required = null;
      private String size = null;
      private String value = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withAutocomplete(String aautocomplete)
      {
         autocomplete = aautocomplete;
      
         return this;
      }

      public B withAutofocus(String aautofocus)
      {
         autofocus = aautofocus;
      
         return this;
      }

      public B withDirname(String adirname)
      {
         dirname = adirname;
      
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

      public B withList(String alist)
      {
         list = alist;
      
         return this;
      }

      public B withMaxlength(String amaxlength)
      {
         maxlength = amaxlength;
      
         return this;
      }

      public B withName(String aname)
      {
         name = aname;
      
         return this;
      }

      public B withPattern(String apattern)
      {
         pattern = apattern;
      
         return this;
      }

      public B withPlaceholder(String aplaceholder)
      {
         placeholder = aplaceholder;
      
         return this;
      }

      public B withReadonly(String areadonly)
      {
         readonly = areadonly;
      
         return this;
      }

      public B withRequired(String arequired)
      {
         required = arequired;
      
         return this;
      }

      public B withSize(String asize)
      {
         size = asize;
      
         return this;
      }

      public B withValue(String avalue)
      {
         value = avalue;
      
         return this;
      }

      @Override
      public NitroTextbox body(NitroElement bd)
      {
         body = bd;
         return new NitroTextbox(this);
      }
   }

   public NitroTextbox(B b)
   {
      super(b);

      autocomplete = b.autocomplete;
      autofocus = b.autofocus;
      dirname = b.dirname;
      disabled = b.disabled;
      form = b.form;
      list = b.list;
      maxlength = b.maxlength;
      name = b.name;
      pattern = b.pattern;
      placeholder = b.placeholder;
      readonly = b.readonly;
      required = b.required;
      size = b.size;
      value = b.value;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroTextbox.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("textbox", bodystr,
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

            { "autocomplete" , autocomplete},
            { "autofocus" , autofocus},
            { "dirname" , dirname},
            { "disabled" , disabled},
            { "form" , form},
            { "list" , list},
            { "maxlength" , maxlength},
            { "name" , name},
            { "pattern" , pattern},
            { "placeholder" , placeholder},
            { "readonly" , readonly},
            { "required" , required},
            { "size" , size},
            { "value" , value},
         });

      return str;
   }
}

