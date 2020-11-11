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
-module(element_radiogroup).
-author('Rusty Klophaus').
-include_lib("nitro/include/nitro.hrl").
-compile(export_all).

render_element(Record) -> 
    ID = Record#radiogroup.id,
    Body = apply_name(ID, Record#radiogroup.body),
    wf_render_elements:render_element(#panel {
        id=ID,
        class=[radiogroup, Record#radiogroup.class],
        style=Record#radiogroup.style,
        body=Body
    }).

%% TODO: This whole thing needs to be replaced with a smarter recursive search.
%% As it is, it won't dive into the bodies of subelements. A recursive map (ie: nitro:map_body) would be
%% ideal

apply_name(Name, Terms) -> [do_apply(Name, X) || X <- Terms].
do_apply(Name, X) when is_record(X, radio) -> X#radio {name = Name};
do_apply(Name, List) when is_list(List) -> apply_name(Name,List);
do_apply(_Name, X) -> X.
 */

public class NitroRadiogroup extends NitroElement
{
   private static Logger logger = LogManager.getLogger();

   static public class B extends NitroElement.B
   {
      public B(String pid)
      {
         super(pid);
      }

      @Override
      public NitroRadiogroup body(NitroElement bd)
      {
         body = bd;
         return new NitroRadiogroup(this);
      }
   }

   public NitroRadiogroup(B b)
   {
      super(b);
   }

   // has no fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroRadiogroup.render");

      return default_render(ni, "radiogroup");
   }
}

