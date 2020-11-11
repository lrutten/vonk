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
-module(element_dtl).
-author('Maxim Sokhatsky').
-include("nitro.hrl").
-compile(export_all).

render_element(Record=#dtl{}) ->
    M = list_to_atom(nitro:to_list(Record#dtl.file) ++ "_view"),
    %File = case code:lib_dir(nitro:to_atom(Record#dtl.app)) of
                %{error,bad_name} -> nitro:to_list(Record#dtl.app);
                %A -> A end ++ "/" ++ nitro:to_list(Record#dtl.folder)
         %++ "/" ++ nitro:to_list(Record#dtl.file) ++ "." ++ nitro:to_list(Record#dtl.ext),
    {ok,R} = render(M, Record#dtl.js_escape, [{K,nitro:render(V)} || {K,V} <- Record#dtl.bindings] ++
        if Record#dtl.bind_script==true -> [{script,nitro:script()}]; true-> [] end),
    R.

render(M, true, Args) ->
    {ok, R} = M:render(Args),
    {ok, nitro:js_escape(R)};
render(M, _, Args) -> M:render(Args).
 */

public class NitroDtl extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String file = "index";
   private String bindings = "[]";
   private String app = "web";
   private String folder = "priv/templates";
   private String ext = "html";
   private String bind_script = "true";
   private String js_escape = "false";

   static public class B extends NitroElement.B
   {
      private String file = "index";
      private String bindings = "[]";
      private String app = "web";
      private String folder = "priv/templates";
      private String ext = "html";
      private String bind_script = "true";
      private String js_escape = "false";

      public B(String pid)
      {
         super(pid);
      }

      public B withFile(String afile)
      {
         file = afile;
      
         return this;
      }

      public B withBindings(String abindings)
      {
         bindings = abindings;
      
         return this;
      }

      public B withApp(String aapp)
      {
         app = aapp;
      
         return this;
      }

      public B withFolder(String afolder)
      {
         folder = afolder;
      
         return this;
      }

      public B withExt(String aext)
      {
         ext = aext;
      
         return this;
      }

      public B withBind_script(String abind_script)
      {
         bind_script = abind_script;
      
         return this;
      }

      public B withJs_escape(String ajs_escape)
      {
         js_escape = ajs_escape;
      
         return this;
      }

      @Override
      public NitroDtl body(NitroElement bd)
      {
         body = bd;
         return new NitroDtl(this);
      }
   }

   public NitroDtl(B b)
   {
      super(b);

      file = b.file;
      bindings = b.bindings;
      app = b.app;
      folder = b.folder;
      ext = b.ext;
      bind_script = b.bind_script;
      js_escape = b.js_escape;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroDtl.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("dtl", bodystr,
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

            { "file" , file},
            { "bindings" , bindings},
            { "app" , app},
            { "folder" , folder},
            { "ext" , ext},
            { "bind_script" , bind_script},
            { "js_escape" , js_escape},
         });

      return str;
   }
}

