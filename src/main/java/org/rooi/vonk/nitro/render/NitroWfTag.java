package org.rooi.vonk.nitro.render;

import java.nio.ByteBuffer;

import org.rooi.vonk.nitro.Nitro;

/*
-module(wf_tags).

-define(VOID(Tag),  (Tag == <<"br">>     orelse Tag == <<"hr">>
              orelse Tag == <<"link">>   orelse Tag == <<"img">>
              orelse Tag == <<"input">>  orelse Tag == <<"link">>
              orelse Tag == <<"meta">>   orelse Tag == <<"param">>
              orelse Tag == <<"base">>   orelse Tag == <<"area">>
              orelse Tag == <<"col">>    orelse Tag == <<"command">> orelse Tag == <<"option">>
              orelse Tag == <<"keygen">> orelse Tag == <<"source">>)).

emit_tag(TagName, Props) ->
   [<<"<">>,TagName] ++ write_props(Props) ++ [<<"/>">>].
   
emit_tag(TagName, undefined, Props) ->
   emit_tag(TagName, [], Props);
emit_tag(TagName, [undefined], Props) ->
   emit_tag(TagName, [], Props);
emit_tag(TagName, <<>>, Props) when ?VOID(TagName) ->
   emit_tag(TagName, Props);
emit_tag(TagName, [], Props) ->
   [<<"<">>,TagName,write_props(Props),<<">">>,<<"</">>,TagName,<<">">>];
emit_tag(TagName, Content, Props) ->
   [<<"<">>,TagName,write_props(Props),<<">">>, Content,<<"</">>,TagName,<<">">>].

write_props(Props) ->
   lists:map(fun display_property/1, Props).

display_property({_, undefined}) ->
   [];
display_property({_, []}) ->
   [];
display_property({<<"class">>=Id, Value}) ->
   prop({Id,Value});
display_property({<<"data-toggle">>=Id, Value}) ->
   prop({Id,Value});
display_property({Prop, Value}) ->
   [<<" ">>, nitro:to_binary(Prop), <<"=\"">>, nitro:to_binary(Value), <<"\"">>].

prop({Id, Value}) when is_atom(Value) ->
   [<<" ">>,Id,<<"=\"">>, nitro:to_binary(Value), <<"\"">>];
prop({Id, Value}) when is_binary(Value) ->
   [<<" ">>,Id,<<"=\"">>, Value, <<"\"">>];
prop({Id, Value}) ->
   [<<" ">>,Id,<<"=\"">>, string:join([nitro:to_list(V) || V <-Value ]," "), <<"\"">>].

 */



public class NitroWfTag
{
   private static boolean isvoid(String tag)
   {
      return 
         tag.equals("br")   ||
         tag.equals("hr")   ||
         tag.equals("link") ||
         tag.equals("img")  ||
         tag.equals("input") ||
         tag.equals("link") ||
         tag.equals("meta") ||
         tag.equals("param") ||
         tag.equals("base") ||
         tag.equals("area") ||
         tag.equals("col")  ||
         tag.equals("command") ||
         tag.equals("option") ||
         tag.equals("keygen") ||
         tag.equals("source");
   }
  
      
   public static String write_props(String[][] attrs)
   {
      StringBuilder sb = new StringBuilder();
      for (int i=0; i<attrs.length; i++)
      {
         String[] prop = attrs[i];
         String key   = prop[0];
         String value = prop[1];
         if (value != null)
         {
            sb.append(String.format(" %s=\"%s\"", key, value));
         }
      }
      return sb.toString();
   }

   public static String emit_tag(String tag, String bodystr, String[][] attrs)
   {
      String props = "";
      if (attrs.length > 0)
      {
         props = write_props(attrs);
      }
      
      if (isvoid(tag))
      {
         return String.format("<%s%></%s>",tag, props, tag);
      }
      else
      if (bodystr != null)
      {
         return String.format("<%s%s>%s</%s>",tag, props,  bodystr, tag);
      }
      else
      {
         return String.format("<%s%s></%s>",tag, props,  tag);
      }
   }
}

