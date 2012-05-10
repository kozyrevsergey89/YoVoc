package com.yovoc.service;



import media.YovocMediaPlayer;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class YovocService extends Service{
	
	private YovocMediaPlayer ymp;

	
	@Override
	public IBinder onBind(final Intent intent) {
		return new YovocBinder();
	}
	
	
	
	public class YovocBinder extends Binder {
		public YovocService getService() {
			return YovocService.this;
		}
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		ymp = new YovocMediaPlayer();
	}
	
	public void setUrlYmp(final String pathToFile){
        ymp.yovocMPSetURL(pathToFile);
	}
	
	public void startYmp(){
		ymp.yovocMPStart();
	}
	
	public void killYmp(){
		ymp.yovocMPStop();
	}

}
