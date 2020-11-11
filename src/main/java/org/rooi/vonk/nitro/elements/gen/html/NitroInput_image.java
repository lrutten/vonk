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
-module(element_input_image).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    Id = case Record#input_image.postback of
        undefined -> Record#input_image.id;
        Postback ->
          ID = case Record#input_image.id of
            undefined -> nitro:temp_id();
            I -> I end,
          nitro:wire(#event{type=click, postback=Postback, target=ID,
                  source=Record#input_image.source, delegate=Record#input_image.delegate }),
          ID end,
    List = [
      %global
      {<<"accesskey">>, Record#input_image.accesskey},
      {<<"class">>, Record#input_image.class},
      {<<"contenteditable">>, case Record#input_image.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#input_image.contextmenu},
      {<<"dir">>, case Record#input_image.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#input_image.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#input_image.dropzone},
      {<<"hidden">>, case Record#input_image.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Id},
      {<<"lang">>, Record#input_image.lang},
      {<<"spellcheck">>, case Record#input_image.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#input_image.style},
      {<<"tabindex">>, Record#input_image.tabindex},
      {<<"title">>, Record#input_image.title},
      {<<"translate">>, case Record#input_image.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"alt">>,Record#input_image.alt},
      {<<"autofocus">>,if Record#input_image.autofocus == true -> "autofocus"; true -> undefined end},      
      {<<"disabled">>, if Record#input_image.disabled == true -> "disabled"; true -> undefined end},
      {<<"form">>,Record#input_image.form},
      {<<"formaction">>,Record#input_image.formaction},
      {<<"formenctype">>,Record#input_image.formenctype},
      {<<"formmethod">>,Record#input_image.formmethod},
      {<<"formnovalue">>,Record#input_image.formnovalue},
      {<<"formtarget">>,Record#input_image.formtarget},
      {<<"height">>,Record#input_image.height},
      {<<"name">>,Record#input_image.name},
      {<<"src">>,Record#input_image.src},
      {<<"type">>, <<"image">>},
      {<<"width">>,Record#input_image.width} | Record#input_image.data_fields
    ],
    wf_tags:emit_tag(<<"input">>, nitro:render(Record#input_image.body), List).
 */

public class NitroInput_image extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String alt = null;
   private String autofocus = null;
   private String disabled = null;
   private String form = null;
   private String formaction = null;
   private String formenctype = null;
   private String formmethod = null;
   private String formnovalue = null;
   private String formtarget = null;
   private String height = null;
   private String name = null;
   private String src = null;
   private String width = null;

   static public class B extends NitroElement.B
   {
      private String alt = null;
      private String autofocus = null;
      private String disabled = null;
      private String form = null;
      private String formaction = null;
      private String formenctype = null;
      private String formmethod = null;
      private String formnovalue = null;
      private String formtarget = null;
      private String height = null;
      private String name = null;
      private String src = null;
      private String width = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withAlt(String aalt)
      {
         alt = aalt;
      
         return this;
      }

      public B withAutofocus(String aautofocus)
      {
         autofocus = aautofocus;
      
         return this;
      }

      public B withDisabled(String adisabled)
      {
         disabled = adisabled;
      
         return this;
      }

      public B withForm(String aform)
      {
         form = aform;
      
         return this;
      }

      public B withFormaction(String aformaction)
      {
         formaction = aformaction;
      
         return this;
      }

      public B withFormenctype(String aformenctype)
      {
         formenctype = aformenctype;
      
         return this;
      }

      public B withFormmethod(String aformmethod)
      {
         formmethod = aformmethod;
      
         return this;
      }

      public B withFormnovalue(String aformnovalue)
      {
         formnovalue = aformnovalue;
      
         return this;
      }

      public B withFormtarget(String aformtarget)
      {
         formtarget = aformtarget;
      
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

      public B withSrc(String asrc)
      {
         src = asrc;
      
         return this;
      }

      public B withWidth(String awidth)
      {
         width = awidth;
      
         return this;
      }

      @Override
      public NitroInput_image body(NitroElement bd)
      {
         body = bd;
         return new NitroInput_image(this);
      }
   }

   public NitroInput_image(B b)
   {
      super(b);

      alt = b.alt;
      autofocus = b.autofocus;
      disabled = b.disabled;
      form = b.form;
      formaction = b.formaction;
      formenctype = b.formenctype;
      formmethod = b.formmethod;
      formnovalue = b.formnovalue;
      formtarget = b.formtarget;
      height = b.height;
      name = b.name;
      src = b.src;
      width = b.width;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroInput_image.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("input_image", bodystr,
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
            { "autofocus" , autofocus},
            { "disabled" , disabled},
            { "form" , form},
            { "formaction" , formaction},
            { "formenctype" , formenctype},
            { "formmethod" , formmethod},
            { "formnovalue" , formnovalue},
            { "formtarget" , formtarget},
            { "height" , height},
            { "name" , name},
            { "src" , src},
            { "width" , width},
         });

      return str;
   }
}

