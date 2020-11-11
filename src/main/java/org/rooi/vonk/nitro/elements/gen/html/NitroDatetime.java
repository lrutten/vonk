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
-module(element_datetime).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    Id = case Record#datetime.postback of
        undefined -> Record#datetime.id;
        Postback ->
          ID = case Record#datetime.id of
            undefined -> nitro:temp_id();
            I -> I end,
          nitro:wire(#event{type=click, postback=Postback, target=ID,
                  source=Record#datetime.source, delegate=Record#datetime.delegate }),
          ID end,
    List = [
      %global
      {<<"accesskey">>, Record#datetime.accesskey},
      {<<"class">>, Record#datetime.class},
      {<<"contenteditable">>, case Record#datetime.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#datetime.contextmenu},
      {<<"dir">>, case Record#datetime.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#datetime.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#datetime.dropzone},
      {<<"hidden">>, case Record#datetime.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Id},
      {<<"lang">>, Record#datetime.lang},
      {<<"spellcheck">>, case Record#datetime.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#datetime.style},
      {<<"tabindex">>, Record#datetime.tabindex},
      {<<"title">>, Record#datetime.title},
      {<<"translate">>, case Record#datetime.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"autocomplete">>, case Record#datetime.autocomplete of true -> "on"; false -> "off"; _ -> undefined end},
      {<<"autofocus">>,if Record#datetime.autofocus == true -> "autofocus"; true -> undefined end},
      {<<"disabled">>, if Record#datetime.disabled == true -> "disabled"; true -> undefined end},
      {<<"form">>,Record#datetime.form},
      {<<"list">>,Record#datetime.list},
      {<<"max">>,Record#datetime.max},
      {<<"min">>,Record#datetime.min},
      {<<"name">>,Record#datetime.name},
      {<<"readonly">>,if Record#datetime.readonly == true -> "readonly"; true -> undefined end},
      {<<"required">>,if Record#datetime.required == true -> "required"; true -> undefined end},      
      {<<"step">>,Record#datetime.step},
      {<<"type">>, <<"datetime">>},
      {<<"value">>, Record#datetime.value} | Record#datetime.data_fields
    ],
    wf_tags:emit_tag(<<"input">>, nitro:render(Record#datetime.body), List).
 */

public class NitroDatetime extends NitroElement
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
      public NitroDatetime body(NitroElement bd)
      {
         body = bd;
         return new NitroDatetime(this);
      }
   }

   public NitroDatetime(B b)
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
      logger.debug("NitroDatetime.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("datetime", bodystr,
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

