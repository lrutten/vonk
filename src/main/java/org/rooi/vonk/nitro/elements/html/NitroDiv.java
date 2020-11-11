package org.rooi.vonk.nitro.elements.html;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.rooi.vonk.nitro.Nitro;
import org.rooi.vonk.nitro.actions.NitroActionEvent;
import org.rooi.vonk.nitro.render.NitroWfTag;

import org.rooi.vonk.nitro.elements.NitroElement;


public class NitroDiv extends NitroElement
{
   private static Logger logger = LogManager.getLogger();

   static public class B extends NitroElement.B
   {
      public B(String pid) 
      {
         super(pid);
      }

      public NitroDiv body(NitroElement bd)
      {
         body = bd;
         return new NitroDiv(this);
      }
   }

   public NitroDiv(B b)
   {
      super(b);
   }

   public String render(Nitro ni)
   {
      logger.debug("NitroDiv.render");
     
      return default_render(ni, "div");
   }
   
   public static void test()
   {
      NitroDiv el =
      (
         (NitroDiv.B) new NitroDiv.B("id1")
      )
      .body(null);
   }
}
