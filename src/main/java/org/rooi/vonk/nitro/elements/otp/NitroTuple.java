package org.rooi.vonk.nitro.elements.otp;

import java.util.ArrayList;

import org.rooi.vonk.nitro.Nitro;
import org.rooi.vonk.nitro.elements.NitroElement;

public class NitroTuple extends NitroSimple
{
   private ArrayList<NitroElement> elements;

   static public class B extends NitroSimple.B
   {
      private ArrayList<NitroElement> elements;
      
      public B() 
      {
         //super(null);
         elements = new ArrayList<NitroElement>();
      }

      public B withElement(NitroElement el) 
      {
         elements.add(el);
         return this;
      }

      public NitroTuple build()
      {
         body = null;
         return new NitroTuple(this);
      }
   }

   public NitroTuple(B b)
   {
      super(b);
      
      elements = new ArrayList<NitroElement>();
      for (NitroElement el : b.elements)
      {
         elements.add(el);
      }
   }

   public NitroElement get(int i)
   {
      return elements.get(i);
   }

   public String render(Nitro ni)
   {
      return "";
   }
   
   @Override
   public String getText()
   {
      return "tuple()";
   }

   public static void test()
   {
      NitroTuple el =
      (
         (NitroTuple.B) new NitroTuple.B()
      )
      .withElement(null)
      .build();
   }
}
