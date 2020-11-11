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
-module(element_upload).
-compile(export_all).
-include_lib("nitro/include/nitro.hrl").

render_element(#upload{id=Id}) ->
    Uid = case Id of undefined -> nitro:temp_id(); I -> I end,
    nitro:wire("ftp_file=undefined;"),
    bind(ftp_open,  click,  nitro:f("qi('~s').click(); event.preventDefault();", [nitro:to_list(Uid)])),
    bind(ftp_start, click,  "ftp.start(ftp_file);"),
    bind(ftp_stop,  click,  "ftp.stop(ftp_file);"),
    bind(nitro:to_atom(Uid), change, "ftp_file=ftp.init(this.files[0]);"),
    Upload = #span  { id=upload, body = [
             #input  { id   = Uid,         type    = <<"file">>, style = "display:none" },
             #span   { id   = ftp_status,  body    = [] },
             #span   { body = [
             #button { id   = ftp_open,    body = "Browse" },
             #button { id   = ftp_start,   body = "Upload" },
             #button { id   = ftp_stop,    body = "Stop" }
    ] } ] }, nitro:render(Upload).

bind(Control,Event,Code) ->
    nitro:wire(#bind{target=Control,type=Event,postback=Code}).
 */

public class NitroUpload extends NitroElement
{
   private static Logger logger = LogManager.getLogger();
   private String name = null;
   private String value = null;

   static public class B extends NitroElement.B
   {
      private String name = null;
      private String value = null;

      public B(String pid)
      {
         super(pid);
      }

      public B withName(String aname)
      {
         name = aname;
      
         return this;
      }

      public B withValue(String avalue)
      {
         value = avalue;
      
         return this;
      }

      @Override
      public NitroUpload body(NitroElement bd)
      {
         body = bd;
         return new NitroUpload(this);
      }
   }

   public NitroUpload(B b)
   {
      super(b);

      name = b.name;
      value = b.value;
   }

   // has fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroUpload.render");

      set_common_action(ni);

      String bodystr = "";
      if (body != null)
      {
         bodystr = body.render(ni);
      }

      String str = NitroWfTag.emit_tag("upload", bodystr,
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

            { "name" , name},
            { "value" , value},
         });

      return str;
   }
}

