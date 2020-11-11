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
-module(element_reset).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    Id = case Record#reset.postback of
        undefined -> Record#reset.id;
        Postback ->
          ID = case Record#reset.id of
            undefined -> nitro:temp_id();
            I -> I end,
          nitro:wire(#event{type=click, postback=Postback, target=ID,
                  source=Record#reset.source, delegate=Record#reset.delegate }),
          ID end,
    List = [
      %global
      {<<"accesskey">>, Record#reset.accesskey},
      {<<"class">>, Record#reset.class},
      {<<"contenteditable">>, case Record#reset.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#reset.contextmenu},
      {<<"dir">>, case Record#reset.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#reset.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#reset.dropzone},
      {<<"hidden">>, case Record#reset.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Id},
      {<<"lang">>, Record#reset.lang},
      {<<"spellcheck">>, case Record#reset.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#reset.style},
      {<<"tabindex">>, Record#reset.tabindex},
      {<<"title">>, Record#reset.title},
      {<<"translate">>, case Record#reset.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"autofocus">>,if Record#reset.autofocus == true -> "autofocus"; true -> undefined end},            
      {<<"disabled">>, if Record#reset.disabled == true -> "disabled"; true -> undefined end},
      {<<"form">>,Record#reset.form},
      {<<"name">>,Record#reset.name},
      {<<"type">>, <<"reset">>},
      {<<"value">>, Record#reset.value} | Record#reset.data_fields
    ],
    wf_tags:emit_tag(<<"input">>, nitro:render(Record#reset.body), List).
 */

public class NitroReset extends NitroElement
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
      public NitroReset body(NitroElement bd)
      {
         body = bd;
         return new NitroReset(this);
      }
   }

   public NitroReset(B b)
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
      logger.debug("NitroReset.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("reset", bodystr,
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

