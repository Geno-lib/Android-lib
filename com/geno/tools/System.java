package com.geno.tools;

import java.io.*;

public class System
{
 public static final void execSu(String[] arrstring) throws IOException
 {
  java.lang.Process process = Runtime.getRuntime.exec("su");
  DataOutputStream o = new DataOutputStream(process.getOutputStream());
  String string2 = "";
  for (String string3 : arrstring)
  {
   string2 = (string2 + string3 + " ");
  }
  	o.writeBytes((string2 + "\nexit\n"));
  	o.flush();
 }
}
