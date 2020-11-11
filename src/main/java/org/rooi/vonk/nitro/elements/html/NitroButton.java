package org.rooi.vonk.nitro.elements.html;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.rooi.vonk.nitro.Nitro;
import org.rooi.vonk.nitro.actions.NitroActionEvent;
import org.rooi.vonk.nitro.render.NitroWfTag;

import org.rooi.vonk.nitro.elements.NitroElement;


/*

-module(element_button).

render_element(Record) ->
   io:format("element_button:render_element ~p~n", [Record]),
   Id = 
   case Record#button.postback of
      undefined ->
         Record#button.id;
      [] ->
         Record#button.id;
      Postback ->
         ID = 
         case Record#button.id of 
            undefined -> 
               nitro:temp_id(); 
            I ->
               I
         end,
         nitro:wire(#event{type=click, postback=Postback, target=ID,
                  source=Record#button.source, delegate=Record#button.delegate }),
         ID
    end,
    wf_tags:emit_tag(<<"button">>, nitro:render(Record#button.body), [
        {<<"id">>, Id},
        {<<"type">>, Record#button.type},
        {<<"name">>, Record#button.name},
        {<<"class">>, Record#button.class},
        {<<"style">>, Record#button.style},
        {<<"onchange">>, Record#button.onchange},
        {<<"onclick">>, Record#button.onclick},
        {<<"disabled">>, if Record#button.disabled == true -> "disabled"; true -> undefined end},
        {<<"value">>, Record#button.value}  | Record#button.data_fields ]).
 */

public class NitroButton extends NitroElement
{
   /*
      autofocus, disabled, form, formaction, formenctype, formmethod, formtarget, formnovalidate, name, type= <<"button">>, value
    */

   private static Logger logger = LogManager.getLogger();
   private String  autofocus = null;
   private Boolean disabled  = false;
   private String  name      = null;
   private String  type      = null;
   private String  value     = null;

   static public class B extends NitroElement.B
   {
      private String autofocus = null;
      private String type      = "button";
      
      public B(String pid) 
      {
         super(pid);
      }

      public B withAutofocus(String afocus) 
      {
         autofocus = afocus;
         return this;
      }

      public B withType(String tpe) 
      {
         type = tpe;
         return this;
      }

      public NitroButton body(NitroElement bd)
      {
         body = bd;
         return new NitroButton(this);
      }
   }

   public NitroButton(B b)
   {
      super(b);
      autofocus = b.autofocus;
      type      = b.type;
   }

   public String render(Nitro ni)
   {
      logger.debug("NitroButton.render");
      if (postback != null)
      {
         logger.debug("NitroButton.render postback " + postback);
         /*
         Nitro.wire(#event{type=click, postback=Postback, target=ID,
                  source=Record#button.source, delegate=Record#button.delegate })
          */
         //                          target type   postback  source delegate
         ni.wire(new NitroActionEvent(id, "click", postback, source, delegate));
      }

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }
      String str = NitroWfTag.emit_tag("button", bodystr, 
         new String[][]
         {
            { "id",       id},
            { "type",     type},
            { "name",     name},
            { "class",    klas},
            { "style",    style},
            { "onchange", onchange},
            { "onclick",  onclick},
            { "disabled", disabled ? "disabled" : null},
            { "value",    value}
          //  | Record#button.data_fields 
         });
     
      return str;
   }
   
   public static void test()
   {
      NitroButton el =
      (
         (NitroButton.B) new NitroButton.B("id1")
         .withActions(null)
         .withClass("200")
      )
      .withAutofocus("au")
      .body(null);
   }
}
