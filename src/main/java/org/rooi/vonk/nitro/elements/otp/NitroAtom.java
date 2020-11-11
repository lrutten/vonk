package org.rooi.vonk.nitro.elements.otp;

import org.rooi.vonk.nitro.Nitro;

public class NitroAtom extends NitroSimple
{
   private String text;

   static public class B extends NitroSimple.B
   {
      private String text = null;
      
      public B(String te) 
      {
         // super(null);
         text = te;
      }

      public B withText(String te) 
      {
         text = te;
         return this;
      }

      public NitroAtom build()
      {
         body = null;
         return new NitroAtom(this);
      }
   }

   public NitroAtom(B b)
   {
      super(b);
      text = b.text;
   }

   public String render(Nitro ni)
   {
      return text;
   }

   @Override
   public String getText()
   {
      return text;
   }
}
