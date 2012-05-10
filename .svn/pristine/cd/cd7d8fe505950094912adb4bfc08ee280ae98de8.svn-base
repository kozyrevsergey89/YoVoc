package com.yovoc;

import com.yovoc.test.ChartView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class SetterActivity extends BasicActivity {

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*
		if (!getIntent().getExtras().containsKey("path")) {
			Uri uri = (Uri)getIntent().getExtras().get("path");
			Log.i("Yovoc", uri.getPath());
		}
		*/
		Intent charts = new ChartView(this).getChartsIntent();
		startActivity(charts);
	}
	
}
