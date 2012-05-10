package com.yovoc.app;

import com.yovoc.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;


public class YovocNotifications {
	
	private static final int APP_ID = 0;
	  
	  public void setNotification(final Context context, final Intent intent, final PendingIntent pendingIntent) {
	    
	      NotificationManager notificationManager = (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
	      Notification notification = new Notification(R.drawable.icon, "YoVoc", System.currentTimeMillis());
	      
	      String app_name = context.getString(R.string.app_name);
	      String invent = context.getString(R.string.invent);
	      
	      notification.setLatestEventInfo(context, app_name, invent,  pendingIntent);
	      
	      notificationManager.notify(APP_ID, notification);
	  }

	
}
