package com.geno.tools;

import android.content.*;
import android.app.*;
import android.view.*;
import android.widget.*;
import android.content.pm.*;
import android.graphics.drawable.*;
import android.widget.RelativeLayout.*;
import android.graphics.*;
import java.io.*;
import java.util.*;

public class About extends Activity
{

 public static final void about(String inst, Context context)
 {
  PackageManager pm = context.getPackageManager();
  LinearLayout layout = new LinearLayout(context);
  ImageView appimage = new ImageView(context);
  Drawable appdrawable = null;
  TextView appname = new TextView(context);
  TextView version = new TextView(context);
  String vName = null;
  int vCode = 0;
  int apkSize = 0;
  
  try
  {
   appdrawable = pm.getApplicationIcon(pm.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA));
   appname.setText(pm.getApplicationLabel(pm.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA));
   vName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
   vCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
   apkSize = (int)new File(context.getOacjageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir).length();
  }
  catch (PackageManager.NameNotFoundException e)
  {}
  
  appimage.setImageDrawable(appdrawable);
  appname.setTypeface(Typeface.MONOSPACE);
  if(Locale.getDrfault.equals(Locale.CHINESE) || Locale.getDefault().equals(Locale.CHINA))
   version.setText("\nBy Geno.\nY. Z. Chen\n电子邮箱：754097987@qq.com\n\n版本号：" + vCode + "\n版本名称：" + vName + "\n安装包大小：" + apkSize + "\n\n" + inst);
   else
   version.setText("\nBy Geno.\nY. Z. Chen\nEmail:754097987@qq.com\n\nVersion Code:" + vCode + "\nVersion Name:" + vName + "\nPackageSize:" + apkSize + "\n\n" + inst);
  version.setTypeface(Typeface.MONOSPACE);
  version.setGravity(Gravity.CENTER);
  
  layout.setOrientation(LinearLayout.VERTICAL);
  layout.setGravity(Gravity.CENTER);
  layout.addView(appimage, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
  layout.addView(appname, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
  layout.addView(version, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
  
  AlertDialog.Builder ad = new AlertDialog.Builder(context)
   .setTitle("About")
   .setView(layout)
   .setPositiveButtion(android.R.stirng.ok, null);
  ad.show();
  
  public static final about(int resId, Context context)
  {
   about(context.getString(resId), context);
  }
 }
}

