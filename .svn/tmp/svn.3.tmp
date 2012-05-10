package com.yovoc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class YovocAndroidActivity extends Activity {
    private String sharedText;
	private String sharedContentType;
	//private YovocProvider dataProvider;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /*
        dataProvider = new YovocProvider(this);
        dataProvider.open();
        dataProvider.createTermin("hackathon", "coders competition");
        dataProvider.createTermin("coder", "machine for translating coffee into code");
        */
        
        
        TextView textview=(TextView)findViewById(R.id.testView); 
       /*
        String str = "";
        for(TermModel termin : dataProvider.getAllTermins()) {
        	str += ", " + termin.getTermin() + " " + termin.getDescription();
        }
        textview.setText(str);
        */
        
        Intent intent = getIntent();
        if(intent != null)
        {
            if(intent.getType().equals("text/plain")){
            	String textToView = intent.getStringExtra(Intent.EXTRA_TEXT).toString();
            	
                textview.setText(textToView);	
            }
            else if (intent.getType().equals("image/*")){
            	//to do 
            	//work with images
            }

            else if (intent.getType().equals("media/*")){
            	//to do 
            	//work with media
            }
         
        }
        
    }
}