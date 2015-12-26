package com.geno.tools;

import android.content.*;
import android.widget.*;
import android.preference.*;

public class Debug
{
 public static final void toast(String msg, Context context)
 {
  Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
 }
 
 public static final void compileCount(Context context)
 {
  SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(context);
  SharedPreferences.Editor e=sp.edit();
  e.putInt("compileTime",sp.getInt("compileTime",0)+1);
  e.commit();
  Toast.makeText(context,sp.getInt("compileTime",0)+"",Toast.LENGTH_SHORT).show();
 }
}

