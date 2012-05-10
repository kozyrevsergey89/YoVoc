package com.yovoc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class YovocAndroidActivity extends Activity {
    private String sharedText;
	private String sharedContentType;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        Intent intent = getIntent();
        if(intent != null)
        {
            if(intent.getType().endsWith("text/plain")){
            	String textToView = intent.getStringExtra(Intent.EXTRA_TEXT).toString();
            	TextView textview=(TextView)findViewById(R.id.testView); 
                textview.setText(textToView);	
            }
            else if (intent.getType().endsWith("image/*")){
            	//to do 
            	//work with images
            }

            else if (intent.getType().endsWith("media/*")){
            	//to do 
            	//work with media
            }
        }
        
        
    }
}