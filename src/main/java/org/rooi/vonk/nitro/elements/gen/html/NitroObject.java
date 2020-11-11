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
-module(element_object).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#object.accesskey},
      {<<"class">>, Record#object.class},
      {<<"contenteditable">>, case Record#object.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#object.contextmenu},
      {<<"dir">>, case Record#object.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#object.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#object.dropzone},
      {<<"hidden">>, case Record#object.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#object.id},
      {<<"lang">>, Record#object.lang},
      {<<"spellcheck">>, case Record#object.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#object.style},
      {<<"tabindex">>, Record#object.tabindex},
      {<<"title">>, Record#object.title},
      {<<"translate">>, case Record#object.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"data">>,Record#object.data},      
      {<<"form">>,Record#object.form},      
      {<<"height">>,Record#object.height},      
      {<<"name">>,Record#object.name},            
      {<<"type">>,Record#object.type},
      {<<"usemap">>,Record#object.usemap},            
      {<<"width">>,Record#object.width} | Record#object.data_fields
    ],
    wf_tags:emit_tag(<<"object">>, nitro:render(case Record#object.body of undefined -> []; B -> B end), List).
 */

public class NitroObject extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String data = null;
   private String form = null;
   private String height = null;
   private String name = null;
   private String type = null;
   private String usemap = null;
   private String width = null;

   static public class B extends NitroElement.B
   {
      private String data = null;
      private String form = null;
      private String height = null;
      private String name = null;
      private String type = null;
      private String usemap = null;
      private String width = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withData(String adata)
      {
         data = adata;
      
         return this;
      }

      public B withForm(String aform)
      {
         form = aform;
      
         return this;
      }

      public B withHeight(String aheight)
      {
         height = aheight;
      
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

      public B withUsemap(String ausemap)
      {
         usemap = ausemap;
      
         return this;
      }

      public B withWidth(String awidth)
      {
         width = awidth;
      
         return this;
      }

      @Override
      public NitroObject body(NitroElement bd)
      {
         body = bd;
         return new NitroObject(this);
      }
   }

   public NitroObject(B b)
   {
      super(b);

      data = b.data;
      form = b.form;
      height = b.height;
      name = b.name;
      type = b.type;
      usemap = b.usemap;
      width = b.width;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroObject.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("object", bodystr,
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

            { "data" , data},
            { "form" , form},
            { "height" , height},
            { "name" , name},
            { "type" , type},
            { "usemap" , usemap},
            { "width" , width},
         });

      return str;
   }
}

