package org.rooi.vonk.nitro.actions;


import org.rooi.vonk.nitro.Nitro;
import org.rooi.vonk.nitro.elements.NitroBase;
import org.rooi.vonk.nitro.elements.otp.NitroSimple;

/*
-define(DEFAULT_BASE, {?ELEMENT_BASE(undefined)}).
-define(DEFAULT_BASE_TAG(Tag), {?ELEMENT_BASE(undefined,Tag,undefined)}).
-define(ELEMENT_BASE(Module), ?ELEMENT_BASE(Module,undefined,undefined)).
-define(ELEMENT_BASE(Module,Tag,Delegate),
        ancestor=element, id, module=Module, delegate=Delegate, validation=[], validate=[],
        actions, class=[], style=[], source=[], onmouseover, onkeypress, onchange, onkeyup, onkeydown, onclick,
        data_fields=[], aria_states=[], body, role, tabindex, show_if=true, html_tag=Tag, title,
        postback, accesskey, contenteditable, contextmenu, dir, draggable, dropzone,
        hidden, lang, spellcheck, translate, onblur, onerror, onfocus, onmessage, onresize).
-define(ACTION_BASE(Module), ancestor=action, trigger, target, module=Module, actions, source=[]).
-define(CTRL_BASE(Module), ?ELEMENT_BASE(Module,undefined,Module)).
 */
 

abstract public class NitroAction extends NitroBase
{
   protected String        trigger;
   protected String        target;
   protected NitroAction   actions;
   protected NitroSimple[] source;  

   public NitroAction()
   {
   }

   public String getAncestor()
   {
      return "action";
   }

   public static void wire(Nitro nitro, NitroAction act)
   {
      NitroAction act2 = new NitroActionWire(act);
      // put act2
      nitro.addBase(act2);
   }
}
