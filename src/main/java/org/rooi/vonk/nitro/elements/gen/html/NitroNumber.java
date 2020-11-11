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
-module(element_number).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    Id = case Record#number.postback of
        undefined -> Record#number.id;
        Postback ->
          ID = case Record#number.id of
            undefined -> nitro:temp_id();
            I -> I end,
          nitro:wire(#event{type=click, postback=Postback, target=ID,
                  source=Record#number.source, delegate=Record#number.delegate }),
          ID end,
    List = [
      %global
      {<<"accesskey">>, Record#number.accesskey},
      {<<"class">>, Record#number.class},
      {<<"contenteditable">>, case Record#number.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#number.contextmenu},
      {<<"dir">>, case Record#number.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#number.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#number.dropzone},
      {<<"hidden">>, case Record#number.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Id},
      {<<"lang">>, Record#number.lang},
      {<<"spellcheck">>, case Record#number.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#number.style},
      {<<"tabindex">>, Record#number.tabindex},
      {<<"title">>, Record#number.title},
      {<<"translate">>, case Record#number.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec      
      {<<"autocomplete">>, case Record#number.autocomplete of true -> "on"; false -> "off"; _ -> undefined end},
      {<<"autofocus">>,if Record#number.autofocus == true -> "autofocus"; true -> undefined end},            
      {<<"disabled">>, if Record#number.disabled == true -> "disabled"; true -> undefined end},
      {<<"form">>,Record#number.form},
      {<<"list">>,Record#number.list},
      {<<"max">>,Record#number.max},
      {<<"min">>,Record#number.min},      
      {<<"name">>,Record#number.name},
      {<<"placeholder">>,Record#number.placeholder},
      {<<"readonly">>,if Record#number.readonly == true -> "readonly"; true -> undefined end},      
      {<<"required">>,if Record#number.required == true -> "required"; true -> undefined end},      
      {<<"step">>,Record#number.step},
      {<<"type">>, <<"number">>},
      {<<"value">>, Record#number.value} | Record#number.data_fields
    ],
    wf_tags:emit_tag(<<"input">>, nitro:render(Record#number.body), List).
 */

public class NitroNumber extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String autocomplete = null;
   private String autofocus = null;
   private String disabled = null;
   private String form = null;
   private String list = null;
   private String max = null;
   private String min = null;
   private String name = null;
   private String placeholder = null;
   private String readonly = null;
   private String required = null;
   private String step = null;
   private String value = null;

   static public class B extends NitroElement.B
   {
      private String autocomplete = null;
      private String autofocus = null;
      private String disabled = null;
      private String form = null;
      private String list = null;
      private String max = null;
      private String min = null;
      private String name = null;
      private String placeholder = null;
      private String readonly = null;
      private String required = null;
      private String step = null;
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

      public B withMax(String amax)
      {
         max = amax;
      
         return this;
      }

      public B withMin(String amin)
      {
         min = amin;
      
         return this;
      }

      public B withName(String aname)
      {
         name = aname;
      
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

      public B withStep(String astep)
      {
         step = astep;
      
         return this;
      }

      public B withValue(String avalue)
      {
         value = avalue;
      
         return this;
      }

      @Override
      public NitroNumber body(NitroElement bd)
      {
         body = bd;
         return new NitroNumber(this);
      }
   }

   public NitroNumber(B b)
   {
      super(b);

      autocomplete = b.autocomplete;
      autofocus = b.autofocus;
      disabled = b.disabled;
      form = b.form;
      list = b.list;
      max = b.max;
      min = b.min;
      name = b.name;
      placeholder = b.placeholder;
      readonly = b.readonly;
      required = b.required;
      step = b.step;
      value = b.value;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroNumber.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("number", bodystr,
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
            { "max" , max},
            { "min" , min},
            { "name" , name},
            { "placeholder" , placeholder},
            { "readonly" , readonly},
            { "required" , required},
            { "step" , step},
            { "value" , value},
         });

      return str;
   }
}

