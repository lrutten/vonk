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
-module(element_table).
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record = #table{}) -> 
  Header = case Record#table.header of
    undefined -> "";
    H when is_tuple(H) -> H;
    _ -> wf_tags:emit_tag(<<"thead">>, nitro:render(Record#table.header), [])
  end,
  Footer = case Record#table.footer of
    undefined -> "";
    _ -> wf_tags:emit_tag(<<"tfoot">>, nitro:render(Record#table.footer), [])
  end,
  Bodies = case Record#table.body of
    #tbody{} = B -> B;
    undefined -> #tbody{};
    [] -> #tbody{};
    Rows -> [case B of #tbody{}=B1 -> B1; _-> #tbody{body=B} end  || B <- Rows]
  end,
  Caption = case Record#table.caption of
    undefined -> "";
    _ -> wf_tags:emit_tag(<<"caption">>, nitro:render(Record#table.caption), [])
  end,
  Colgroup = case Record#table.colgroup of
    undefined -> "";
    _ -> wf_tags:emit_tag(<<"colgroup">>, nitro:render(Record#table.colgroup), [])
  end,
  wf_tags:emit_tag( <<"table">>, nitro:render([Caption, Colgroup, Header, Footer, Bodies]), [
      {<<"id">>, Record#table.id},
      {<<"class">>, Record#table.class},
      {<<"style">>, Record#table.style} | Record#table.data_fields
  ]).
 */

public class NitroTable extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String caption = null;
   private String colgroup = null;
   private String border = null;
   private String footer = null;
   private String header = null;

   static public class B extends NitroElement.B
   {
      private String caption = null;
      private String colgroup = null;
      private String border = null;
      private String footer = null;
      private String header = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withCaption(String acaption)
      {
         caption = acaption;
      
         return this;
      }

      public B withColgroup(String acolgroup)
      {
         colgroup = acolgroup;
      
         return this;
      }

      public B withBorder(String aborder)
      {
         border = aborder;
      
         return this;
      }

      public B withFooter(String afooter)
      {
         footer = afooter;
      
         return this;
      }

      public B withHeader(String aheader)
      {
         header = aheader;
      
         return this;
      }

      @Override
      public NitroTable body(NitroElement bd)
      {
         body = bd;
         return new NitroTable(this);
      }
   }

   public NitroTable(B b)
   {
      super(b);

      caption = b.caption;
      colgroup = b.colgroup;
      border = b.border;
      footer = b.footer;
      header = b.header;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroTable.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("table", bodystr,
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

            { "caption" , caption},
            { "colgroup" , colgroup},
            { "border" , border},
            { "footer" , footer},
            { "header" , header},
         });

      return str;
   }
}

