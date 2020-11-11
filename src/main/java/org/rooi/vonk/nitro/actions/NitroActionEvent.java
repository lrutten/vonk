package org.rooi.vonk.nitro.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.rooi.vonk.nitro.Nitro;
import org.rooi.vonk.nitro.elements.NitroElement;
import org.rooi.vonk.nitro.elements.otp.NitroSimple;
import org.rooi.vonk.nitro.elements.otp.NitroAtom;
import org.rooi.vonk.nitro.elements.otp.NitroString;
import org.rooi.vonk.nitro.elements.otp.NitroTuple;
import org.rooi.vonk.nitro.render.NitroWfEvent;

/*
-module(action_event).

-define(B(E), nitro:to_binary(E)).

render_action(#event{source=undefined}) -> 
   [];
render_action(#event{postback=Postback,actions=_A,source=Source,target=Control,type=Type,delegate=D,validation=V}) ->
   io:format("action_event:render_action~n"),
   E = ?B(Control),
   ValidationSource = [ S || S <- Source, not is_tuple(S) ],
   PostbackBin = wf_event:new(Postback, E, D, event, data(E,Source), ValidationSource, V),
   [
      "{var x=qi('",
      E,
      "'); x && x.addEventListener('",
      ?B(Type),
      "',function (event){ event.preventDefault(); ",
      PostbackBin,
      "});};"
   ].

data(E,SourceList) ->
   Type=
      fun(A) when 
         is_atom(A) -> 
            [ "atom('",atom_to_list(A),"')" ];
         (A) -> 
            [ "string('",A,"')" ]
      end,
   list_to_binary(
   [
      "[tuple(tuple(string('",E,"'),bin('detail')),[])",
      [
         case S of 
            {Id,Code} -> 
               [ ",tuple(",Type(Id),",",Code,")" ];
            _ -> 
               [ ",tuple(",Type(S),",querySource('",?B(S),"'))" ]
         end 
         ||
         S <- SourceList
      ],
      "]"
   ]).

-record(wire,    {?ACTION_BASE(action_wire)}).
-record(event,   {?ACTION_BASE(action_event), type=default, postback, delegate, validation=[]}).

 */

public class NitroActionEvent extends NitroAction
{
   private static Logger logger = LogManager.getLogger();
   private String   type = "default";
   private String   postback;
   private String   delegate;
   private String   validation = "console.log('validate');";
   
   public NitroActionEvent(String targ, String tpe, String pback, NitroSimple[] src, String del)
   {
      target     = targ;
      type       = tpe;
      postback   = pback;
      source     = src;
      delegate   = del;
   }
   
   private String ftype()
   {
      /*
   Type=
      fun(A) when 
         is_atom(A) -> 
            [ "atom('",atom_to_list(A),"')" ];
         (A) -> 
            [ "string('",A,"')" ]
      end,
      */
      return "";
   }

   private String data(String target, NitroSimple[] sourceList)
   {
      StringBuilder sourcestr = new StringBuilder();
      if (sourceList != null)
      {
         for (NitroSimple so: sourceList)
         {
            if (so instanceof NitroTuple)
            {
               NitroTuple tu   = (NitroTuple) so;
               String     idd  = tu.get(0).getText();
               String     code = tu.get(1).getText();
               sourcestr.append(String.format(",tuple(%s,%s)", idd, code));
            }
            else
            {
               String te = so.getText();
               if (so instanceof NitroString)
               {
                  te = ((NitroString) so).getText();
               }
               else
               if (so instanceof NitroAtom)
               {
                  te = ((NitroAtom) so).getText();
               }
               sourcestr.append(String.format(",tuple(string('%s'),querySource('%s'))", te, te));
            }
         }
      }
      return String.format("[tuple(tuple(string('%s'),atom('detail')),[])%s]", target, sourcestr.toString());
   }

   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroActionEvent.render " + target + " " + type);
      // hack
      NitroSimple[] validationSource = source;
      
      String postbackstr = NitroWfEvent.mknew(postback, target, type, delegate, "event", data(target, source), validationSource, validation);
      
      //return "";
      return String.format(
         "{console.log('addevent'); var x=qi('%s'); x && x.addEventListener('%s',function (event){ event.preventDefault(); console.log('click'); %s});};",
         target, type, postbackstr);
   }
}
