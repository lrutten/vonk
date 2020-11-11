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
-module (element_submit).
-author('Andrew Zadorozhny').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    ID = case Record#submit.id of undefined -> nitro:temp_id(); I->I end,
    case Record#submit.postback of
         undefined -> skip;
         Postback -> nitro:wire(#event { type=click, 
                                      target=ID,
                                      postback=Postback,
                                      source=Record#submit.source }) end,
    case Record#submit.click of
         undefined -> ignore;
         ClickActions -> nitro:wire(#event { target=ID, type=click, actions=ClickActions }) end,
  wf_tags:emit_tag(<<"input">>, [
      {<<"id">>, ID},
      {<<"type">>, <<"submit">>},
      {<<"class">>, Record#submit.class},
      {<<"style">>, Record#submit.style},
      {<<"value">>, Record#submit.body}  | Record#submit.data_fields
  ]).
 */

public class NitroSubmit extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String autofocus = null;
   private String disabled = null;
   private String form = null;
   private String formaction = null;
   private String formenctype = null;
   private String formmethod = null;
   private String formnovalidate = null;
   private String formtarget = null;
   private String name = null;
   private String value = null;
   private String click = null;

   static public class B extends NitroElement.B
   {
      private String autofocus = null;
      private String disabled = null;
      private String form = null;
      private String formaction = null;
      private String formenctype = null;
      private String formmethod = null;
      private String formnovalidate = null;
      private String formtarget = null;
      private String name = null;
      private String value = null;
      private String click = null;

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

      public B withFormaction(String aformaction)
      {
         formaction = aformaction;
      
         return this;
      }

      public B withFormenctype(String aformenctype)
      {
         formenctype = aformenctype;
      
         return this;
      }

      public B withFormmethod(String aformmethod)
      {
         formmethod = aformmethod;
      
         return this;
      }

      public B withFormnovalidate(String aformnovalidate)
      {
         formnovalidate = aformnovalidate;
      
         return this;
      }

      public B withFormtarget(String aformtarget)
      {
         formtarget = aformtarget;
      
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

      public B withClick(String aclick)
      {
         click = aclick;
      
         return this;
      }

      @Override
      public NitroSubmit body(NitroElement bd)
      {
         body = bd;
         return new NitroSubmit(this);
      }
   }

   public NitroSubmit(B b)
   {
      super(b);

      autofocus = b.autofocus;
      disabled = b.disabled;
      form = b.form;
      formaction = b.formaction;
      formenctype = b.formenctype;
      formmethod = b.formmethod;
      formnovalidate = b.formnovalidate;
      formtarget = b.formtarget;
      name = b.name;
      value = b.value;
      click = b.click;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroSubmit.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("submit", bodystr,
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
            { "formaction" , formaction},
            { "formenctype" , formenctype},
            { "formmethod" , formmethod},
            { "formnovalidate" , formnovalidate},
            { "formtarget" , formtarget},
            { "name" , name},
            { "value" , value},
            { "click" , click},
         });

      return str;
   }
}

