package org.rooi.vonk.nitro.actions;

import org.rooi.vonk.nitro.Nitro;
import org.rooi.vonk.nitro.elements.NitroElement;

/*

-record(jq,      {?ACTION_BASE(action_jq), property, method, args=[], right, format="~s"}).
-record(wire,    {?ACTION_BASE(action_wire)}).

 */

public class NitroActionWire extends NitroAction
{
   public NitroActionWire(NitroAction act)
   {
      actions = act;
   }
   
   @Override
   public String render(Nitro ni)
   {
      return actions.render(ni);
   }
}
