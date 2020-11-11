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
-module(element_dropdown).
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record = #dropdown{}) -> 
    ID = case Record#dropdown.id of undefined -> nitro:temp_id(); I->I end,
    case Record#dropdown.postback of
         undefined -> skip;
         Postback -> nitro:wire(#event { type=change, postback=Postback, target=ID,
                        source=Record#dropdown.source, delegate=Record#dropdown.delegate } ) end,

    Opts = [wf_tags:emit_tag(<<"option">>, [O#option.label], [
      {<<"disabled">>, O#option.disabled},
      {<<"label">>, O#option.label},
      {<<"selected">>, case O#option.selected of true -> <<"selected">>; _-> undefined end},
      {<<"value">>, O#option.value}
    ])|| O = #option{show_if=Visible} <- Record#dropdown.options, Visible == true],

    wf_tags:emit_tag(<<"select">>, Opts, [
        {<<"id">>, Record#dropdown.id},
        {<<"class">>, Record#dropdown.class},
        {<<"style">>, Record#dropdown.style},
        {<<"name">>, Record#dropdown.name},
        {<<"disabled">>, case Record#dropdown.disabled of true -> <<"disabled">>; _-> undefined end},
        {<<"multiple">>, case Record#dropdown.multiple of true -> <<"multiple">>; _-> undefined end}|
        Record#dropdown.data_fields
    ]).
 */

public class NitroDropdown extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String options = null;
   private String value = null;
   private String multiple = "false";
   private String disabled = "false";
   private String name = null;

   static public class B extends NitroElement.B
   {
      private String options = null;
      private String value = null;
      private String multiple = "false";
      private String disabled = "false";
      private String name = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withOptions(String aoptions)
      {
         options = aoptions;
      
         return this;
      }

      public B withValue(String avalue)
      {
         value = avalue;
      
         return this;
      }

      public B withMultiple(String amultiple)
      {
         multiple = amultiple;
      
         return this;
      }

      public B withDisabled(String adisabled)
      {
         disabled = adisabled;
      
         return this;
      }

      public B withName(String aname)
      {
         name = aname;
      
         return this;
      }

      @Override
      public NitroDropdown body(NitroElement bd)
      {
         body = bd;
         return new NitroDropdown(this);
      }
   }

   public NitroDropdown(B b)
   {
      super(b);

      options = b.options;
      value = b.value;
      multiple = b.multiple;
      disabled = b.disabled;
      name = b.name;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroDropdown.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("dropdown", bodystr,
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

            { "options" , options},
            { "value" , value},
            { "multiple" , multiple},
            { "disabled" , disabled},
            { "name" , name},
         });

      return str;
   }
}

