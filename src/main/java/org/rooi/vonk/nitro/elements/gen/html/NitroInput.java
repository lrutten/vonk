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
-module(element_input).
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    Id = case Record#input.postback of
        undefined -> Record#input.id;
        [] -> Record#input.id;
        Postback ->
          ID = case Record#input.id of
            undefined -> nitro:temp_id();
            I -> I end,
          nitro:wire(#event{type=click, postback=Postback, target=ID,
                  source=Record#input.source, delegate=Record#input.delegate }),
          ID end,
    List = [
      %global
      {<<"accesskey">>, Record#input.accesskey},
      {<<"class">>, Record#input.class},
      {<<"contenteditable">>, case Record#input.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#input.contextmenu},
      {<<"dir">>, case Record#input.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#input.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#input.dropzone},
      {<<"hidden">>, case Record#input.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Id},
      {<<"lang">>, Record#input.lang},
      {<<"spellcheck">>, case Record#input.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#input.style},
      {<<"tabindex">>, Record#input.tabindex},
      {<<"title">>, Record#input.title},
      {<<"translate">>, case Record#input.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"autofocus">>,Record#input.autofocus},
      {<<"disabled">>, if Record#input.disabled == true -> "disabled"; true -> undefined end},
      {<<"name">>,Record#input.name},
      {<<"type">>, Record#input.type},
      {<<"accept">>, Record#input.accept},
      {<<"max">>, Record#input.max},
      {<<"placeholder">>,Record#input.placeholder},
      {<<"min">>, Record#input.min},
      {<<"multiple">>, Record#input.multiple},
      {<<"pattern">>, Record#input.pattern},
      {<<"value">>, Record#input.value},
      {<<"onkeypress">>, Record#input.onkeypress},
      {<<"onkeyup">>, Record#input.onkeyup},
      {<<"onkeydown">>, Record#input.onkeydown},
      {<<"onclick">>, Record#input.onclick},
      {<<"required">>, if Record#input.required == true -> "required"; true -> undefined end},
      {<<"onchange">>, Record#input.onchange} | Record#input.data_fields
    ],
    wf_tags:emit_tag(<<"input">>, nitro:render(Record#input.body), List).
 */

public class NitroInput extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String required = null;
   private String autofocus = null;
   private String disabled = null;
   private String form = null;
   private String name = null;
   private String value = null;
   private String type = "[]";
   private String placeholder = null;
   private String multiple = null;
   private String min = null;
   private String max = null;
   private String pattern = null;
   private String accept = null;

   static public class B extends NitroElement.B
   {
      private String required = null;
      private String autofocus = null;
      private String disabled = null;
      private String form = null;
      private String name = null;
      private String value = null;
      private String type = "[]";
      private String placeholder = null;
      private String multiple = null;
      private String min = null;
      private String max = null;
      private String pattern = null;
      private String accept = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withRequired(String arequired)
      {
         required = arequired;
      
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

      public B withName(String aname)
      {
         name = aname;
      
         return this;
      }

      public B withValue(String avalue)
      {
         value = avalue;
      
         return this;
      }

      public B withType(String atype)
      {
         type = atype;
      
         return this;
      }

      public B withPlaceholder(String aplaceholder)
      {
         placeholder = aplaceholder;
      
         return this;
      }

      public B withMultiple(String amultiple)
      {
         multiple = amultiple;
      
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

      public B withPattern(String apattern)
      {
         pattern = apattern;
      
         return this;
      }

      public B withAccept(String aaccept)
      {
         accept = aaccept;
      
         return this;
      }

      @Override
      public NitroInput body(NitroElement bd)
      {
         body = bd;
         return new NitroInput(this);
      }
   }

   public NitroInput(B b)
   {
      super(b);

      required = b.required;
      autofocus = b.autofocus;
      disabled = b.disabled;
      form = b.form;
      name = b.name;
      value = b.value;
      type = b.type;
      placeholder = b.placeholder;
      multiple = b.multiple;
      min = b.min;
      max = b.max;
      pattern = b.pattern;
      accept = b.accept;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroInput.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("input", bodystr,
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

            { "required" , required},
            { "autofocus" , autofocus},
            { "disabled" , disabled},
            { "form" , form},
            { "name" , name},
            { "value" , value},
            { "type" , type},
            { "placeholder" , placeholder},
            { "multiple" , multiple},
            { "min" , min},
            { "max" , max},
            { "pattern" , pattern},
            { "accept" , accept},
         });

      return str;
   }
}

