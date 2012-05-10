package com.yovoc.media;

import java.io.IOException;

import android.media.MediaRecorder;
import android.util.Log;

public class YovocRecorder {

	private MediaRecorder recorder;
	
	public YovocRecorder() {
		recorder = new MediaRecorder();
	}
	
	public void setRecordingsOutput(final String url) {
		recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		recorder.setOutputFile(url);
		recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
	}
	
	public void startRecording() {
		try{
			recorder.prepare();
		}catch(final IOException ex) {
			Log.e("Yovoc", "recordings prepares failed");
		}
		recorder.start();
	}
	
	public void stopRecording() {
		recorder.stop();
		recorder.release();
	}
}
