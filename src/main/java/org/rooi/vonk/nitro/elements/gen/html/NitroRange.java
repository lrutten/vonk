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
-module(element_range).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    Id = case Record#range.postback of
        undefined -> Record#range.id;
        Postback ->
          ID = case Record#range.id of
            undefined -> nitro:temp_id();
            I -> I end,
          nitro:wire(#event{type=click, postback=Postback, target=ID,
                  source=Record#range.source, delegate=Record#range.delegate }),
          ID end,
    List = [
      %global
      {<<"accesskey">>, Record#range.accesskey},
      {<<"class">>, Record#range.class},
      {<<"contenteditable">>, case Record#range.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#range.contextmenu},
      {<<"dir">>, case Record#range.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#range.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#range.dropzone},
      {<<"hidden">>, case Record#range.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Id},
      {<<"lang">>, Record#range.lang},
      {<<"spellcheck">>, case Record#range.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#range.style},
      {<<"tabindex">>, Record#range.tabindex},
      {<<"title">>, Record#range.title},
      {<<"translate">>, case Record#range.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"autocomplete">>, case Record#range.autocomplete of true -> "on"; false -> "off"; _ -> undefined end},
      {<<"autofocus">>,if Record#range.autofocus == true -> "autofocus"; true -> undefined end},
      {<<"disabled">>, if Record#range.disabled == true -> "disabled"; true -> undefined end},
      {<<"form">>,Record#range.form},
      {<<"list">>,Record#range.list},
      {<<"max">>,Record#range.max},
      {<<"min">>,Record#range.min},
      {<<"name">>,Record#range.name},
      {<<"step">>,Record#range.step},
      {<<"type">>, <<"range">>},
      {<<"value">>, Record#range.value} | Record#range.data_fields
    ],
    wf_tags:emit_tag(<<"input">>, nitro:render(Record#range.body), List).
 */

public class NitroRange extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String autocomplete = null;
   private String autofocus = null;
   private String disabled = null;
   private String form = null;
   private String list = null;
   private String max = "100";
   private String min = "0";
   private String name = null;
   private String step = "1";
   private String value = null;

   static public class B extends NitroElement.B
   {
      private String autocomplete = null;
      private String autofocus = null;
      private String disabled = null;
      private String form = null;
      private String list = null;
      private String max = "100";
      private String min = "0";
      private String name = null;
      private String step = "1";
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

      public B withValue(String avalue)
      {
         value = avalue;
      
         return this;
      }

      @Override
      public NitroRange body(NitroElement bd)
      {
         body = bd;
         return new NitroRange(this);
      }
   }

   public NitroRange(B b)
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
      value = b.value;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroRange.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("range", bodystr,
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
            { "value" , value},
         });

      return str;
   }
}

