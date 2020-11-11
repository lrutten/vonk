package org.rooi.vonk.nitro.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.rooi.vonk.nitro.Nitro;
import org.rooi.vonk.nitro.actions.NitroActionEvent;
import org.rooi.vonk.nitro.elements.NitroBase;
import org.rooi.vonk.nitro.elements.otp.NitroSimple;
import org.rooi.vonk.nitro.render.NitroWfTag;

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
 

public class NitroElement extends NitroBase
{
   /*
   ancestor=element, id, module=Module, delegate=Delegate, validation=[], validate=[], 
   actions, class=[], style=[], source=[], onmouseover, onkeypress, onchange, onkeyup, onkeydown, onclick,
   data_fields=[], aria_states=[], body, role, tabindex, show_if=true, 
   html_tag=Tag, title, postback, accesskey, contenteditable, contextmenu, dir, draggable, dropzone,
   hidden, lang, spellcheck, translate, onblur, onerror, onfocus, onmessage, onresize
    */

   private static Logger logger = LogManager.getLogger();

   protected final String  id;
   protected String        delegate;
   protected final String  actions;
   protected final String  klas;
   protected String        style;
   protected NitroSimple[] source;
   protected NitroElement  body;
   protected String        postback;
   protected String        onchange;
   protected String        onclick;
   protected String        onmouseover;

   protected String        onmouseup;
   protected String        onmouseout;
   protected String        onmousemove;
   protected String        onmouseleave;
   protected String        onmouseenter;
   protected String        onmousedown;
   protected String        onblur;
   protected String        onfocus;
   protected String        onkeypress;
   protected String        onkeyup;
   protected String        onkeydown;
   
   protected String        title;
   protected String        accesskey;
   protected String        contenteditable;
   protected String        contextmenu;
   protected String        dir;
   protected String        draggable;
   protected String        dropzone;
   protected String        hidden;
   protected String        lang;
   protected String        spellcheck;
   protected String        translate;
   protected String        tabindex;
   protected String        role;

   static public class B
   {
      private final String    id;
      protected String        delegate;
      private   String        actions;
      private   String        klas;
      protected String        style;
      protected NitroSimple[] source;
      protected String        onchange;
      protected String        onclick;
      protected NitroElement  body;
      protected String        postback;
      protected String        onmouseover = null;
      protected String        onmouseup = null;
      protected String        onmouseout = null;
      protected String        onmousemove = null;
      protected String        onmouseleave = null;
      protected String        onmouseenter = null;
      protected String        onmousedown = null;
      protected String        onblur = null;
      protected String        onfocus = null;
      protected String        onkeypress = null;
      protected String        onkeyup = null;
      protected String        onkeydown = null;

      protected String        title;
      protected String        accesskey;
      protected String        contenteditable;
      protected String        contextmenu;
      protected String        dir;
      protected String        draggable;
      protected String        dropzone;
      protected String        hidden;
      protected String        lang;
      protected String        spellcheck;
      protected String        translate;
      protected String        tabindex;
      protected String        role;
      
      public B(String pid) 
      {
         id = pid;
      }

      public B withDelegate(String del) 
      {
         delegate = del;
         return this;
      }

      public B withActions(String act) 
      {
         actions = act;
         return this;
      }

      public B withClass(String kl) 
      {
         klas = kl;
         return this;
      }

      public B withStyle(String sty) 
      {
         style = sty;
         return this;
      }

      public B withSource(NitroSimple[] sou) 
      {
         source = sou;
         return this;
      }

      public B withRole(String ro) 
      {
         role = ro;
         return this;
      }

      // Events
      public B withOnchange(String onch) 
      {
         onchange = onch;
         return this;
      }

      public B withOnclick(String oncl) 
      {
         onclick = oncl;
         return this;
      }

      public B withPostback(String po) 
      {
         postback = po;
         return this;
      }

      public B withMouseover(String onmo) 
      {
         onmouseover = onmo;
         return this;
      }

      public B withMouseup(String onmup) 
      {
         onmouseup = onmup;
         return this;
      }
      
      public B withMouseout(String onmout) 
      {
         onmouseout = onmout;
         return this;
      }
      
      public B withMousemove(String onmm) 
      {
         onmousemove = onmm;
         return this;
      }
      
      public B withMouseleave(String onml) 
      {
         onmouseleave = onml;
         return this;
      }
      
      public B withMouseenter(String onme) 
      {
         onmouseenter = onme;
         return this;
      }
      
      public B withMousedown(String onmd) 
      {
         onmousedown = onmd;
         return this;
      }
      
      public B withBlur(String onbl) 
      {
         onblur = onbl;
         return this;
      }
      
      public B withFocus(String onfc) 
      {
         onfocus = onfc;
         return this;
      }
      
      public B withKeypress(String onkp) 
      {
         onkeypress = onkp;
         return this;
      }
      
      public B withKeyup(String onku) 
      {
         onkeyup = onku;
         return this;
      }
      
      public B withKeydown(String ondo) 
      {
         onkeydown = ondo;
         return this;
      }
      
      
      
      public NitroElement body(NitroElement bd)
      {
         body = bd;
         return new NitroElement(this);
      }
   }

   public NitroElement(B b)
   {
      id           = b.id;
      actions      = b.actions;
      klas         = b.klas;
      style        = b.style;
      source       = b.source;
      onchange     = b.onchange;
      onclick      = b.onclick;
      postback     = b.postback;
      onmouseover  = b.onmouseover;
      onmouseup    = b.onmouseup;
      onmouseout   = b.onmouseout;
      onmousemove  = b.onmousemove;
      onmouseleave = b.onmouseleave;
      onmouseenter = b.onmouseenter;
      onmousedown  = b.onmousedown;
      body         = b.body;
      
      title           = b.title;
      accesskey       = b.accesskey;
      contenteditable = b.contenteditable;
      contextmenu     = b.contextmenu;
      dir             = b.dir;
      draggable       = b.draggable;
      dropzone        = b.dropzone;
      hidden          = b.hidden;
      lang            = b.lang;
      spellcheck      = b.spellcheck;
      translate       = b.translate;
      tabindex        = b.tabindex;
      role            = b.role;
   }
   
   public String getAncestor()
   {
      return "element";
   }

   public String render(Nitro ni)
   {
      return "";
   }

   protected void set_common_action(Nitro ni)
   {
      if (postback != null)
      {
         logger.debug("NitroElement.set_common_action postback " + postback);

         ni.wire(new NitroActionEvent(id, "click", postback, source, delegate));
      }

      if (onmouseover != null)
      {
         logger.debug("NitroElement.set_common_action onmouseover " + onmouseover);

         ni.wire(new NitroActionEvent(id, "mouseover", onmouseover, source, delegate));
      }

      if (onmouseup != null)
      {
         logger.debug("NitroElement.set_common_action onmouseup " + onmouseup);

         ni.wire(new NitroActionEvent(id, "mouseup", onmouseup, source, delegate));
      }

      if (onmouseout != null)
      {
         logger.debug("NitroElement.set_common_action onmouseout " + onmouseout);

         ni.wire(new NitroActionEvent(id, "mouseout", onmouseout, source, delegate));
      }

      if (onmousemove != null)
      {
         logger.debug("NitroElement.set_common_action onmousemove " + onmousemove);

         ni.wire(new NitroActionEvent(id, "mousemove", onmousemove, source, delegate));
      }

      if (onmouseleave != null)
      {
         logger.debug("NitroElement.set_common_action onmouseleave " + onmouseleave);

         ni.wire(new NitroActionEvent(id, "mouseleave", onmouseleave, source, delegate));
      }

      if (onmouseenter != null)
      {
         logger.debug("NitroElement.set_common_action onmouseenter " + onmouseenter);

         ni.wire(new NitroActionEvent(id, "mouseenter", onmouseenter, source, delegate));
      }

      if (onmousedown != null)
      {
         logger.debug("NitroElement.set_common_action onmousedown " + onmousedown);

         ni.wire(new NitroActionEvent(id, "mousedown", onmousedown, source, delegate));
      }

   }

   public String default_render(Nitro ni, String tg)
   {
      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }
      
      String str = NitroWfTag.emit_tag(tg, bodystr,
         new String[][]
         {
            { "id",              id},
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
            { "role",            role}
            //element(#element.data_fields, Record),
            //element(#element.aria_states, Record)])).
         });
      return str;
   }

   public String getText()
   {
      return "";
   }

   public static void test()
   {
      NitroElement el
      = new NitroElement.B("id1")
      .withActions(null)
      .withClass("200")
      .body(null);
   }
}
