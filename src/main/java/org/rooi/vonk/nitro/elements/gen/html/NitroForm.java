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
-module(element_form).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    ID = case Record#form.id of undefined -> nitro:temp_id(); I->I end,
    case Record#form.postback of
         undefined -> skip;
         Postback -> nitro:wire(#event { type=submit,
                                         target=ID,
                                         postback=Postback,
                                         source=Record#form.source }) end,
    List = [
      %global
      {<<"accesskey">>, Record#form.accesskey},
      {<<"class">>, Record#form.class},
      {<<"contenteditable">>, case Record#form.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#form.contextmenu},
      {<<"dir">>, case Record#form.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#form.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#form.dropzone},
      {<<"hidden">>, case Record#form.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, ID},
      {<<"lang">>, Record#form.lang},
      {<<"spellcheck">>, case Record#form.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#form.style},
      {<<"tabindex">>, Record#form.tabindex},
      {<<"title">>, Record#form.title},
      {<<"translate">>, case Record#form.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},
      % spec
      {<<"accept-charset">>, Record#form.accept_charset},
      {<<"action">>, Record#form.action},
      {<<"autocomplete">>, case Record#form.autocomplete of true -> "on"; false -> "off"; _ -> undefined end},
      {<<"enctype">>, case Record#form.enctype of "application/x-www-form-urlencoded" -> "application/x-www-form-urlencoded"; "multipart/form-data" -> "multipart/form-data"; "text/plain" -> "text/plain"; _ -> undefined end},
      {<<"method">>, case Record#form.method of "post" -> "post"; _ -> "get" end},
      {<<"name">>,Record#form.name},
      {<<"novalidate">>, case Record#form.novalidate of true -> "novalidate"; _ -> undefined end},
      {<<"target">>, Record#form.target} | Record#form.data_fields
    ],
    wf_tags:emit_tag(<<"form">>, nitro:render(Record#form.body), List).
 */

public class NitroForm extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String accept_charset = null;
   private String action = null;
   private String autocomplete = null;
   private String enctype = null;
   private String method = null;
   private String name = null;
   private String novalidate = null;
   private String target = null;

   static public class B extends NitroElement.B
   {
      private String accept_charset = null;
      private String action = null;
      private String autocomplete = null;
      private String enctype = null;
      private String method = null;
      private String name = null;
      private String novalidate = null;
      private String target = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withAccept_charset(String aaccept_charset)
      {
         accept_charset = aaccept_charset;
      
         return this;
      }

      public B withAction(String aaction)
      {
         action = aaction;
      
         return this;
      }

      public B withAutocomplete(String aautocomplete)
      {
         autocomplete = aautocomplete;
      
         return this;
      }

      public B withEnctype(String aenctype)
      {
         enctype = aenctype;
      
         return this;
      }

      public B withMethod(String amethod)
      {
         method = amethod;
      
         return this;
      }

      public B withName(String aname)
      {
         name = aname;
      
         return this;
      }

      public B withNovalidate(String anovalidate)
      {
         novalidate = anovalidate;
      
         return this;
      }

      public B withTarget(String atarget)
      {
         target = atarget;
      
         return this;
      }

      @Override
      public NitroForm body(NitroElement bd)
      {
         body = bd;
         return new NitroForm(this);
      }
   }

   public NitroForm(B b)
   {
      super(b);

      accept_charset = b.accept_charset;
      action = b.action;
      autocomplete = b.autocomplete;
      enctype = b.enctype;
      method = b.method;
      name = b.name;
      novalidate = b.novalidate;
      target = b.target;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroForm.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("form", bodystr,
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

            { "accept_charset" , accept_charset},
            { "action" , action},
            { "autocomplete" , autocomplete},
            { "enctype" , enctype},
            { "method" , method},
            { "name" , name},
            { "novalidate" , novalidate},
            { "target" , target},
         });

      return str;
   }
}

