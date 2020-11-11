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
-module(element_password).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    Id = case Record#password.postback of
        undefined -> Record#password.id;
        Postback ->
          ID = case Record#password.id of
            undefined -> nitro:temp_id();
            I -> I end,
          nitro:wire(#event{type=click, postback=Postback, target=ID,
                  source=Record#password.source, delegate=Record#password.delegate }),
          ID end,
    List = [
      %global
      {<<"accesskey">>, Record#password.accesskey},
      {<<"class">>, Record#password.class},
      {<<"contenteditable">>, case Record#password.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#password.contextmenu},
      {<<"dir">>, case Record#password.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#password.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#password.dropzone},
      {<<"hidden">>, case Record#password.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Id},
      {<<"lang">>, Record#password.lang},
      {<<"spellcheck">>, case Record#password.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#password.style},
      {<<"tabindex">>, Record#password.tabindex},
      {<<"title">>, Record#password.title},
      {<<"translate">>, case Record#password.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec 
      {<<"autocomplete">>, case Record#password.autocomplete of true -> "on"; false -> "off"; _ -> undefined end},      
      {<<"autofocus">>,if Record#password.autofocus == true -> "autofocus"; true -> undefined end},            
      {<<"disabled">>, if Record#password.disabled == true -> "disabled"; true -> undefined end},
      {<<"form">>,Record#password.form},
      {<<"maxlength">>,Record#password.maxlength},
      {<<"name">>,Record#password.name},
      {<<"pattern">>,Record#password.pattern},
      {<<"placeholder">>, Record#password.placeholder},
      {<<"readonly">>,if Record#password.readonly == true -> "readonly"; true -> undefined end},      
      {<<"required">>,if Record#password.required == true -> "required"; true -> undefined end},      
      {<<"size">>,Record#password.size},
      {<<"type">>, <<"password">>},
      {<<"value">>, Record#password.value} | Record#password.data_fields
    ],
    wf_tags:emit_tag(<<"input">>, nitro:render(Record#password.body), List).
 */

public class NitroPassword extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String autocomplete = null;
   private String autofocus = null;
   private String disabled = null;
   private String form = null;
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
      private String disabled = null;
      private String form = null;
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
      public NitroPassword body(NitroElement bd)
      {
         body = bd;
         return new NitroPassword(this);
      }
   }

   public NitroPassword(B b)
   {
      super(b);

      autocomplete = b.autocomplete;
      autofocus = b.autofocus;
      disabled = b.disabled;
      form = b.form;
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
      logger.debug("NitroPassword.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("password", bodystr,
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
            { "disabled" , disabled},
            { "form" , form},
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

