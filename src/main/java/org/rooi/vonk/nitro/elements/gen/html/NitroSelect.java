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
-module(element_select).
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record = #select{}) ->
  ID = case Record#select.id of undefined -> nitro:temp_id(); I->I end,
  case Record#select.postback of
    undefined -> skip;
    Postback -> nitro:wire(#event{ type=change,
                                target=ID,
                                postback=Postback,
                                source=[nitro:to_atom(ID)],
                                delegate=Record#select.delegate }) end,
  Props = [
    {<<"id">>, ID},
    {<<"class">>, Record#select.class},
    {<<"style">>, Record#select.style},
    {<<"name">>, Record#select.name},
    {<<"onchange">>, Record#select.onchange},
    {<<"title">>, Record#select.title},
    {<<"required">>, case Record#select.required of true -> <<"required">>; _-> undefined end},
    {<<"disabled">>, case Record#select.disabled of true -> <<"disabled">>; _-> undefined end},
    {<<"multiple">>, case Record#select.multiple of true -> <<"multiple">>; _-> undefined end} | Record#select.data_fields
  ],
  wf_tags:emit_tag(<<"select">>, nitro:render(Record#select.body),
                                  Props);
render_element(Group = #optgroup{}) ->
  wf_tags:emit_tag(<<"optgroup">>, nitro:render(Group#optgroup.body), [
    {<<"disabled">>, case Group#optgroup.disabled of true-> <<"disabled">>; _-> undefined end},
    {<<"label">>, Group#optgroup.label}
  ]);
render_element(O = #option{}) ->
  wf_tags:emit_tag(<<"option">>, nitro:render(O#option.body), [
    {<<"id">>, O#option.id},
    {<<"disabled">>, case O#option.disabled of true -> <<"disabled">>; _-> undefined end},
    {<<"label">>, O#option.label},
    {<<"title">>, O#option.title},
    {<<"selected">>, case O#option.selected of true -> <<"selected">>; _-> undefined end},
    {<<"value">>, O#option.value} | O#option.data_fields]).
 */

public class NitroSelect extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String autofocus = null;
   private String disabled = null;
   private String form = null;
   private String multiple = null;
   private String name = null;
   private String required = null;
   private String size = null;

   static public class B extends NitroElement.B
   {
      private String autofocus = null;
      private String disabled = null;
      private String form = null;
      private String multiple = null;
      private String name = null;
      private String required = null;
      private String size = null;

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

      public B withSize(String asize)
      {
         size = asize;
      
         return this;
      }

      @Override
      public NitroSelect body(NitroElement bd)
      {
         body = bd;
         return new NitroSelect(this);
      }
   }

   public NitroSelect(B b)
   {
      super(b);

      autofocus = b.autofocus;
      disabled = b.disabled;
      form = b.form;
      multiple = b.multiple;
      name = b.name;
      required = b.required;
      size = b.size;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroSelect.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("select", bodystr,
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
            { "multiple" , multiple},
            { "name" , name},
            { "required" , required},
            { "size" , size},
         });

      return str;
   }
}

