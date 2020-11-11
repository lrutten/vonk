package org.rooi.vonk.nitro.elements.html;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.rooi.vonk.nitro.Nitro;
import org.rooi.vonk.nitro.actions.NitroActionEvent;
import org.rooi.vonk.nitro.render.NitroWfTag;

import org.rooi.vonk.nitro.elements.NitroElement;

/*
-module(element_label).

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
   /*
-record(label,       {?ELEMENT_BASE(element_label), for, form}).
    */

   private static Logger logger = LogManager.getLogger();
   private String  forr = null;
   private String  form = null;

   static public class B extends NitroElement.B
   {
      private String  forr = null;
      private String  form = null;
      
      public B(String pid) 
      {
         super(pid);
      }

      public B withFor(String fr) 
      {
         forr = fr;
         return this;
      }

      public B withForm(String frm) 
      {
         form = frm;
         return this;
      }

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

   public String render(Nitro ni)
   {
      logger.debug("NitroLabel.render");

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }
      String str = NitroWfTag.emit_tag("label", bodystr, 
         new String[][]
         {
            { "id",      id},
            { "class",   klas},
            { "style",   style},
            { "for",     forr},
            { "onclick", onclick}
            // | Record#label.data_fields
         });
     
      return str;
   }
   
   public static void test()
   {
      NitroLabel el =
      (
         (NitroLabel.B) new NitroLabel.B("id1")
      )
      .withFor("aaa")
      .withForm("bbb")
      .body(null);
   }
}
