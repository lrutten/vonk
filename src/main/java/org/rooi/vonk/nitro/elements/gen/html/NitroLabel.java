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
-module(element_label).
-author('Rusty Klophaus').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) -> 
  wf_tags:emit_tag(<<"label">>, nitro:render(Record#label.body), [
    {<<"id">>, Record#label.id},
    {<<"class">>, Record#label.class},
    {<<"style">>, Record#label.style},
    {<<"for">>, Record#label.for},
    {<<"onclick">>, Record#label.onclick} | Record#label.data_fields
  ]).
 */

public class NitroLabel extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String forr = null;
   private String form = null;

   static public class B extends NitroElement.B
   {
      private String forr = null;
      private String form = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withFor(String afor)
      {
         forr = afor;
      
         return this;
      }

      public B withForm(String aform)
      {
         form = aform;
      
         return this;
      }

      @Override
      public NitroLabel body(NitroElement bd)
      {
         body = bd;
         return new NitroLabel(this);
      }
   }

   public NitroLabel(B b)
   {
      super(b);

      forr = b.forr;
      form = b.form;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroLabel.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("label", bodystr,
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

            { "for" , forr},
            { "form" , form},
         });

      return str;
   }
}

