package com.geno.tools;

import android.app.*;
import android.widget.*;
import android.content.*;

import java.util.*;

public class Widget
{
	public static void Toast(String text, Context context)
	{
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}

	public static void Toast(int resId, Context context)
	{
		Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
	}

	public static ProgressDialog ProgressDialog(String title, String message, Context context)
	{
		ProgressDialog d = new ProgressDialog(context);
		d.setTitle(title);
		d.setMessage(message);
		d.setCanceledOnTouchOutside(false);
		return d;
	}

	public static void ColorPicker(Context context, int originColor, final SharedPreferences.Editor e, final String colorSPName, @Nullable final TextView view)
	{
		LinearLayout l = new LinearLayout(context);
		l.setOrientation(LinearLayout.VERTICAL);
		final Button confirm = new Button(context);
		Button cancel = new Button(context);
		cancel.setText(android.R.string.cancel);
		confirm.setText(android.R.string.ok);
		cancel.setBackgroundColor(originColor);
		confirm.setBackgroundColor(originColor);
		cancel.setPadding(10, 10, 10, 10);
		confirm.setPadding(10, 10, 10, 10);
		TextView text_a = new TextView(context);
		TextView text_r = new TextView(context);
		TextView text_g = new TextView(context);
		TextView text_b = new TextView(context);
		text_a.setText(Locale.getDefault().equals(Locale.CHINESE) ? "透明度" : "Alpha");
		text_r.setText(Locale.getDefault().equals(Locale.CHINESE) ? "红" : "Red");
		text_g.setText(Locale.getDefault().equals(Locale.CHINESE) ? "绿" : "Green");
		text_b.setText(Locale.getDefault().equals(Locale.CHINESE) ? "蓝" : "Blue");
		text_a.setPadding(10, 10, 10, 10);
		text_r.setPadding(10, 10, 10, 10);
		text_g.setPadding(10, 10, 10, 10);
		text_b.setPadding(10, 10, 10, 10);
		final SeekBar color_A = new SeekBar(context);
		final SeekBar color_R = new SeekBar(context);
		final SeekBar color_G = new SeekBar(context);
		final SeekBar color_B = new SeekBar(context);
		color_A.setMax(255);
		color_R.setMax(255);
		color_G.setMax(255);
		color_B.setMax(255);
		color_A.setProgress((originColor & 0x7F000000) / 0x01000000 + (originColor < 0 ? 128 : 0));
		color_R.setProgress((originColor & 0x00FF0000) / 0x00010000);
		color_G.setProgress((originColor & 0x0000FF00) / 0x00000100);
		color_B.setProgress((originColor & 0x000000FF) / 0x00000001);
		SeekBar.OnSeekBarChangeListener c = new SeekBar.OnSeekBarChangeListener()
		{
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
			{
				int a = color_A.getProgress() * 0x01000000;
				int r = color_R.getProgress() * 0x00010000;
				int g = color_G.getProgress() * 0x00000100;
				int b = color_B.getProgress() * 0x00000001;
				color_A.setProgressDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{  + r + g + b, 0xFF000000 + r + g + b}));
				color_R.setProgressDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{a +   + g + b, a + 0x00FF0000 + g + b}));
				color_G.setProgressDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{a + r +   + b, a + r + 0x0000FF00 + b}));
				color_B.setProgressDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{a + r + g    , a + r + g + 0x000000FF}));
				confirm.setBackgroundColor(a + r + g + b);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar)
			{

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar)
			{

			}
		};
		color_A.setOnSeekBarChangeListener(c);
		color_R.setOnSeekBarChangeListener(c);
		color_G.setOnSeekBarChangeListener(c);
		color_B.setOnSeekBarChangeListener(c);
		l.addView(text_a);
		l.addView(color_A, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		l.addView(text_r);
		l.addView(color_R, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		l.addView(text_g);
		l.addView(color_G, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		l.addView(text_b);
		l.addView(color_B, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		final Dialog d;
		AlertDialog.Builder a = new AlertDialog.Builder(context).setView(l);
		d = a.create();
		View.OnClickListener apply = new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				e.putInt(colorSPName, color_A.getProgress() * 0x01000000 + color_R.getProgress() * 0x00010000 + color_G.getProgress() * 0x00000100 + color_B.getProgress() * 0x00000001);
				e.commit();
				view.setTextColor(color_A.getProgress() * 0x01000000 + color_R.getProgress() * 0x00010000 + color_G.getProgress() * 0x00000100 + color_B.getProgress() * 0x00000001);
				d.dismiss();
			}
		};
		confirm.setOnClickListener(apply);
		View.OnClickListener canc = new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				d.dismiss();
			}
		};
		cancel.setOnClickListener(canc);
		l.addView(cancel);
		l.addView(confirm);
		d.show();
	}
}
