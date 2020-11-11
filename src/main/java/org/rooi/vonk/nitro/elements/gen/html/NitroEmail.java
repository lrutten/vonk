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
-module(element_email).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    Id = case Record#email.postback of
        undefined -> Record#email.id;
        Postback ->
          ID = case Record#email.id of
            undefined -> nitro:temp_id();
            I -> I end,
          nitro:wire(#event{type=click, postback=Postback, target=ID,
                  source=Record#email.source, delegate=Record#email.delegate }),
          ID end,
    List = [
      %global
      {<<"accesskey">>, Record#email.accesskey},
      {<<"class">>, Record#email.class},
      {<<"contenteditable">>, case Record#email.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#email.contextmenu},
      {<<"dir">>, case Record#email.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#email.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#email.dropzone},
      {<<"hidden">>, case Record#email.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Id},
      {<<"lang">>, Record#email.lang},
      {<<"spellcheck">>, case Record#email.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#email.style},
      {<<"tabindex">>, Record#email.tabindex},
      {<<"title">>, Record#email.title},
      {<<"translate">>, case Record#email.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"autocomplete">>, case Record#email.autocomplete of true -> "on"; false -> "off"; _ -> undefined end},
      {<<"autofocus">>,if Record#email.autofocus == true -> "autofocus"; true -> undefined end},
      {<<"disabled">>, if Record#email.disabled == true -> "disabled"; true -> undefined end},
      {<<"form">>,Record#email.form},
      {<<"list">>,Record#email.list},
      {<<"maxlength">>,Record#email.maxlength},
      {<<"multiple">>,if Record#email.multiple == true -> "multiple"; true -> undefined end},
      {<<"name">>,Record#email.name},
      {<<"pattern">>,Record#email.pattern},
      {<<"placeholder">>,Record#email.placeholder},
      {<<"readonly">>,if Record#email.readonly == true -> "readonly"; true -> undefined end},
      {<<"required">>,if Record#email.required == true -> "required"; true -> undefined end}, 
      {<<"size">>,Record#email.size},
      {<<"type">>, <<"email">>},
      {<<"value">>, Record#email.value} | Record#email.data_fields
    ],
    wf_tags:emit_tag(<<"input">>, nitro:render(Record#email.body), List).
 */

public class NitroEmail extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String autocomplete = null;
   private String autofocus = null;
   private String disabled = null;
   private String form = null;
   private String list = null;
   private String maxlength = null;
   private String multiple = null;
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
      private String list = null;
      private String maxlength = null;
      private String multiple = null;
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

      public B withMultiple(String amultiple)
      {
         multiple = amultiple;
      
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
      public NitroEmail body(NitroElement bd)
      {
         body = bd;
         return new NitroEmail(this);
      }
   }

   public NitroEmail(B b)
   {
      super(b);

      autocomplete = b.autocomplete;
      autofocus = b.autofocus;
      disabled = b.disabled;
      form = b.form;
      list = b.list;
      maxlength = b.maxlength;
      multiple = b.multiple;
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
      logger.debug("NitroEmail.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("email", bodystr,
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
            { "list" , list},
            { "maxlength" , maxlength},
            { "multiple" , multiple},
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

