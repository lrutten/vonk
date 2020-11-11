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
-module(element_textarea).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#textarea.accesskey},
      {<<"class">>, Record#textarea.class},
      {<<"contenteditable">>, case Record#textarea.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#textarea.contextmenu},
      {<<"dir">>, case Record#textarea.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#textarea.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#textarea.dropzone},
      {<<"hidden">>, case Record#textarea.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#textarea.id},
      {<<"lang">>, Record#textarea.lang},
      {<<"spellcheck">>, case Record#textarea.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#textarea.style},
      {<<"tabindex">>, Record#textarea.tabindex},
      {<<"title">>, Record#textarea.title},
      {<<"translate">>, case Record#textarea.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"autofocus">>,if Record#textarea.autofocus == true -> "autofocus"; true -> undefined end},
      {<<"cols">>,Record#textarea.cols},
      {<<"dirname">>,Record#textarea.dirname},      
      {<<"disabled">>, if Record#textarea.disabled == true -> "disabled"; true -> undefined end},
      {<<"form">>,Record#textarea.form},
      {<<"maxlength">>,Record#textarea.maxlength},      
      {<<"name">>,Record#textarea.name},
      {<<"placeholder">>,Record#textarea.placeholder},
      {<<"readonly">>,if Record#textarea.readonly == true -> "readonly"; true -> undefined end},
      {<<"required">>,if Record#textarea.required == true -> "required"; true -> undefined end},
      {<<"rows">>,Record#textarea.rows},      
      {<<"form">>,Record#textarea.wrap},
      {<<"value">>,Record#textarea.value},
      {<<"wrap">>, case Record#textarea.wrap of "hard" -> "hard"; "soft" -> "soft"; _ -> undefined end} | Record#textarea.data_fields
    ],
    wf_tags:emit_tag(<<"textarea">>, nitro:render(case Record#textarea.body of undefined -> []; B -> B end), List).
 */

public class NitroTextarea extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String autofocus = null;
   private String cols = null;
   private String dirname = null;
   private String disabled = null;
   private String form = null;
   private String maxlength = null;
   private String name = null;
   private String placeholder = null;
   private String readonly = null;
   private String required = null;
   private String rows = null;
   private String wrap = null;
   private String value = null;

   static public class B extends NitroElement.B
   {
      private String autofocus = null;
      private String cols = null;
      private String dirname = null;
      private String disabled = null;
      private String form = null;
      private String maxlength = null;
      private String name = null;
      private String placeholder = null;
      private String readonly = null;
      private String required = null;
      private String rows = null;
      private String wrap = null;
      private String value = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withAutofocus(String aautofocus)
      {
         autofocus = aautofocus;
      
         return this;
      }

      public B withCols(String acols)
      {
         cols = acols;
      
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

      public B withRows(String arows)
      {
         rows = arows;
      
         return this;
      }

      public B withWrap(String awrap)
      {
         wrap = awrap;
      
         return this;
      }

      public B withValue(String avalue)
      {
         value = avalue;
      
         return this;
      }

      @Override
      public NitroTextarea body(NitroElement bd)
      {
         body = bd;
         return new NitroTextarea(this);
      }
   }

   public NitroTextarea(B b)
   {
      super(b);

      autofocus = b.autofocus;
      cols = b.cols;
      dirname = b.dirname;
      disabled = b.disabled;
      form = b.form;
      maxlength = b.maxlength;
      name = b.name;
      placeholder = b.placeholder;
      readonly = b.readonly;
      required = b.required;
      rows = b.rows;
      wrap = b.wrap;
      value = b.value;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroTextarea.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("textarea", bodystr,
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

            { "autofocus" , autofocus},
            { "cols" , cols},
            { "dirname" , dirname},
            { "disabled" , disabled},
            { "form" , form},
            { "maxlength" , maxlength},
            { "name" , name},
            { "placeholder" , placeholder},
            { "readonly" , readonly},
            { "required" , required},
            { "rows" , rows},
            { "wrap" , wrap},
            { "value" , value},
         });

      return str;
   }
}

