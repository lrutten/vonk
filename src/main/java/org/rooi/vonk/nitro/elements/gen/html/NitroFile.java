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
-module(element_file).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    Id = case Record#file.postback of
        undefined -> Record#file.id;
        Postback ->
          ID = case Record#file.id of
            undefined -> nitro:temp_id();
            I -> I end,
          nitro:wire(#event{type=click, postback=Postback, target=ID,
                  source=Record#file.source, delegate=Record#file.delegate }),
          ID end,
    List = [
      %global
      {<<"accesskey">>, Record#file.accesskey},
      {<<"class">>, Record#file.class},
      {<<"contenteditable">>, case Record#file.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#file.contextmenu},
      {<<"dir">>, case Record#file.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#file.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#file.dropzone},
      {<<"hidden">>, case Record#file.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Id},
      {<<"lang">>, Record#file.lang},
      {<<"spellcheck">>, case Record#file.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#file.style},
      {<<"tabindex">>, Record#file.tabindex},
      {<<"title">>, Record#file.title},
      {<<"translate">>, case Record#file.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"accept">>,Record#file.accept},
      {<<"autofocus">>,if Record#file.autofocus == true -> "autofocus"; true -> undefined end},
      {<<"disabled">>, if Record#file.disabled == true -> "disabled"; true -> undefined end},
      {<<"form">>,Record#file.form},
      {<<"multiple">>,if Record#file.multiple == true -> "multiple"; true -> undefined end},
      {<<"name">>,Record#file.name},
      {<<"required">>,if Record#file.required == true -> "required"; true -> undefined end}, 
      {<<"type">>, <<"file">>} | Record#file.data_fields
    ],
    wf_tags:emit_tag(<<"input">>, nitro:render(Record#file.body), List).
 */

public class NitroFile extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String accept = null;
   private String autofocus = null;
   private String disabled = null;
   private String form = null;
   private String multiple = null;
   private String name = null;
   private String required = null;

   static public class B extends NitroElement.B
   {
      private String accept = null;
      private String autofocus = null;
      private String disabled = null;
      private String form = null;
      private String multiple = null;
      private String name = null;
      private String required = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withAccept(String aaccept)
      {
         accept = aaccept;
      
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

      public B withRequired(String arequired)
      {
         required = arequired;
      
         return this;
      }

      @Override
      public NitroFile body(NitroElement bd)
      {
         body = bd;
         return new NitroFile(this);
      }
   }

   public NitroFile(B b)
   {
      super(b);

      accept = b.accept;
      autofocus = b.autofocus;
      disabled = b.disabled;
      form = b.form;
      multiple = b.multiple;
      name = b.name;
      required = b.required;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroFile.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("file", bodystr,
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

            { "accept" , accept},
            { "autofocus" , autofocus},
            { "disabled" , disabled},
            { "form" , form},
            { "multiple" , multiple},
            { "name" , name},
            { "required" , required},
         });

      return str;
   }
}

