package edu.uncc.careerfair;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParsePush;
import com.parse.SaveCallback;

public class Announcements extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_announcements);
		
		
		if(getIntent().getExtras().containsKey("Announcements")){
			
		}else{
		ParsePush.subscribeInBackground("", new SaveCallback() {
			@Override
			public void done(ParseException e) {
				if (e == null) {
					Log.d("com.parse.push",
							"successfully subscribed to the broadcast channel.");
					 Toast.makeText(Announcements.this, "Hello",
					 Toast.LENGTH_LONG).show();
					if (getIntent().getExtras().containsKey(PushNotifier.KEY_PUSH_DATA)) {
						String JSONString = getIntent().getExtras().getString(
								PushNotifier.KEY_PUSH_DATA);
						Log.d("Push", JSONString);

						if(!JSONString.equals("")){
						AlertDialog.Builder builder = new AlertDialog.Builder(
								Announcements.this);
						builder.setTitle("49er Career Fair").setMessage(
								JSONString);

						final AlertDialog alert = builder.create();
						alert.show();
						}

					}

				} else {
					Log.e("com.parse.push", "failed to subscribe for push", e);
				}
			}
		});
		}
	}
}
