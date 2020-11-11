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
-module(element_checkbox).
-author('Rusty Klophaus, Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) -> 
    Id = case Record#checkbox.id of undefined -> nitro:temp_id(); I->I end,
    case Record#checkbox.postback of
        undefined -> ignore;
        Postback -> nitro:wire(#event { type=change, postback=Postback, target=Id, source=Record#checkbox.source, delegate=Record#checkbox.delegate })
    end,
   Label = [ wf_tags:emit_tag(<<"input">>, [], [
      % global
      {<<"accesskey">>, Record#checkbox.accesskey},
      {<<"class">>, Record#checkbox.class},
      {<<"contenteditable">>, case Record#checkbox.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#checkbox.contextmenu},
      {<<"dir">>, case Record#checkbox.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#checkbox.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#checkbox.dropzone},
      {<<"hidden">>, case Record#checkbox.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Id},
      {<<"lang">>, Record#checkbox.lang},
      {<<"spellcheck">>, case Record#checkbox.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#checkbox.style},
      {<<"tabindex">>, Record#checkbox.tabindex},
      {<<"title">>, Record#checkbox.title},
      {<<"translate">>, case Record#checkbox.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"autofocus">>,Record#checkbox.autofocus},
      {<<"checked">>, if Record#checkbox.checked==true -> <<"checked">>; true -> undefined end},
      {<<"data-toggle">>, <<"checkbox">>},
      {<<"disabled">>, if Record#checkbox.disabled == true -> "disabled"; true -> undefined end},
      {<<"form">>, Record#checkbox.form},
      {<<"name">>, Record#checkbox.name},            
      {<<"required">>, if Record#checkbox.required == true -> "required"; true -> undefined end},
      {<<"type">>, <<"checkbox">>},
      {<<"value">>, Record#checkbox.value} | Record#checkbox.data_fields
      ]),
      case Record#checkbox.body of undefined -> []; B -> B end ],
    wf_tags:emit_tag(<<"label">>, nitro:render(Label), [
        {<<"class">>, Record#checkbox.class},
        {<<"style">>, Record#checkbox.style},
        {<<"for">>, Id} ]).
 */

public class NitroCheckbox extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String autofocus = null;
   private String checked = "false";
   private String disabled = null;
   private String form = null;
   private String name = null;
   private String required = null;
   private String value = null;

   static public class B extends NitroElement.B
   {
      private String autofocus = null;
      private String checked = "false";
      private String disabled = null;
      private String form = null;
      private String name = null;
      private String required = null;
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

      public B withChecked(String achecked)
      {
         checked = achecked;
      
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
      public NitroCheckbox body(NitroElement bd)
      {
         body = bd;
         return new NitroCheckbox(this);
      }
   }

   public NitroCheckbox(B b)
   {
      super(b);

      autofocus = b.autofocus;
      checked = b.checked;
      disabled = b.disabled;
      form = b.form;
      name = b.name;
      required = b.required;
      value = b.value;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroCheckbox.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("checkbox", bodystr,
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
            { "checked" , checked},
            { "disabled" , disabled},
            { "form" , form},
            { "name" , name},
            { "required" , required},
            { "value" , value},
         });

      return str;
   }
}

