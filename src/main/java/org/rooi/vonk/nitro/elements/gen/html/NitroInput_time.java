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
-module(element_input_time).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    Id = case Record#input_time.postback of
        undefined -> Record#input_time.id;
        Postback ->
          ID = case Record#input_time.id of
            undefined -> nitro:temp_id();
            I -> I end,
          nitro:wire(#event{type=click, postback=Postback, target=ID,
                  source=Record#input_time.source, delegate=Record#input_time.delegate }),
          ID end,
    List = [
      %global
      {<<"accesskey">>, Record#input_time.accesskey},
      {<<"class">>, Record#input_time.class},
      {<<"contenteditable">>, case Record#input_time.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#input_time.contextmenu},
      {<<"dir">>, case Record#input_time.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#input_time.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#input_time.dropzone},
      {<<"hidden">>, case Record#input_time.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Id},
      {<<"lang">>, Record#input_time.lang},
      {<<"spellcheck">>, case Record#input_time.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#input_time.style},
      {<<"tabindex">>, Record#input_time.tabindex},
      {<<"title">>, Record#input_time.title},
      {<<"translate">>, case Record#input_time.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"autocomplete">>, case Record#input_time.autocomplete of true -> "on"; false -> "off"; _ -> undefined end},
      {<<"autofocus">>,if Record#input_time.autofocus == true -> "autofocus"; true -> undefined end},
      {<<"disabled">>, if Record#input_time.disabled == true -> "disabled"; true -> undefined end},
      {<<"form">>,Record#input_time.form},
      {<<"list">>,Record#input_time.list},
      {<<"max">>,Record#input_time.max},
      {<<"min">>,Record#input_time.min},
      {<<"name">>,Record#input_time.name},
      {<<"readonly">>,if Record#input_time.readonly == true -> "readonly"; true -> undefined end},
      {<<"required">>,if Record#input_time.required == true -> "required"; true -> undefined end},      
      {<<"step">>,Record#input_time.step},
      {<<"type">>, <<"time">>},
      {<<"value">>, Record#input_time.value} | Record#input_time.data_fields
    ],
    wf_tags:emit_tag(<<"input">>, nitro:render(Record#input_time.body), List).
 */

public class NitroInput_time extends NitroElement
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
   private String step = null;
   private String readonly = null;
   private String required = null;
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
      private String step = null;
      private String readonly = null;
      private String required = null;
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

      public B withStep(String astep)
      {
         step = astep;
      
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

      public B withValue(String avalue)
      {
         value = avalue;
      
         return this;
      }

      @Override
      public NitroInput_time body(NitroElement bd)
      {
         body = bd;
         return new NitroInput_time(this);
      }
   }

   public NitroInput_time(B b)
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
      step = b.step;
      readonly = b.readonly;
      required = b.required;
      value = b.value;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroInput_time.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("input_time", bodystr,
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
            { "step" , step},
            { "readonly" , readonly},
            { "required" , required},
            { "value" , value},
         });

      return str;
   }
}

