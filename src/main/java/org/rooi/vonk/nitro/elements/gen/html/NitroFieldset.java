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
-module(element_fieldset).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#fieldset.accesskey},
      {<<"class">>, Record#fieldset.class},
      {<<"contenteditable">>, case Record#fieldset.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#fieldset.contextmenu},
      {<<"dir">>, case Record#fieldset.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#fieldset.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#fieldset.dropzone},
      {<<"hidden">>, case Record#fieldset.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#fieldset.id},
      {<<"lang">>, Record#fieldset.lang},
      {<<"spellcheck">>, case Record#fieldset.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#fieldset.style},
      {<<"tabindex">>, Record#fieldset.tabindex},
      {<<"title">>, Record#fieldset.title},
      {<<"translate">>, case Record#fieldset.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"disabled">>, if Record#fieldset.disabled == true -> "disabled"; true -> undefined end},
      {<<"form">>,Record#fieldset.form},
      {<<"name">>,Record#fieldset.name} | Record#fieldset.data_fields
    ],
    wf_tags:emit_tag(
      <<"fieldset">>,
      [
        case Record#fieldset.legend of 
          undefined -> [];
          B -> wf_tags:emit_tag(<<"legend">>, nitro:render(B), [])
        end, 
        nitro:render(case Record#fieldset.body of undefined -> []; B -> B end)
      ], 
      List).
 */

public class NitroFieldset extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String disabled = null;
   private String form = null;
   private String name = null;
   private String legend = null;

   static public class B extends NitroElement.B
   {
      private String disabled = null;
      private String form = null;
      private String name = null;
      private String legend = null;

      public B(String pid)
      {
         super(pid);
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

      public B withLegend(String alegend)
      {
         legend = alegend;
      
         return this;
      }

      @Override
      public NitroFieldset body(NitroElement bd)
      {
         body = bd;
         return new NitroFieldset(this);
      }
   }

   public NitroFieldset(B b)
   {
      super(b);

      disabled = b.disabled;
      form = b.form;
      name = b.name;
      legend = b.legend;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroFieldset.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("fieldset", bodystr,
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

            { "disabled" , disabled},
            { "form" , form},
            { "name" , name},
            { "legend" , legend},
         });

      return str;
   }
}

