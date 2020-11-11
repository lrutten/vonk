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
-module(element_month).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    Id = case Record#month.postback of
        undefined -> Record#month.id;
        Postback ->
          ID = case Record#month.id of
            undefined -> nitro:temp_id();
            I -> I end,
          nitro:wire(#event{type=click, postback=Postback, target=ID,
                  source=Record#month.source, delegate=Record#month.delegate }),
          ID end,
    List = [
      %global
      {<<"accesskey">>, Record#month.accesskey},
      {<<"class">>, Record#month.class},
      {<<"contenteditable">>, case Record#month.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#month.contextmenu},
      {<<"dir">>, case Record#month.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#month.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#month.dropzone},
      {<<"hidden">>, case Record#month.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Id},
      {<<"lang">>, Record#month.lang},
      {<<"spellcheck">>, case Record#month.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#month.style},
      {<<"tabindex">>, Record#month.tabindex},
      {<<"title">>, Record#month.title},
      {<<"translate">>, case Record#month.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"alt">>,Record#month.alt},
      {<<"autofocus">>,if Record#month.autofocus == true -> "autofocus"; true -> undefined end},            
      {<<"disabled">>, if Record#month.disabled == true -> "disabled"; true -> undefined end},
      {<<"form">>,Record#month.form},
      {<<"max">>,Record#month.max},
      {<<"min">>,Record#month.min},      
      {<<"name">>,Record#month.name},
      {<<"readonly">>,if Record#month.readonly == true -> "readonly"; true -> undefined end},      
      {<<"required">>,if Record#month.required == true -> "required"; true -> undefined end},      
      {<<"step">>,Record#month.step},
      {<<"type">>, <<"month">>},
      {<<"value">>, Record#month.value} | Record#month.data_fields
    ],
    wf_tags:emit_tag(<<"input">>, nitro:render(Record#month.body), List).
 */

public class NitroMonth extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String alt = null;
   private String autocomplete = null;
   private String autofocus = null;
   private String disabled = null;
   private String form = null;
   private String list = null;
   private String min = null;
   private String max = null;
   private String name = null;
   private String readonly = null;
   private String required = null;
   private String step = null;
   private String value = null;

   static public class B extends NitroElement.B
   {
      private String alt = null;
      private String autocomplete = null;
      private String autofocus = null;
      private String disabled = null;
      private String form = null;
      private String list = null;
      private String min = null;
      private String max = null;
      private String name = null;
      private String readonly = null;
      private String required = null;
      private String step = null;
      private String value = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withAlt(String aalt)
      {
         alt = aalt;
      
         return this;
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

      public B withMin(String amin)
      {
         min = amin;
      
         return this;
      }

      public B withMax(String amax)
      {
         max = amax;
      
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
      public NitroMonth body(NitroElement bd)
      {
         body = bd;
         return new NitroMonth(this);
      }
   }

   public NitroMonth(B b)
   {
      super(b);

      alt = b.alt;
      autocomplete = b.autocomplete;
      autofocus = b.autofocus;
      disabled = b.disabled;
      form = b.form;
      list = b.list;
      min = b.min;
      max = b.max;
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
      logger.debug("NitroMonth.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("month", bodystr,
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

            { "alt" , alt},
            { "autocomplete" , autocomplete},
            { "autofocus" , autofocus},
            { "disabled" , disabled},
            { "form" , form},
            { "list" , list},
            { "min" , min},
            { "max" , max},
            { "name" , name},
            { "readonly" , readonly},
            { "required" , required},
            { "step" , step},
            { "value" , value},
         });

      return str;
   }
}

