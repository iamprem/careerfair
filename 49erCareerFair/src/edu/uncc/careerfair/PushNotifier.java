package edu.uncc.careerfair;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.parse.ParsePushBroadcastReceiver;

public class PushNotifier extends ParsePushBroadcastReceiver{

	@Override
	protected void onPushOpen(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		Log.e("Push", "Clicked");
        Intent i = new Intent(arg0, Announcements.class);
        Log.e("Push", arg0.toString());
        i.putExtras(arg1.getExtras());
        Log.e("Push", arg1.getExtras().getString(KEY_PUSH_DATA));
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        arg0.startActivity(i);
	}
}
