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
-module(element_link).
-author('Rusty Klophaus').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) -> 
    Id = case Record#link.postback of
        undefined -> Record#link.id;
        Postback ->
            ID = case Record#link.id of undefined -> nitro:temp_id(); I -> I end,
            nitro:wire(#event{ type=click,postback=Postback,target=ID,
                            source=Record#link.source,delegate=Record#link.delegate,validation=Record#link.validate}),
            ID end,
    List = [
      % global
      {<<"accesskey">>, Record#link.accesskey},
      {<<"class">>, Record#link.class},
      {<<"contenteditable">>, case Record#link.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#link.contextmenu},
      {<<"dir">>, case Record#link.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#link.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#link.dropzone},
      {<<"hidden">>, case Record#link.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Id},
      {<<"lang">>, Record#link.lang},
      {<<"spellcheck">>, case Record#link.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#link.style},
      {<<"tabindex">>, Record#link.tabindex},
      {<<"title">>, Record#link.title},
      {<<"translate">>, case Record#link.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"href">>, nitro:coalesce([Record#link.href,Record#link.url])},
      {<<"hreflang">>, Record#link.hreflang},
      {<<"target">>, Record#link.target},
      {<<"media">>, Record#link.media},
      {<<"rel">>, Record#link.rel},
      {<<"type">>, Record#link.type},
      {<<"download">>, Record#link.download},
      {<<"name">>, Record#link.name},
      {<<"onclick">>, Record#link.onclick},
      {<<"onmouseover">>, Record#link.onmouseover} | Record#link.data_fields ],
    wf_tags:emit_tag(<<"a">>, nitro:render(Record#link.body), List).
 */

public class NitroLink extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String href = null;
   private String hreflang = null;
   private String media = null;
   private String rel = null;
   private String target = null;
   private String type = null;
   private String url = "javascript:void(0);";
   private String download = null;
   private String name = null;

   static public class B extends NitroElement.B
   {
      private String href = null;
      private String hreflang = null;
      private String media = null;
      private String rel = null;
      private String target = null;
      private String type = null;
      private String url = "javascript:void(0);";
      private String download = null;
      private String name = null;

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

      public B withTarget(String atarget)
      {
         target = atarget;
      
         return this;
      }

      public B withType(String atype)
      {
         type = atype;
      
         return this;
      }

      public B withUrl(String aurl)
      {
         url = aurl;
      
         return this;
      }

      public B withDownload(String adownload)
      {
         download = adownload;
      
         return this;
      }

      public B withName(String aname)
      {
         name = aname;
      
         return this;
      }

      @Override
      public NitroLink body(NitroElement bd)
      {
         body = bd;
         return new NitroLink(this);
      }
   }

   public NitroLink(B b)
   {
      super(b);

      href = b.href;
      hreflang = b.hreflang;
      media = b.media;
      rel = b.rel;
      target = b.target;
      type = b.type;
      url = b.url;
      download = b.download;
      name = b.name;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroLink.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("link", bodystr,
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
            { "target" , target},
            { "type" , type},
            { "url" , url},
            { "download" , download},
            { "name" , name},
         });

      return str;
   }
}

