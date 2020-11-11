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
-module(element_command).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#command.accesskey},
      {<<"class">>, Record#command.class},
      {<<"contenteditable">>, case Record#command.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#command.contextmenu},
      {<<"dir">>, case Record#command.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#command.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#command.dropzone},
      {<<"hidden">>, case Record#command.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#command.id},
      {<<"lang">>, Record#command.lang},
      {<<"spellcheck">>, case Record#command.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#command.style},
      {<<"tabindex">>, Record#command.tabindex},
      {<<"title">>, Record#command.title},
      {<<"translate">>, case Record#command.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},
      % spec
      {<<"disabled">>, if Record#command.disabled == true -> "disabled"; true -> undefined end},
      {<<"icon">>, Record#command.icon},
      {<<"label">>, Record#command.label},
      {<<"radiogroup">>, Record#command.radiogroup},
      {<<"type">>, case Record#command.type of "command" -> "command"; "radio" -> "radio"; "checkbox" -> "checkbox"; _ -> undefined end} | Record#command.data_fields
    ],
    wf_tags:emit_tag(<<"command">>, List).
 */

public class NitroCommand extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String checked = null;
   private String disabled = null;
   private String icon = null;
   private String label = null;
   private String radiogroup = null;
   private String type = "command";

   static public class B extends NitroElement.B
   {
      private String checked = null;
      private String disabled = null;
      private String icon = null;
      private String label = null;
      private String radiogroup = null;
      private String type = "command";

      public B(String pid)
      {
         super(pid);
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

      public B withIcon(String aicon)
      {
         icon = aicon;
      
         return this;
      }

      public B withLabel(String alabel)
      {
         label = alabel;
      
         return this;
      }

      public B withRadiogroup(String aradiogroup)
      {
         radiogroup = aradiogroup;
      
         return this;
      }

      public B withType(String atype)
      {
         type = atype;
      
         return this;
      }

      @Override
      public NitroCommand body(NitroElement bd)
      {
         body = bd;
         return new NitroCommand(this);
      }
   }

   public NitroCommand(B b)
   {
      super(b);

      checked = b.checked;
      disabled = b.disabled;
      icon = b.icon;
      label = b.label;
      radiogroup = b.radiogroup;
      type = b.type;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroCommand.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("command", bodystr,
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

            { "checked" , checked},
            { "disabled" , disabled},
            { "icon" , icon},
            { "label" , label},
            { "radiogroup" , radiogroup},
            { "type" , type},
         });

      return str;
   }
}

