package com.yovoc.service;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import com.yovoc.app.YovocNotifications;
import com.yovoc.media.YovocMediaPlayer;
import com.yovoc.media.YovocRecorder;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class YovocService extends Service{
	
	private YovocMediaPlayer ymp;
	private YovocRecorder recorder;
	private YovocNotifications yovocNotifications;
	private Timer timer;
	private TimerTask timerTask;
	
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
		recorder = new YovocRecorder();
		yovocNotifications = new YovocNotifications();
		timer = new Timer();
		
		sendNotification();
		try {
			timer.scheduleAtFixedRate(new TestTask(), 10000, 1000*60*30);
		} catch (IllegalArgumentException e)  {
			e.printStackTrace();
		} catch (IllegalStateException e){
			e.printStackTrace();
		}
		
		 
	}
	
	public void setRecordingsOutput(final String url) {
		recorder.setRecordingsOutput(url);
	}
	
	public void startRecording() {
		recorder.startRecording();
	}
	
	public void stopRecording() {
		recorder.stopRecording();
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
	
	public void sendNotification(){
		
		final Intent serviceIntent = new Intent();
	    serviceIntent.setAction("com.yovoc.TestActivity");
	    PendingIntent pendingService = PendingIntent.getService(getApplicationContext(), 0, serviceIntent, PendingIntent.FLAG_ONE_SHOT);
		yovocNotifications.setNotification(this, serviceIntent, pendingService);
	}
	
	class TestTask extends TimerTask {
        public void run() {
            sendNotification();
            timer.cancel(); //Terminate the timer thread
        }}
	
}

