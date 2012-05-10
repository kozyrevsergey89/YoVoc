package com.yovoc.service;

import java.io.IOException;

import com.yovoc.media.YovocMediaPlayer;
import com.yovoc.media.YovocRecorder;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class YovocService extends Service{
	
	private YovocMediaPlayer ymp;
	private YovocRecorder recorder;
	
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

}
