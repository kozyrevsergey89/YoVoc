package com.yovoc;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

public class CameraActivity extends BasicActivity {

	public static final int MEDIA_TYPE_IMAGE = 1;
	public static final int MEDIA_TYPE_VIDEO = 2;
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST = 100;
	private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST = 200;
	private Uri uri;
	private File mediaFile;
	
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		uri = getFilesUri(MEDIA_TYPE_IMAGE);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
		startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST);
	}

	private Uri getFilesUri(final int type){
			return Uri.fromFile(getOutputMediaFile(type));
	}
	
	private File getOutputMediaFile(final int type) {
		File mediaStorage = new File(Environment.getExternalStorageDirectory(), "YovocCam");
		
		if(!mediaStorage.exists()) {
			if(!mediaStorage.mkdirs()){
				Log.e("Yovoc:", "Cannot create directory");
				return null;
			}
		}
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		
		if (type == MEDIA_TYPE_IMAGE) {
			mediaFile = new File(mediaStorage.getPath() + File.separator 
														 + "IMG_" + timeStamp 
														 + ".jpg");
		} else if (type == MEDIA_TYPE_VIDEO) {
			mediaFile = new File(mediaStorage.getPath() + File.separator 
														 + "VID_" + timeStamp
														 + ".mp4"); 
		} else {
			return null;
		}
		return mediaFile;
	}
	
	@Override
	protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
		if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST || requestCode == CAPTURE_VIDEO_ACTIVITY_REQUEST) {
			if(resultCode == RESULT_OK) {
				Uri uri = Uri.parse(mediaFile.getPath());
				startActivity(new Intent(this, SetterActivity.class).putExtra("path", uri));
			} else if (resultCode == RESULT_CANCELED) {
				startActivity(new Intent(this, SetterActivity.class));
			}
		}
	}
}
