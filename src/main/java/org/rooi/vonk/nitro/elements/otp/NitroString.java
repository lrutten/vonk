package org.rooi.vonk.nitro.elements.otp;

import org.rooi.vonk.nitro.Nitro;

public class NitroString extends NitroSimple
{
   private String text;

   static public class B extends NitroSimple.B
   {
      private String text = null;
      
      public B(String te) 
      {
         //super(null);
         text = te;
      }

      public B withText(String te) 
      {
         text = te;
         return this;
      }

      public NitroString build()
      {
         body = null;
         return new NitroString(this);
      }
   }

   public NitroString(B b)
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
   
   public static void test()
   {
      NitroString el =
      (
         (NitroString.B) new NitroString.B("hallo")
      )
      .withText("au")
      .build();
   }
}
