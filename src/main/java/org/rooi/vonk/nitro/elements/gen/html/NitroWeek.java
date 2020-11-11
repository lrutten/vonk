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
-module(element_week).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    Id = case Record#week.postback of
        undefined -> Record#week.id;
        Postback ->
          ID = case Record#week.id of
            undefined -> nitro:temp_id();
            I -> I end,
          nitro:wire(#event{type=click, postback=Postback, target=ID,
                  source=Record#week.source, delegate=Record#week.delegate }),
          ID end,
    List = [
      %global
      {<<"accesskey">>, Record#week.accesskey},
      {<<"class">>, Record#week.class},
      {<<"contenteditable">>, case Record#week.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#week.contextmenu},
      {<<"dir">>, case Record#week.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#week.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#week.dropzone},
      {<<"hidden">>, case Record#week.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Id},
      {<<"lang">>, Record#week.lang},
      {<<"spellcheck">>, case Record#week.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#week.style},
      {<<"tabindex">>, Record#week.tabindex},
      {<<"title">>, Record#week.title},
      {<<"translate">>, case Record#week.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"autocomplete">>, case Record#week.autocomplete of true -> "on"; false -> "off"; _ -> undefined end},
      {<<"autofocus">>,if Record#week.autofocus == true -> "autofocus"; true -> undefined end},
      {<<"disabled">>, if Record#week.disabled == true -> "disabled"; true -> undefined end},
      {<<"form">>,Record#week.form},
      {<<"list">>,Record#week.list},
      {<<"max">>,Record#week.max},
      {<<"min">>,Record#week.min},
      {<<"name">>,Record#week.name},
      {<<"readonly">>,if Record#week.readonly == true -> "readonly"; true -> undefined end},
      {<<"required">>,if Record#week.required == true -> "required"; true -> undefined end},      
      {<<"step">>,Record#week.step},
      {<<"type">>, <<"week">>},
      {<<"value">>, Record#week.value} | Record#week.data_fields
    ],
    wf_tags:emit_tag(<<"input">>, nitro:render(Record#week.body), List).
 */

public class NitroWeek extends NitroElement
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
      public NitroWeek body(NitroElement bd)
      {
         body = bd;
         return new NitroWeek(this);
      }
   }

   public NitroWeek(B b)
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
      readonly = b.readonly;
      required = b.required;
      step = b.step;
      value = b.value;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroWeek.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("week", bodystr,
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
            { "readonly" , readonly},
            { "required" , required},
            { "step" , step},
            { "value" , value},
         });

      return str;
   }
}

