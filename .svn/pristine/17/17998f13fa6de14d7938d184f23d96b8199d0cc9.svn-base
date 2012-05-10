package com.yovoc;

import com.yovoc.service.YovocService;
import com.yovoc.service.YovocService.YovocBinder;

import media.YovocMediaPlayer;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.TextView;

public class YovocAndroidActivity extends Activity {
    private String sharedText;
	private String sharedContentType;
	private YovocMediaPlayer ymp;
	private YovocService yovocService;
	private boolean bound;
	private YovocServiceConnection serviceConnection; 
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
        
        serviceConnection = new YovocServiceConnection();
        
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
    
	@Override
	protected void onStart() {
		super.onStart();
		Intent binderIntent = new Intent(this, YovocService.class);
		bindService(binderIntent, serviceConnection, Context.BIND_AUTO_CREATE);
	}
	
	//disbinding from service
	
	@Override
	protected void onStop() {
		super.onStop();
		if(bound) {
			unbindService(serviceConnection);
			bound = false;
		}
	}
	
    
    
    //binder for service
    private class YovocServiceConnection implements ServiceConnection {

		public void onServiceConnected(final ComponentName name, final IBinder service) {
			YovocBinder yovocBinder = (YovocBinder) service;
			yovocService = yovocBinder.getService();
			bound = true;
		}

		public void onServiceDisconnected(final ComponentName name) { bound = false; }
	}
    
    @Override
    public void onDestroy() {
    	ymp.yovocMPStop();
        super.onDestroy();
}
    
    
}