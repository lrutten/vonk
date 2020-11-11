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
-module(element_area).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#area.accesskey},
      {<<"class">>, Record#area.class},
      {<<"contenteditable">>, case Record#area.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#area.contextmenu},
      {<<"dir">>, case Record#area.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#area.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#area.dropzone},
      {<<"hidden">>, case Record#area.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#area.id},
      {<<"lang">>, Record#area.lang},
      {<<"spellcheck">>, case Record#area.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#area.style},
      {<<"tabindex">>, Record#area.tabindex},
      {<<"title">>, Record#area.title},
      {<<"translate">>, case Record#area.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"alt">>,Record#area.alt},
      {<<"coords">>,Record#area.coords},
      {<<"href">>,Record#area.href},
      {<<"hreflang">>,Record#area.hreflang},
      {<<"media">>,Record#area.media},
      {<<"rel">>,Record#area.rel},
      {<<"shape">>, case Record#area.shape of "rect" -> "rect"; "circle" -> "circle"; "poly" -> "poly"; "default" -> "default"; _ -> undefined end},
      {<<"target">>,Record#area.target},
      {<<"type">>,Record#area.type} | Record#area.data_fields
    ],
    wf_tags:emit_tag(<<"area">>, List).
 */

public class NitroArea extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String alt = null;
   private String coords = null;
   private String href = null;
   private String hreflang = null;
   private String media = null;
   private String target = null;
   private String rel = null;
   private String shape = null;
   private String type = null;

   static public class B extends NitroElement.B
   {
      private String alt = null;
      private String coords = null;
      private String href = null;
      private String hreflang = null;
      private String media = null;
      private String target = null;
      private String rel = null;
      private String shape = null;
      private String type = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withAlt(String aalt)
      {
         alt = aalt;
      
         return this;
      }

      public B withCoords(String acoords)
      {
         coords = acoords;
      
         return this;
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

      public B withTarget(String atarget)
      {
         target = atarget;
      
         return this;
      }

      public B withRel(String arel)
      {
         rel = arel;
      
         return this;
      }

      public B withShape(String ashape)
      {
         shape = ashape;
      
         return this;
      }

      public B withType(String atype)
      {
         type = atype;
      
         return this;
      }

      @Override
      public NitroArea body(NitroElement bd)
      {
         body = bd;
         return new NitroArea(this);
      }
   }

   public NitroArea(B b)
   {
      super(b);

      alt = b.alt;
      coords = b.coords;
      href = b.href;
      hreflang = b.hreflang;
      media = b.media;
      target = b.target;
      rel = b.rel;
      shape = b.shape;
      type = b.type;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroArea.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("area", bodystr,
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

            { "alt" , alt},
            { "coords" , coords},
            { "href" , href},
            { "hreflang" , hreflang},
            { "media" , media},
            { "target" , target},
            { "rel" , rel},
            { "shape" , shape},
            { "type" , type},
         });

      return str;
   }
}

