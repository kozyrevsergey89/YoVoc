package com.yovoc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class TestActivity extends BasicActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.testing);
		Intent intent = getIntent();
        if(intent != null){
        	final String intentAction = intent.getAction();
        	if (Intent.ACTION_MAIN.equals(intentAction)) {
        		String contextMessage = "I've just started from notification";
        		Toast.makeText(this, contextMessage, Toast.LENGTH_SHORT).show();
        	}
        }
	}
	

}
