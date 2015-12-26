package com.geno.tools;

import android.os.*;
import android.app.*;
import android.view.*;
import android.util.*;
import android.content.*;

import java.io.*;
import java.text.*;
import java.util.*;

public class System
{
	public static final void execSu(String[] arrstring) throws IOException
	{
		java.lang.Process process = Runtime.getRuntime.exec("su");
		DataOutputStream o = new DataOutputStream(process.getOutputStream());
		String string2 = "";
		for (String string3 : arrstring)
			string2 = (string2 + string3 + " ");
		o.writeBytes((string2 + "\nexit\n"));
		o.flush();
	}
	
	public static final void execSu(String cmd) throws IOException
	{
		java.lang.Process process = Runtime.getRuntime.exec("su");
		DataOutputStream o = new DataOutputStream(process.getOutputStream());
		o.writeBytes(cmd + "\nexit\n"));
		o.flush();
	}

	public static float dp2px(int dp, Context context)
	{
		DisplayMetrics metrics = new DisplayMetrics();
		WindowManager wm = ((WindowManager)context.getSystemService(Context.WINDOW_SERVICE));
		wm.getDefaultDisplay().getMetrics(metrics);
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, metrics);
	}

	public static String UTC2Date(long UTCTime)
	{
		String date;
		SimpleDateFormat date_Format;
		if(Locale.getDefault().equals(Locale.CHINESE))
		{
			date_Format = new SimpleDateFormat("yyyy年MM月dd日", Locale.CHINESE);
		}
		else
		{
			date_Format = new SimpleDateFormat("yyyy.MM.dd", Locale.US);
		}
		date = date_Format.format(new Date(UTCTime));
		return date;
	}


	public static void FakeFull(Activity activity, int layoutId, int mainViewId)
	{
		activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
		activity.setTheme(android.R.style.Theme_DeviceDefault_Wallpaper);
		activity.setContentView(layoutId);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
		{
			Window window = activity.getWindow();
			window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		}
		activity.findViewById(mainViewId).setPadding(0, Methods.getStatusHeight(activity), 0, 0);
	}
}
