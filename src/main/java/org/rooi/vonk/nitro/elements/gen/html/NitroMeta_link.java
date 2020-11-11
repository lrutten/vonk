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
-module(element_meta_link).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#meta_link.accesskey},
      {<<"class">>, Record#meta_link.class},
      {<<"contenteditable">>, case Record#meta_link.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#meta_link.contextmenu},
      {<<"dir">>, case Record#meta_link.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#meta_link.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#meta_link.dropzone},
      {<<"hidden">>, case Record#meta_link.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#meta_link.id},
      {<<"lang">>, Record#meta_link.lang},
      {<<"spellcheck">>, case Record#meta_link.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#meta_link.style},
      {<<"tabindex">>, Record#meta_link.tabindex},
      {<<"title">>, Record#meta_link.title},
      {<<"translate">>, case Record#meta_link.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"href">>,Record#meta_link.href},
      {<<"hreflang">>,Record#meta_link.hreflang},
      {<<"media">>,Record#meta_link.media},
      {<<"rel">>,Record#meta_link.rel},
      {<<"sizes">>,Record#meta_link.sizes},
      {<<"type">>,Record#meta_link.type} | Record#meta_link.data_fields
    ],
    wf_tags:emit_tag(<<"link">>, List).
 */

public class NitroMeta_link extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String href = null;
   private String hreflang = null;
   private String media = null;
   private String rel = null;
   private String sizes = null;
   private String type = null;

   static public class B extends NitroElement.B
   {
      private String href = null;
      private String hreflang = null;
      private String media = null;
      private String rel = null;
      private String sizes = null;
      private String type = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withHref(String ahref)
      {
         href = ahref;
      
         return this;
      }

      public B withHreflang(String ahreflang)
      {
         hreflang = ahreflang;
      
         return this;
      }

      public B withMedia(String amedia)
      {
         media = amedia;
      
         return this;
      }

      public B withRel(String arel)
      {
         rel = arel;
      
         return this;
      }

      public B withSizes(String asizes)
      {
         sizes = asizes;
      
         return this;
      }

      public B withType(String atype)
      {
         type = atype;
      
         return this;
      }

      @Override
      public NitroMeta_link body(NitroElement bd)
      {
         body = bd;
         return new NitroMeta_link(this);
      }
   }

   public NitroMeta_link(B b)
   {
      super(b);

      href = b.href;
      hreflang = b.hreflang;
      media = b.media;
      rel = b.rel;
      sizes = b.sizes;
      type = b.type;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroMeta_link.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("meta_link", bodystr,
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
            { "hreflang" , hreflang},
            { "media" , media},
            { "rel" , rel},
            { "sizes" , sizes},
            { "type" , type},
         });

      return str;
   }
}

