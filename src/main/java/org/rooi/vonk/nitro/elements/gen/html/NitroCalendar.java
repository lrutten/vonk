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
-module(element_calendar).
-author('G-Grand').
-include_lib("nitro/include/nitro.hrl").
-export([render_element/1]).

render_element(Record) ->
    Id = case Record#calendar.postback of
        undefined -> Record#calendar.id;
        Postback ->
          ID = case Record#calendar.id of
            undefined -> nitro:temp_id();
            I -> I end,
          nitro:wire(#event{type=click, postback=Postback, target=ID,
                  source=Record#calendar.source, delegate=Record#calendar.delegate }),
          ID end,

    init(Id,Record),

    List = [
      %global
      {<<"accesskey">>, Record#calendar.accesskey},
      {<<"class">>, Record#calendar.class},
      {<<"contenteditable">>, case Record#calendar.contenteditable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"contextmenu">>, Record#calendar.contextmenu},
      {<<"dir">>, case Record#calendar.dir of "ltr" -> "ltr"; "rtl" -> "rtl"; "auto" -> "auto"; _ -> undefined end},
      {<<"draggable">>, case Record#calendar.draggable of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"dropzone">>, Record#calendar.dropzone},
      {<<"hidden">>, case Record#calendar.hidden of "hidden" -> "hidden"; _ -> undefined end},
      {<<"id">>, Id},
      {<<"spellcheck">>, case Record#calendar.spellcheck of true -> "true"; false -> "false"; _ -> undefined end},
      {<<"style">>, Record#calendar.style},
      {<<"tabindex">>, Record#calendar.tabindex},
      {<<"title">>, Record#calendar.title},
      {<<"translate">>, case Record#calendar.contenteditable of "yes" -> "yes"; "no" -> "no"; _ -> undefined end},
      % spec
      {<<"autocomplete">>, case Record#calendar.autocomplete of true -> "on"; false -> "off"; _ -> undefined end},
      {<<"autofocus">>,if Record#calendar.autofocus == true -> "autofocus"; true -> undefined end},
      {<<"disabled">>, if Record#calendar.disabled == true -> "disabled"; true -> undefined end},
      {<<"form">>,Record#calendar.form},
      {<<"list">>,Record#calendar.list},
      {<<"name">>,Record#calendar.name},
      {<<"readonly">>,if Record#calendar.readonly == true -> "readonly"; true -> undefined end},
      {<<"required">>,if Record#calendar.required == true -> "required"; true -> undefined end},
      {<<"step">>,Record#calendar.step},
      {<<"type">>, <<"calendar">>},
      {<<"pattern">>,Record#calendar.pattern},
      {<<"placeholder">>,Record#calendar.placeholder},
      {<<"onkeypress">>, Record#calendar.onkeypress} | Record#calendar.data_fields
    ],
    wf_tags:emit_tag(<<"input">>, nitro:render(Record#calendar.body), List).

init(Id,#calendar{minDate=Min,maxDate=Max,lang=Lang,format=Form,value=Value,onSelect=SelectFn,disableDayFn=DisDayFn, position=Pos,reposition=Repos,yearRange=YearRange}) ->
    ID = nitro:to_list(Id),
    I18n =        case Lang  of undefined  -> "clLangs.ua"; Lang -> "clLangs."++nitro:to_list(Lang) end,
    Format =      case Form  of undefined  -> "YYYY-MM-DD"; Form -> Form end,
    DefaultDate = case Value of {Yv,Mv,Dv} -> nitro:f("new Date(~s,~s,~s)",[nitro:to_list(Yv),nitro:to_list(Mv-1),nitro:to_list(Dv)]);  _ -> "null" end,
    MinDate =     case Min   of {Y,M,D}    -> nitro:f("new Date(~s,~s,~s)",[nitro:to_list(Y), nitro:to_list(M-1), nitro:to_list(D)]);   _ -> "new Date(2000, 0, 1)" end,
    MaxDate =     case Max   of {Y1,M1,D1} -> nitro:f("new Date(~s,~s,~s)",[nitro:to_list(Y1),nitro:to_list(M1-1),nitro:to_list(D1)]);  _ -> "new Date(2087, 4, 13)" end,
    OnSelect =    case SelectFn of undefined -> "null"; _ -> SelectFn end,
    DisDay =      case DisDayFn of undefined -> "null"; _ -> nitro:f("function(thisDate){return ~s(thisDate);}",[DisDayFn]) end,
    Position =    case Pos of undefined -> "bottom left"; _ -> nitro:to_list(Pos) end,
    Reposition =  case Repos of undefined -> "true"; _ -> nitro:to_list(Repos) end,
    nitro:wire(nitro:f(
        "pickers['~s'] = new Pikaday({
            field: document.getElementById('~s'),
            firstDay: 1,
            i18n: ~s,
            defaultDate: ~s,
            setDefaultDate: true,
            minDate: ~s,
            maxDate: ~s,
            format: '~s',
            onSelect: ~s,
            disableDayFn: ~s,
            position: '~s',
            reposition: ~s,
            yearRange: ~s
        });",
        [ID,ID,I18n,DefaultDate,MinDate,MaxDate,Format,OnSelect,DisDay,Position,Reposition,nitro:to_list(YearRange)]
    )).
 */

public class NitroCalendar extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String autocomplete = null;
   private String autofocus = null;
   private String disabled = null;
   private String form = null;
   private String list = null;
   private String maxDate = null;
   private String minDate = null;
   private String format = null;
   private String pattern = null;
   private String name = null;
   private String step = null;
   private String readonly = null;
   private String required = null;
   private String value = null;
   private String placeholder = null;
   private String onSelect = null;
   private String disableDayFn = null;
   private String position = null;
   private String reposition = null;
   private String yearRange = "100";

   static public class B extends NitroElement.B
   {
      private String autocomplete = null;
      private String autofocus = null;
      private String disabled = null;
      private String form = null;
      private String list = null;
      private String maxDate = null;
      private String minDate = null;
      private String format = null;
      private String pattern = null;
      private String name = null;
      private String step = null;
      private String readonly = null;
      private String required = null;
      private String value = null;
      private String placeholder = null;
      private String onSelect = null;
      private String disableDayFn = null;
      private String position = null;
      private String reposition = null;
      private String yearRange = "100";

      public B(String pid)
      {
         super(pid);
      }

      public B withAutocomplete(String aautocomplete)
      {
         autocomplete = aautocomplete;
      
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

      public B withList(String alist)
      {
         list = alist;
      
         return this;
      }

      public B withMaxdate(String amaxDate)
      {
         maxDate = amaxDate;
      
         return this;
      }

      public B withMindate(String aminDate)
      {
         minDate = aminDate;
      
         return this;
      }

      public B withFormat(String aformat)
      {
         format = aformat;
      
         return this;
      }

      public B withPattern(String apattern)
      {
         pattern = apattern;
      
         return this;
      }

      public B withName(String aname)
      {
         name = aname;
      
         return this;
      }

      public B withStep(String astep)
      {
         step = astep;
      
         return this;
      }

      public B withReadonly(String areadonly)
      {
         readonly = areadonly;
      
         return this;
      }

      public B withRequired(String arequired)
      {
         required = arequired;
      
         return this;
      }

      public B withValue(String avalue)
      {
         value = avalue;
      
         return this;
      }

      public B withPlaceholder(String aplaceholder)
      {
         placeholder = aplaceholder;
      
         return this;
      }

      public B withOnselect(String aonSelect)
      {
         onSelect = aonSelect;
      
         return this;
      }

      public B withDisabledayfn(String adisableDayFn)
      {
         disableDayFn = adisableDayFn;
      
         return this;
      }

      public B withPosition(String aposition)
      {
         position = aposition;
      
         return this;
      }

      public B withReposition(String areposition)
      {
         reposition = areposition;
      
         return this;
      }

      public B withYearrange(String ayearRange)
      {
         yearRange = ayearRange;
      
         return this;
      }

      @Override
      public NitroCalendar body(NitroElement bd)
      {
         body = bd;
         return new NitroCalendar(this);
      }
   }

   public NitroCalendar(B b)
   {
      super(b);

      autocomplete = b.autocomplete;
      autofocus = b.autofocus;
      disabled = b.disabled;
      form = b.form;
      list = b.list;
      maxDate = b.maxDate;
      minDate = b.minDate;
      format = b.format;
      pattern = b.pattern;
      name = b.name;
      step = b.step;
      readonly = b.readonly;
      required = b.required;
      value = b.value;
      placeholder = b.placeholder;
      onSelect = b.onSelect;
      disableDayFn = b.disableDayFn;
      position = b.position;
      reposition = b.reposition;
      yearRange = b.yearRange;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroCalendar.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("calendar", bodystr,
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

            { "autocomplete" , autocomplete},
            { "autofocus" , autofocus},
            { "disabled" , disabled},
            { "form" , form},
            { "list" , list},
            { "maxDate" , maxDate},
            { "minDate" , minDate},
            { "format" , format},
            { "pattern" , pattern},
            { "name" , name},
            { "step" , step},
            { "readonly" , readonly},
            { "required" , required},
            { "value" , value},
            { "placeholder" , placeholder},
            { "onSelect" , onSelect},
            { "disableDayFn" , disableDayFn},
            { "position" , position},
            { "reposition" , reposition},
            { "yearRange" , yearRange},
         });

      return str;
   }
}

