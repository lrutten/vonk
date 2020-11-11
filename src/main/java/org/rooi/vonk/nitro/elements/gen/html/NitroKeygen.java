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
-module(element_keygen).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    Id = case Record#keygen.postback of
        undefined -> Record#keygen.id;
        Postback ->
          ID = case Record#keygen.id of
            undefined -> nitro:temp_id();
            I -> I end,
          nitro:wire(#event{type=click, postback=Postback, target=ID,
                  source=Record#keygen.source, delegate=Record#keygen.delegate }),
          ID end,
    List = [
      %global
      {<<"accesskey">>, Record#keygen.accesskey},
      {<<"class">>, Record#keygen.class},
      {<<"contenteditable">>, case Record#keygen.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#keygen.contextmenu},
      {<<"dir">>, case Record#keygen.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#keygen.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#keygen.dropzone},
      {<<"hidden">>, case Record#keygen.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Id},
      {<<"lang">>, Record#keygen.lang},
      {<<"spellcheck">>, case Record#keygen.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#keygen.style},
      {<<"tabindex">>, Record#keygen.tabindex},
      {<<"title">>, Record#keygen.title},
      {<<"translate">>, case Record#keygen.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"autofocus">>,if Record#keygen.autofocus == true -> "autofocus"; true -> undefined end},
      {<<"challenge">>,Record#keygen.challenge},      
      {<<"disabled">>, if Record#keygen.disabled == true -> "disabled"; true -> undefined end},
      {<<"form">>,Record#keygen.form},
      {<<"keytype">>,<<"rsa">>},
      {<<"name">>,Record#keygen.name} | Record#keygen.data_fields
    ],
    wf_tags:emit_tag(<<"keygen">>, nitro:render(Record#keygen.body), List).
 */

public class NitroKeygen extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String autofocus = null;
   private String challenge = null;
   private String disabled = null;
   private String form = null;
   private String keytype = null;
   private String name = null;

   static public class B extends NitroElement.B
   {
      private String autofocus = null;
      private String challenge = null;
      private String disabled = null;
      private String form = null;
      private String keytype = null;
      private String name = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withAutofocus(String aautofocus)
      {
         autofocus = aautofocus;
      
         return this;
      }

      public B withChallenge(String achallenge)
      {
         challenge = achallenge;
      
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

      public B withKeytype(String akeytype)
      {
         keytype = akeytype;
      
         return this;
      }

      public B withName(String aname)
      {
         name = aname;
      
         return this;
      }

      @Override
      public NitroKeygen body(NitroElement bd)
      {
         body = bd;
         return new NitroKeygen(this);
      }
   }

   public NitroKeygen(B b)
   {
      super(b);

      autofocus = b.autofocus;
      challenge = b.challenge;
      disabled = b.disabled;
      form = b.form;
      keytype = b.keytype;
      name = b.name;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroKeygen.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("keygen", bodystr,
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
            { "challenge" , challenge},
            { "disabled" , disabled},
            { "form" , form},
            { "keytype" , keytype},
            { "name" , name},
         });

      return str;
   }
}

