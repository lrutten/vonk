package org.rooi.vonk.nitro;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.text.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import freemarker.template.Configuration;
import freemarker.template.Version;
import freemarker.template.SimpleSequence;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.core.ParseException;

import com.ericsson.otp.erlang.OtpErlangObject;
import com.ericsson.otp.erlang.OtpErlangTuple;
import com.ericsson.otp.erlang.OtpErlangAtom;
import com.ericsson.otp.erlang.OtpErlangBinary;
import com.ericsson.otp.erlang.OtpErlangString;
import com.ericsson.otp.erlang.OtpOutputStream;

import org.rooi.vonk.VonkMain;
import org.rooi.vonk.nitro.elements.NitroBase;
import org.rooi.vonk.nitro.elements.NitroElement;
import org.rooi.vonk.nitro.actions.NitroAction;
import org.rooi.vonk.nitro.actions.NitroActionJq;
import org.rooi.vonk.nitro.actions.NitroActionJqProperty;
import org.rooi.vonk.nitro.render.NitroWfRender;

public class Nitro
{
   private static Logger logger = LogManager.getLogger();
   private static boolean debug = false;
   private Configuration        conf;
   private ArrayList<NitroBase> bases;
   
   public Nitro()
   {
      conf  = VonkMain.singleMain().getConfiguration();
      bases = new ArrayList<NitroBase>();
   }
   
   public void addBase(NitroBase base)
   {
      bases.add(base);
   }

   public void clearBases()
   {
      bases.clear();
   }

   public ArrayList<NitroBase> copyBases()
   {
      ArrayList<NitroBase> copy = new ArrayList<NitroBase>();
      
      for (NitroBase base: bases)
      {
         copy.add(base);
      }
      return copy;
   }

   public int getBasesSize()
   {
      return bases.size();
   }

   /*
   public static String js_escape(String s)
   {
      StringBuilder out = new StringBuilder(Math.max(16, s.length()));
      for (int i = 0; i < s.length(); i++)
      {
         char c = s.charAt(i);
         if (c > 127 || c == '"' || c == '<' || c == '>' || c == '&')
         {
            out.append("&#");
            out.append((int) c);
            out.append(';');
         }
         else
         {
            out.append(c);
         }
      }
      return out.toString();
   }
    */

   public static String js_escape(String s)
   {
      //                       escapeJavaScript(java.lang.String str)
      return StringEscapeUtils.escapeEcmaScript(s);
   }

   public ByteBuffer update(String target, HashMap<String, Object> attributes, String name)
   {
      try
      {
         Template temp = conf.getTemplate(name);
         //HashMap<String, Object> attributes = new HashMap<>();
         //attributes.put("time", "12.30");

         StringWriter strout = new StringWriter();
         temp.process(attributes, strout);

         // Build the answer as Erlang terms
         //String command = "qi('canopytime').outerHTML='" + strout.toString() + "';";
         String command = "qi('" + target + "').outerHTML='" + js_escape(strout.toString()) + "';";
         logger.debug("command " + command);
   
         OtpErlangAtom atomio    = new OtpErlangAtom("io");
         //OtpErlangBinary js      = new OtpErlangBinary("qi('canopytime').outerHTML='<span id=\"canopytime\">time</span>';".getBytes());
         OtpErlangBinary js      = new OtpErlangBinary(command.getBytes());
         OtpErlangAtom atomtoken = new OtpErlangAtom("Token");
         OtpErlangBinary token   = new OtpErlangBinary("1234abcd".getBytes());
         OtpErlangObject[] list1 = {atomtoken, token};
         OtpErlangTuple  t1      = new OtpErlangTuple(list1);
         OtpErlangObject[] list2 = {atomio, js, t1};
         OtpErlangTuple  t2      = new OtpErlangTuple(list2);
   
         OtpOutputStream out = new OtpOutputStream(t2);
         String answer = out.toString();
         logger.debug("WebSocket string: " + answer);
         byte[] answ1 = out.toByteArray();
         byte[] answ2 = new byte[answ1.length + 1];
         answ2[0] = (byte)131;
         for (int i=0; i<answ1.length; i++)
         {
            answ2[i+1] = answ1[i];
         }
         if (debug)
         {
            for (int i=0; i<answ2.length; i++)
            {
               logger.debug("byte " + answ2[i]);
            }
         }
   
         ByteBuffer buf = ByteBuffer.wrap(answ2);
         return buf;
      }
      catch (TemplateNotFoundException e)
      {
      }
      catch (TemplateException e)
      {
      }
      catch (MalformedTemplateNameException e)
      {
      }
      catch (ParseException e)
      {
      }
      catch (IOException e)
      {
      }
      return null;
   }

   public void wire(NitroAction action)
   {
      NitroAction.wire(this, action);
   }

   public void update(String elementid, NitroElement el)
   {
      wire(new NitroActionJqProperty(elementid, "outerHTML", el)); 
   }

// --------------------------------------------------------------------
   
/*   
-module(wf_render).

render_item(undefined) -> 
   <<>>;
render_item(E) when element(2,E) =:= element -> 
   io:format("wf_render:render_item Element: ~p~n",[E]),
   wf_render_elements:render_element(E);
render_item(E) when element(2,E) =:= action  ->
   io:format("wf_render:render_item Action: ~p~n",[E]),
   wf_render_actions:render_action(E);
render_item(E) ->
   io:format("wf_render:render_item Item: ~p~n",[E]),
   E.

render(undefined) ->
   <<>>;
render(<<E/binary>>) -> 
   E;
render(Elements) when is_list(Elements) ->
   io:format("wf_render:render: ~p~n",[Elements]),
   [ render_item(E) || E <- Elements, E /= undefined ];
render(Elements) -> 
   render_item(Elements).
   
   
// --------------------------------------------------------------------

-module (wf_render_elements).

render_element(E) when is_list(E) ->
   E;
render_element(Element) when is_tuple(Element) ->
   Id = 
   case element(#element.id,Element) of
      undefined -> 
         undefined;
      L when is_list(L) -> 
         L;
      Other -> 
         nitro:to_list(Other)
   end,
   case element(#element.actions,Element) of 
      undefined ->
         skip; 
      Actions -> 
         nitro:wire(Actions) 
   end,
   Tag = 
   case element(#element.html_tag,Element) of 
      undefined -> 
         nitro:to_binary(element(1, Element)); 
      T -> 
         T
   end,
   case element(#element.validation,Element) of
      [] -> 
         skip;
      Code ->
         nitro:wire(nitro:f("{var name='~s'; qi(name)"
           ".addEventListener('validation',"
              "function(e) { if (!(~s)) e.preventDefault(); });"
              "qi(name).validation = true;}",[Id,Code]))
   end,
   case element(#element.module,Element) of
      undefined ->
         default_render(Tag, Element);
      Module ->
         io:format("wf_render_elements:render_element ~p~n", [Module]),
         nitro:to_binary(Module:render_element(setelement(#element.id,Element,Id)))
      end;
render_element(Element) -> 
   io:format("Unknown Element: ~p~n\r",[Element]).

default_render(Tag, Record) ->
    wf_tags:emit_tag(Tag, nitro:render(element(#element.body,Record)),
        lists:append([
           [{<<"id">>,              element(#element.id, Record)},
            {<<"class">>,           element(#element.class, Record)},
            {<<"style">>,           element(#element.style, Record)},
            {<<"title">>,           element(#element.title, Record)},
            {<<"accesskey">>,       element(#element.accesskey, Record)},
            {<<"contenteditable">>, element(#element.contenteditable, Record)},
            {<<"contextmenu">>,     element(#element.contextmenu, Record)},
            {<<"dir">>,             element(#element.dir, Record)},
            {<<"draggable">>,       element(#element.draggable, Record)},
            {<<"dropzone">>,        element(#element.dropzone, Record)},
            {<<"hidden">>,          element(#element.hidden, Record)},
            {<<"lang">>,            element(#element.lang, Record)},
            {<<"spellcheck">>,      element(#element.spellcheck, Record)},
            {<<"translate">>,       element(#element.translate, Record)},
            {<<"tabindex">>,        element(#element.tabindex, Record)},
            {<<"role">>,            element(#element.role, Record)}],
        element(#element.data_fields, Record),
        element(#element.aria_states, Record)])).
   
   
// --------------------------------------------------------------------

-module(wf_render_actions).

render_action(Action) ->
   io:format("wf_render_actions:render_action Action ~p~n", [Action]),
   Module = element(#action.module,Action),
   io:format("wf_render_actions:render_action Module ~p~n", [Module]),
   Res = Module:render_action(Action),
   case Res of
      Res when is_tuple(Res) -> render_action(Res);
      Bin when is_binary(Bin) -> Bin;
      Str when is_list(Str) -> Str;
      _ -> [] 
   end.



// --------------------------------------------------------------------

-module(wf_event).

-record(ev,      { module, msg, trigger, name }).

-define(B(E), nitro:to_binary(E)).
-define(L(E), nitro:to_list(E)).

target({qs,S}) ->
   ["qs('",nitro:js_escape(?L(S)), "')"];
target(Id) ->
   ["qi('",nitro:js_escape(?L(Id)),"')"].

new(P,E,D,N,Data,Source) ->
   new(P,E,D,N,Data,Source,<<>>).

new(bin,Data) ->
   <<"ws.send(enc(tuple(atom('bin'),bin('",(nitro:pickle(Data))/binary,"'))));">>.

new(undefined, _, _, _, _, _, _) ->
   <<>>;
new(Postback, Element, Delegate, Name, Data, Source, Validation) ->
   Module = nitro:coalesce([Delegate, ?CTX#cx.module]),
   Join=
   fun
      ([]) -> 
         [];
      ([E]) ->
         [$'|E]++[$'];
      ([H|T]) ->
         [[$'|H]++[$']] ++ [ [$,,$'|E]++[$'] || E <- T ]
   end,
   Event = #ev{name=Name, module=Module, msg=Postback, trigger=Element},
   list_to_binary(
   [
      "{ if (validateSources([",
      Join([ nitro:to_list(S) || S <- Source, S =/= []]),
      "])) { ",
      ?B(Validation),
      " ws.send(enc(tuple(atom('",
      ?B(application:get_env(n2o,event,pickle)),
      "'),bin('",
       Element,
       "'),bin('",nitro:pickle(Event),
       "'),",
       Data,
       "))); } else console.log('Validation Error'); }"
   ]).

// --------------------------------------------------------------------

-module(wf_tags).

-define(VOID(Tag),  (Tag == <<"br">>     orelse Tag == <<"hr">>
              orelse Tag == <<"link">>   orelse Tag == <<"img">>
              orelse Tag == <<"input">>  orelse Tag == <<"link">>
              orelse Tag == <<"meta">>   orelse Tag == <<"param">>
              orelse Tag == <<"base">>   orelse Tag == <<"area">>
              orelse Tag == <<"col">>    orelse Tag == <<"command">> orelse Tag == <<"option">>
              orelse Tag == <<"keygen">> orelse Tag == <<"source">>)).

emit_tag(TagName, Props) ->
   [<<"<">>,TagName] ++ write_props(Props) ++ [<<"/>">>].
   
emit_tag(TagName, undefined, Props) ->
   emit_tag(TagName, [], Props);
emit_tag(TagName, [undefined], Props) ->
   emit_tag(TagName, [], Props);
emit_tag(TagName, <<>>, Props) when ?VOID(TagName) ->
   emit_tag(TagName, Props);
emit_tag(TagName, [], Props) ->
   [<<"<">>,TagName,write_props(Props),<<">">>,<<"</">>,TagName,<<">">>];
emit_tag(TagName, Content, Props) ->
   [<<"<">>,TagName,write_props(Props),<<">">>, Content,<<"</">>,TagName,<<">">>].

write_props(Props) ->
   lists:map(fun display_property/1, Props).

display_property({_, undefined}) ->
   [];
display_property({_, []}) ->
   [];
display_property({<<"class">>=Id, Value}) ->
   prop({Id,Value});
display_property({<<"data-toggle">>=Id, Value}) ->
   prop({Id,Value});
display_property({Prop, Value}) ->
   [<<" ">>, nitro:to_binary(Prop), <<"=\"">>, nitro:to_binary(Value), <<"\"">>].

prop({Id, Value}) when is_atom(Value) ->
   [<<" ">>,Id,<<"=\"">>, nitro:to_binary(Value), <<"\"">>];
prop({Id, Value}) when is_binary(Value) ->
   [<<" ">>,Id,<<"=\"">>, Value, <<"\"">>];
prop({Id, Value}) ->
   [<<" ">>,Id,<<"=\"">>, string:join([nitro:to_list(V) || V <-Value ]," "), <<"\"">>].

// --------------------------------------------------------------------
  */ 
   
   public String render_item(NitroBase base)
   {
      String str = base.render(this);
      return str;
   }
  
   public String render(ArrayList<NitroBase> blist)
   {
      String cmds = "";
      int i = 0;
      for (NitroBase base: blist)
      {
         String cmd = render_item(base);
         cmds = cmds + cmd;
         logger.debug("Nitro.render " + i + ": " + cmd);
         i++;
      }
      return cmds;
   }
  
   public ByteBuffer renderAll()
   {
      String command = "";
      
      while (getBasesSize() > 0)
      {
         ArrayList<NitroBase> copy = copyBases();
         clearBases();
         String str = render(copy);
         command = command + str;
      }

      logger.debug("Nitro.renderAll command: " + command);
      
      OtpErlangAtom atomio    = new OtpErlangAtom("io");
      OtpErlangBinary js      = new OtpErlangBinary(command.getBytes());
      OtpErlangAtom atomtoken = new OtpErlangAtom("Token");
      OtpErlangBinary token   = new OtpErlangBinary("1234abcd".getBytes());
      OtpErlangObject[] list1 = {atomtoken, token};
      OtpErlangTuple  t1      = new OtpErlangTuple(list1);
      OtpErlangObject[] list2 = {atomio, js, t1};
      OtpErlangTuple  t2      = new OtpErlangTuple(list2);

      OtpOutputStream out = new OtpOutputStream(t2);
      String answer = out.toString();
      logger.debug("Nitro.renderAll string: " + answer);
      byte[] answ1 = out.toByteArray();
      byte[] answ2 = new byte[answ1.length + 1];
      answ2[0] = (byte)131;
      for (int i=0; i<answ1.length; i++)
      {
         answ2[i+1] = answ1[i];
      }

      if (debug)
      {
         for (int i=0; i<answ2.length; i++)
         {
            logger.debug("byte " + answ2[i]);
         }
      }

      ByteBuffer buf = ByteBuffer.wrap(answ2);
      return buf;
   }

   /*
   render_actions(Actions) ->
    io:format("n2o_nitro:render_actions~n"),
    nitro:actions([]),
    First  = nitro:render(Actions),
    Second = nitro:render(nitro:actions()),
    nitro:actions([]),
    R = nitro:to_binary([First,Second]),
    io:format("n2o_nitro:render_actions R ~p~n", [R]),
    R.
    */
}
