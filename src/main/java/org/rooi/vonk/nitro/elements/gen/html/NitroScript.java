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
-module(element_script).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#script.accesskey},
      {<<"class">>, Record#script.class},
      {<<"contenteditable">>, case Record#script.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#script.contextmenu},
      {<<"dir">>, case Record#script.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#script.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#script.dropzone},
      {<<"hidden">>, case Record#script.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#script.id},
      {<<"lang">>, Record#script.lang},
      {<<"spellcheck">>, case Record#script.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#script.style},
      {<<"tabindex">>, Record#script.tabindex},
      {<<"title">>, Record#script.title},
      {<<"translate">>, case Record#script.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"async">>, if Record#script.async == true -> "async"; true -> undefined end},
      {<<"charset">>,Record#script.charset},
      {<<"defer">>, if Record#script.defer == true -> "defer"; true -> undefined end},
      {<<"src">>,Record#script.src},
      {<<"type">>,Record#script.type} | Record#script.data_fields
    ],
    wf_tags:emit_tag(<<"script">>,
      case Record#script.src of
           [] -> nitro:render(case Record#script.body of undefined -> []; B -> B end);
           _ -> [] end, List).
 */

public class NitroScript extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String async = "[]";
   private String charset = "[]";
   private String defer = "[]";
   private String src = "[]";
   private String type = "[]";

   static public class B extends NitroElement.B
   {
      private String async = "[]";
      private String charset = "[]";
      private String defer = "[]";
      private String src = "[]";
      private String type = "[]";

      public B(String pid)
      {
         super(pid);
      }

      public B withAsync(String aasync)
      {
         async = aasync;
      
         return this;
      }

      public B withCharset(String acharset)
      {
         charset = acharset;
      
         return this;
      }

      public B withDefer(String adefer)
      {
         defer = adefer;
      
         return this;
      }

      public B withSrc(String asrc)
      {
         src = asrc;
      
         return this;
      }

      public B withType(String atype)
      {
         type = atype;
      
         return this;
      }

      @Override
      public NitroScript body(NitroElement bd)
      {
         body = bd;
         return new NitroScript(this);
      }
   }

   public NitroScript(B b)
   {
      super(b);

      async = b.async;
      charset = b.charset;
      defer = b.defer;
      src = b.src;
      type = b.type;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroScript.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("script", bodystr,
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

            { "async" , async},
            { "charset" , charset},
            { "defer" , defer},
            { "src" , src},
            { "type" , type},
         });

      return str;
   }
}

