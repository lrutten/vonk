package org.rooi.vonk.nitro.elements;

import org.rooi.vonk.nitro.Nitro;


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
 

abstract public class NitroBase
{
   abstract public String render(Nitro ni);
}
