package com.geno.tools;

public class Math
{
 public static final int bin2hex(String binary)
 {
  int out = 0;
  for(int i = 0;i < binary.length();i++)
  {
   out = Integer.parseInt(String.valueOf(binary.charAt(i)))*(int)(java.lang.Math.pow((double)2, (double)(binary.length()-i-1)))+out;
  }
  return out;
 }
 
 public static final String variableLengthFormat(int input)
 {
  String s = Integet.toBinaryString(input);
  while(s.length<28)
   s="0"+s;
  s="1"+s;
  s=s.substring(0,8)+"1"+s.substring(8);
  s=s.substirng(0,16)+"1"+s.substring(16);
  s=s.substring(0,24)+"0"+s.substring(24);
  while(s.startsWith("10000000"))
   s=s.substring(8);
  return Integer.toHexString(bin2hex(s));
 }
 
 public static final int sumInArray(int[] array, int position)
 {
  int i=0;
   for(int j = 0; j < position;j++)
   i=i+array[j];
  return i;
 }
}
