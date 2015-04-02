package edu.uncc.careerfair;

import java.util.ArrayList;
import java.util.List;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParsePush;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import edu.uncc.dataclasses.AnnouncementsData;
import edu.uncc.dataclasses.Event;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class AnnouncementListActivity extends Activity {
	final static String ANN_KEY = "ann";
	static ArrayList<AnnouncementsData> values   = new ArrayList<AnnouncementsData>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_announcement_list);
		
///***************		
if(getIntent().getExtras().containsKey("Announcements")){
			
		}else{
		ParsePush.subscribeInBackground("", new SaveCallback() {
			@Override
			public void done(ParseException e) {
				if (e == null) {
					Log.d("com.parse.push",
							"successfully subscribed to the broadcast channel.");
					 Toast.makeText( AnnouncementListActivity.this, "Hello",
					 Toast.LENGTH_LONG).show();
					if (getIntent().getExtras().containsKey(PushNotifier.KEY_PUSH_DATA)) {
						String JSONString = getIntent().getExtras().getString(
								PushNotifier.KEY_PUSH_DATA);
						Log.d("Push", JSONString);

						if(!JSONString.equals("")){
						AlertDialog.Builder builder = new AlertDialog.Builder(
								 AnnouncementListActivity.this);
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
		
	//****************	
		
		final ListView myListView = (ListView) findViewById(R.id.listViewAnnoun);
		Parse.initialize(this, "qX6M1NbiyH7Xp0aiRRM3NN3RVOQKXRLgT2PnMBsM",
				"zcSGGkNiYow6iaOKWaLz88PqC42jRlQkVgHva1Cc");

		ParseQuery<ParseObject> query = ParseQuery.getQuery("Announcement");
		query.orderByDescending("a_date").addAscendingOrder("a_name");
		query.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> annList, ParseException e) {
		        if (e == null) {
		        	
		        	values.clear();
		        	for(int i = 0; i < annList.size(); i++){
		        		AnnouncementsData ann = new AnnouncementsData(annList.get(i));
		        		//Log.d("event object", event.toString());
		        		values.add(ann);
		        	}
		        	
		        	if(values.size()>0){
		        		AnnouncementListAdapter adapter = new AnnouncementListAdapter(AnnouncementListActivity.this, values);
		        		 myListView.setAdapter(adapter);

		        		}
		        } else {
		            Log.d("score", "Error: " + e.getMessage());
		        }
		    }

		});
		
		 }
		}