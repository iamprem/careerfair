package edu.uncc.careerfair;

import java.util.ArrayList;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.SaveCallback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class LaunchActivity extends Activity {

	ArrayList<String> launchs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launch);
	
		Parse.initialize(this, "qX6M1NbiyH7Xp0aiRRM3NN3RVOQKXRLgT2PnMBsM",
				"zcSGGkNiYow6iaOKWaLz88PqC42jRlQkVgHva1Cc");
		ParseInstallation.getCurrentInstallation().saveInBackground();
		
		ListView listView = (ListView) findViewById(R.id.listViewEvent);
		launchs = new ArrayList<String>();
		launchs.add("Companies");
		launchs.add("Fair Map");
		launchs.add("Events");
		launchs.add("Announcement");
		launchs.add("Career Fair Prep");

		LaunchAdapter adapter = new LaunchAdapter(this,
				R.layout.item_row_layout, launchs);
		adapter.setNotifyOnChange(true);
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (position == 0) {
					Intent intent = new Intent(LaunchActivity.this,
							MainActivity.class);
					startActivity(intent);
				} else if (position == 1) {
					startActivity(new Intent(LaunchActivity.this,
							SwitchImageExampleActivity.class));
				} else if (position == 2) { // when event is clicked
					Intent intent = new Intent(LaunchActivity.this,
							EventActivity.class);
					startActivity(intent);
				} else if (position == 3) { // when event is clicked
					Intent intent = new Intent(LaunchActivity.this,
							Announcements.class);
					intent.putExtra("Announcements", 1001);
					startActivity(intent);
				}
			}
		});
	}
}
