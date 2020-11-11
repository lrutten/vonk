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
-module(element_input_button).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    Id = case Record#input_button.postback of
        undefined -> Record#input_button.id;
        Postback ->
          ID = case Record#input_button.id of
            undefined -> nitro:temp_id();
            I -> I end,
          nitro:wire(#event{type=click, postback=Postback, target=ID,
                  source=Record#input_button.source, delegate=Record#input_button.delegate }),
          ID end,
    List = [
      %global
      {<<"accesskey">>, Record#input_button.accesskey},
      {<<"class">>, Record#input_button.class},
      {<<"contenteditable">>, case Record#input_button.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#input_button.contextmenu},
      {<<"dir">>, case Record#input_button.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#input_button.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#input_button.dropzone},
      {<<"hidden">>, case Record#input_button.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Id},
      {<<"lang">>, Record#input_button.lang},
      {<<"spellcheck">>, case Record#input_button.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#input_button.style},
      {<<"tabindex">>, Record#input_button.tabindex},
      {<<"title">>, Record#input_button.title},
      {<<"translate">>, case Record#input_button.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"autofocus">>,Record#input_button.autofocus},
      {<<"disabled">>, if Record#input_button.disabled == true -> "disabled"; true -> undefined end},
      {<<"name">>,Record#input_button.name},
      {<<"type">>, <<"button">>},
      {<<"value">>, Record#input_button.value} | Record#input_button.data_fields
    ],
    wf_tags:emit_tag(<<"input">>, nitro:render(Record#input_button.body), List).
 */

public class NitroInput_button extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String autofocus = null;
   private String disabled = null;
   private String form = null;
   private String name = null;
   private String value = null;

   static public class B extends NitroElement.B
   {
      private String autofocus = null;
      private String disabled = null;
      private String form = null;
      private String name = null;
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

      @Override
      public NitroInput_button body(NitroElement bd)
      {
         body = bd;
         return new NitroInput_button(this);
      }
   }

   public NitroInput_button(B b)
   {
      super(b);

      autofocus = b.autofocus;
      disabled = b.disabled;
      form = b.form;
      name = b.name;
      value = b.value;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroInput_button.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("input_button", bodystr,
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
            { "disabled" , disabled},
            { "form" , form},
            { "name" , name},
            { "value" , value},
         });

      return str;
   }
}

