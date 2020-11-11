package org.rooi.vonk.nitro.render;

import java.nio.ByteBuffer;

import org.rooi.vonk.nitro.Nitro;
import org.rooi.vonk.nitro.elements.otp.NitroSimple;

/*
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
         [
           [$'|H] 
           ++ 
           [$']
         ] 
         ++ 
         [
            [$, , $'|E]++[$']
            ||
            E <- T
         ]
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

 */



public class NitroWfEvent
{
   private static String join(NitroSimple[] list)
   {
      if (list == null || list.length == 0)
      {
         return "";
      }
      
      StringBuilder sb = new StringBuilder();
      
      for (int i=0; i<list.length; i++)
      {
         sb.append(String.format("'%s'", list[i].getText()));
         if (i < list.length - 1)
         {
            sb.append(", ");
         }
      }
      return sb.toString();
   }

   public static String mknew(String postback, String target, String type, String delegate, String tuplename, String data, NitroSimple[] validationSource, String validation)
   {
      // no pickle or #ev{}
      if (delegate == null)
      {
         delegate = "nodelegate";
      }

      if (validation == null)
      {
         validation= "";
      }
      String event = String.format("atom('%s'), atom('%s'), string('%s'), string('%s')", tuplename, type, postback, target);
      
      //                                                                                           event  data
      return String.format("{ if (validateSources([%s])) { %s ws.send(enc(tuple(atom('nitro'),tuple(%s),%s))); } else console.log('Validation Error'); }",
         join(validationSource),
         validation,
         event,
         data
      );
   }

   // generate only qi, no qs
   public static String target(String targ)
   {
      return String.format("qi('%s')", Nitro.js_escape(targ));
   }
}

