package org.rooi.vonk.nitro.elements.otp;

import org.rooi.vonk.nitro.Nitro;
import org.rooi.vonk.nitro.elements.NitroElement;

abstract public class NitroSimple extends NitroElement
{
   static public class B extends NitroElement.B
   {
      public B() 
      {
         super(null);
      }

      /*
      public NitroSimple build()
      {
         body = null;
         return new NitroSimple(this);
      }
       */
   }

   public NitroSimple(B b)
   {
      super(b);
   }

   abstract public String getText();
}
