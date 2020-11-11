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
-module(element_search).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    Id = case Record#search.postback of
        undefined -> Record#search.id;
        Postback ->
          ID = case Record#search.id of
            undefined -> nitro:temp_id();
            I -> I end,
          nitro:wire(#event{type=click, postback=Postback, target=ID,
                  source=Record#search.source, delegate=Record#search.delegate }),
          ID end,
    List = [
      %global
      {<<"accesskey">>, Record#search.accesskey},
      {<<"class">>, Record#search.class},
      {<<"contenteditable">>, case Record#search.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#search.contextmenu},
      {<<"dir">>, case Record#search.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#search.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#search.dropzone},
      {<<"hidden">>, case Record#search.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Id},
      {<<"lang">>, Record#search.lang},
      {<<"spellcheck">>, case Record#search.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#search.style},
      {<<"tabindex">>, Record#search.tabindex},
      {<<"title">>, Record#search.title},
      {<<"translate">>, case Record#search.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"autocomplete">>, case Record#search.autocomplete of true -> "on"; false -> "off"; _ -> undefined end},
      {<<"autofocus">>,if Record#search.autofocus == true -> "autofocus"; true -> undefined end},
      {<<"dirname">>,Record#search.dirname},
      {<<"disabled">>, if Record#search.disabled == true -> "disabled"; true -> undefined end},
      {<<"form">>,Record#search.form},
      {<<"list">>,Record#search.list},
      {<<"maxlength">>,Record#search.maxlength},
      {<<"name">>,Record#search.name},
      {<<"pattern">>,Record#search.pattern},
      {<<"placeholder">>,Record#search.placeholder},
      {<<"readonly">>,if Record#search.readonly == true -> "readonly"; true -> undefined end},      
      {<<"required">>,if Record#search.required == true -> "required"; true -> undefined end},      
      {<<"size">>,Record#search.size},
      {<<"type">>, <<"search">>},
      {<<"value">>, Record#search.value} | Record#search.data_fields
    ],
    wf_tags:emit_tag(<<"input">>, nitro:render(Record#search.body), List).
 */

public class NitroSearch extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String autocomplete = null;
   private String autofocus = null;
   private String dirname = null;
   private String disabled = null;
   private String form = null;
   private String list = null;
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
      private String dirname = null;
      private String disabled = null;
      private String form = null;
      private String list = null;
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
      public NitroSearch body(NitroElement bd)
      {
         body = bd;
         return new NitroSearch(this);
      }
   }

   public NitroSearch(B b)
   {
      super(b);

      autocomplete = b.autocomplete;
      autofocus = b.autofocus;
      dirname = b.dirname;
      disabled = b.disabled;
      form = b.form;
      list = b.list;
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
      logger.debug("NitroSearch.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("search", bodystr,
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
            { "dirname" , dirname},
            { "disabled" , disabled},
            { "form" , form},
            { "list" , list},
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

