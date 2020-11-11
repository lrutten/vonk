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
-module(element_meter).
-author('Vladimir Galunshchikov').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) ->
    List = [
      %global
      {<<"accesskey">>, Record#meter.accesskey},
      {<<"class">>, Record#meter.class},
      {<<"contenteditable">>, case Record#meter.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#meter.contextmenu},
      {<<"dir">>, case Record#meter.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#meter.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#meter.dropzone},
      {<<"hidden">>, case Record#meter.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Record#meter.id},
      {<<"lang">>, Record#meter.lang},
      {<<"spellcheck">>, case Record#meter.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#meter.style},
      {<<"tabindex">>, Record#meter.tabindex},
      {<<"title">>, Record#meter.title},
      {<<"translate">>, case Record#meter.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},      
      % spec
      {<<"high">>,Record#meter.high},
      {<<"low">>,Record#meter.low},
      {<<"max">>,Record#meter.max},
      {<<"min">>,Record#meter.min},
      {<<"optimum">>,Record#meter.optimum},
      {<<"value">>, Record#meter.value} | Record#meter.data_fields
    ],
    wf_tags:emit_tag(<<"meter">>, nitro:render(case Record#meter.body of undefined -> []; B -> B end), List).
 */

public class NitroMeter extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String high = null;
   private String low = null;
   private String max = null;
   private String min = null;
   private String optimum = null;
   private String value = null;

   static public class B extends NitroElement.B
   {
      private String high = null;
      private String low = null;
      private String max = null;
      private String min = null;
      private String optimum = null;
      private String value = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withHigh(String ahigh)
      {
         high = ahigh;
      
         return this;
      }

      public B withLow(String alow)
      {
         low = alow;
      
         return this;
      }

      public B withMax(String amax)
      {
         max = amax;
      
         return this;
      }

      public B withMin(String amin)
      {
         min = amin;
      
         return this;
      }

      public B withOptimum(String aoptimum)
      {
         optimum = aoptimum;
      
         return this;
      }

      public B withValue(String avalue)
      {
         value = avalue;
      
         return this;
      }

      @Override
      public NitroMeter body(NitroElement bd)
      {
         body = bd;
         return new NitroMeter(this);
      }
   }

   public NitroMeter(B b)
   {
      super(b);

      high = b.high;
      low = b.low;
      max = b.max;
      min = b.min;
      optimum = b.optimum;
      value = b.value;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroMeter.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("meter", bodystr,
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

            { "high" , high},
            { "low" , low},
            { "max" , max},
            { "min" , min},
            { "optimum" , optimum},
            { "value" , value},
         });

      return str;
   }
}

