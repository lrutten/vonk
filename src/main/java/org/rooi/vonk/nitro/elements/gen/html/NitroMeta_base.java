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
-module(element_meta_base).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#base.accesskey},
      {<<"class">>, Record#base.class},
      {<<"contenteditable">>, case Record#base.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#base.contextmenu},
      {<<"dir">>, case Record#base.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#base.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#base.dropzone},
      {<<"hidden">>, case Record#base.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#base.id},
      {<<"lang">>, Record#base.lang},
      {<<"spellcheck">>, case Record#base.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#base.style},
      {<<"tabindex">>, Record#base.tabindex},
      {<<"title">>, Record#base.title},
      {<<"translate">>, case Record#base.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"href">>,Record#base.href},
      {<<"target">>,Record#base.target} | Record#base.data_fields
    ],
    wf_tags:emit_tag(<<"base">>, List).
 */

public class NitroMeta_base extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String href = null;
   private String target = null;

   static public class B extends NitroElement.B
   {
      private String href = null;
      private String target = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withHref(String ahref)
      {
         href = ahref;
      
         return this;
      }

      public B withTarget(String atarget)
      {
         target = atarget;
      
         return this;
      }

      @Override
      public NitroMeta_base body(NitroElement bd)
      {
         body = bd;
         return new NitroMeta_base(this);
      }
   }

   public NitroMeta_base(B b)
   {
      super(b);

      href = b.href;
      target = b.target;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroMeta_base.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("meta_base", bodystr,
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

            { "href" , href},
            { "target" , target},
         });

      return str;
   }
}

