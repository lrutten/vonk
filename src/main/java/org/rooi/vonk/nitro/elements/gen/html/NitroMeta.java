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
-module(element_meta).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#meta.accesskey},
      {<<"class">>, Record#meta.class},
      {<<"contenteditable">>, case Record#meta.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#meta.contextmenu},
      {<<"dir">>, case Record#meta.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#meta.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#meta.dropzone},
      {<<"hidden">>, case Record#meta.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#meta.id},
      {<<"lang">>, Record#meta.lang},
      {<<"spellcheck">>, case Record#meta.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#meta.style},
      {<<"tabindex">>, Record#meta.tabindex},
      {<<"title">>, Record#meta.title},
      {<<"translate">>, case Record#meta.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"charset">>, Record#meta.charset},
      {<<"content">>, Record#meta.content},
      {<<"http_equiv">>, Record#meta.http_equiv},
      {<<"name">>, Record#meta.name},
      {<<"type">>, Record#meta.type} | Record#meta.data_fields
    ],
    wf_tags:emit_tag(<<"meta">>, List).
 */

public class NitroMeta extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String charset = null;
   private String content = null;
   private String http_equiv = null;
   private String name = null;
   private String type = null;

   static public class B extends NitroElement.B
   {
      private String charset = null;
      private String content = null;
      private String http_equiv = null;
      private String name = null;
      private String type = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withCharset(String acharset)
      {
         charset = acharset;
      
         return this;
      }

      public B withContent(String acontent)
      {
         content = acontent;
      
         return this;
      }

      public B withHttp_equiv(String ahttp_equiv)
      {
         http_equiv = ahttp_equiv;
      
         return this;
      }

      public B withName(String aname)
      {
         name = aname;
      
         return this;
      }

      public B withType(String atype)
      {
         type = atype;
      
         return this;
      }

      @Override
      public NitroMeta body(NitroElement bd)
      {
         body = bd;
         return new NitroMeta(this);
      }
   }

   public NitroMeta(B b)
   {
      super(b);

      charset = b.charset;
      content = b.content;
      http_equiv = b.http_equiv;
      name = b.name;
      type = b.type;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroMeta.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("meta", bodystr,
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

            { "charset" , charset},
            { "content" , content},
            { "http_equiv" , http_equiv},
            { "name" , name},
            { "type" , type},
         });

      return str;
   }
}

