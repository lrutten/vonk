package org.rooi.vonk.nitro.actions;

import org.rooi.vonk.nitro.Nitro;
import org.rooi.vonk.nitro.elements.NitroElement;

/*

-record(jq,      {?ACTION_BASE(action_jq), property, method, args=[], right, format="~s"}).


-module(action_jq).

-define(B(E), nitro:to_binary(E)).
-define(R(E), nitro:render(E)).
-define(T(T), wf_event:target(T)).
-define(U, undefined).

% jq 1
render_action(#jq{property=?U,target=T,method=Methods,args=Args0,format=F}) ->
    Args = 
    case F of
       "'~s'" ->
          [ ?R(Args0) ];
       _ ->
          Args0
    end,
    Format = 
    fun(A) 
       when is_tuple(A) orelse is_integer(A) ->
          ?R(A);
       (A) -> 
          nitro:to_list(A) 
    end,
    RenderedArgs = string:join([ Format(A) || A <- Args], ","),
    [[?T(T),".",?B(M),"(",nitro:f(F,[RenderedArgs]),");"] || M <- Methods];

% jq 2
render_action(#jq{target=T,method=?U,property=P,right=R,args=simple}) ->
   [?B(T),".",?B(P),"='",?R(R),"';"];

% jq 3
render_action(#jq{target=T,method=?U,property=P,right=?U}) ->
   [?T(T),".",?B(P),";"];

% jq 4
render_action(#jq{target=T,method=?U,property=P,right=#jq{}=R}) ->
   [?T(T),".",?B(P),"=", ?R(R), ";"];

% jq 5
render_action(#jq{target=T,method=?U,property=P,right=R}) ->
   [?T(T),".",?B(P),"='",?R(R),"';"].

There are 5 different render possibilities


 */

abstract public class NitroActionJq extends NitroAction
{
   public NitroActionJq(String targ)
   {
      target   = targ;
   }
}
