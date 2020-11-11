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
-module(element_td).
-include("nitro.hrl").
-compile(export_all).

render_element(Record) ->
  wf_tags:emit_tag(<<"td">>, nitro:render(Record#td.body), [
    {<<"id">>, Record#td.id},
    {<<"class">>, Record#td.class},
    {<<"style">>, Record#td.style},
    {<<"rowspan">>, Record#td.rowspan},
    {<<"bgcolor">>, Record#td.bgcolor},
    {<<"colspan">>, Record#td.colspan},
    {<<"scope">>, Record#td.scope} | Record#td.data_fields
  ]).
 */

public class NitroTd extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String colspan = "1";
   private String headers = null;
   private String rowspan = "1";
   private String scope = null;
   private String bgcolor = null;

   static public class B extends NitroElement.B
   {
      private String colspan = "1";
      private String headers = null;
      private String rowspan = "1";
      private String scope = null;
      private String bgcolor = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withColspan(String acolspan)
      {
         colspan = acolspan;
      
         return this;
      }

      public B withHeaders(String aheaders)
      {
         headers = aheaders;
      
         return this;
      }

      public B withRowspan(String arowspan)
      {
         rowspan = arowspan;
      
         return this;
      }

      public B withScope(String ascope)
      {
         scope = ascope;
      
         return this;
      }

      public B withBgcolor(String abgcolor)
      {
         bgcolor = abgcolor;
      
         return this;
      }

      @Override
      public NitroTd body(NitroElement bd)
      {
         body = bd;
         return new NitroTd(this);
      }
   }

   public NitroTd(B b)
   {
      super(b);

      colspan = b.colspan;
      headers = b.headers;
      rowspan = b.rowspan;
      scope = b.scope;
      bgcolor = b.bgcolor;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroTd.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("td", bodystr,
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

            { "colspan" , colspan},
            { "headers" , headers},
            { "rowspan" , rowspan},
            { "scope" , scope},
            { "bgcolor" , bgcolor},
         });

      return str;
   }
}

