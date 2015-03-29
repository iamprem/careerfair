package edu.uncc.careerfair;

import android.util.Log;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParsePush;
import com.parse.ParsePushBroadcastReceiver;
import com.parse.PushService;
import com.parse.SaveCallback;

public class Application extends android.app.Application {

	public Application() {
	}

	@Override
	public void onCreate() {
		super.onCreate();

		// Initialize the Parse SDK.
		Parse.initialize(this, "qX6M1NbiyH7Xp0aiRRM3NN3RVOQKXRLgT2PnMBsM",
				"zcSGGkNiYow6iaOKWaLz88PqC42jRlQkVgHva1Cc");

		// Specify an Activity to handle all pushes by default.
		PushService.setDefaultPushCallback(this, MainActivity.class);

	}
	
}