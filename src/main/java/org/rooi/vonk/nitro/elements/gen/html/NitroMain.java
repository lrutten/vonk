package org.rooi.vonk.nitro.elements.gen.html;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.rooi.vonk.nitro.Nitro;
import org.rooi.vonk.nitro.actions.NitroActionEvent;
import org.rooi.vonk.nitro.render.NitroWfTag;
import org.rooi.vonk.nitro.elements.NitroElement;
import org.rooi.vonk.nitro.elements.NitroElement.B;
import org.rooi.vonk.nitro.actions.NitroAction;

public class NitroMain extends NitroElement
{
   private static Logger logger = LogManager.getLogger();

   static public class B extends NitroElement.B
   {
      public B(String pid)
      {
         super(pid);
      }

      @Override
      public NitroMain body(NitroElement bd)
      {
         body = bd;
         return new NitroMain(this);
      }
   }

   public NitroMain(B b)
   {
      super(b);
   }

   // has no fields
   @Override
   public String render(Nitro ni)
   {
      logger.debug("NitroMain.render");

      return default_render(ni, "main");
   }
}

