package edu.uncc.careerfair;

import java.util.ArrayList;
import java.util.List;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import edu.uncc.dataclasses.Event;

public class EventActivity extends Activity {
	final static String EVENT_KEY = "event";
	static ArrayList<Event> values   = new ArrayList<Event>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event);
		
		final ListView myListView = (ListView) findViewById(R.id.listViewEvent);
		Parse.initialize(this, "qX6M1NbiyH7Xp0aiRRM3NN3RVOQKXRLgT2PnMBsM",
				"zcSGGkNiYow6iaOKWaLz88PqC42jRlQkVgHva1Cc");

		ParseQuery<ParseObject> query = ParseQuery.getQuery("Event");
		query.orderByDescending("event_date").addAscendingOrder("event_name");
		query.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> eventList, ParseException e) {
		        if (e == null) {
		        	
		        	values.clear();
		        	for(int i = 0; i < eventList.size(); i++){
		        		Event event = new Event(eventList.get(i));
		        		//Log.d("event object", event.toString());
		        		values.add(event);
		        	}
		        	
		        	if(values.size()>0){
		        		EventListAdapter adapter = new EventListAdapter(EventActivity.this, values);
		        		 myListView.setAdapter(adapter);

		        		 myListView.setOnItemClickListener(new OnItemClickListener() {
		        					 public void onItemClick(AdapterView<?> parent, View view, int position,
		        							 long id) {
		        						 Intent intent = new Intent(EventActivity.this , EventDetailActivity.class);
		        						 Log.d("print value" ,values.get(position).toString() );
		        						 intent.putExtra(EVENT_KEY, values.get(position));
		        						 startActivity(intent);
		        					 }
		        		 });
		        		}
		        } else {
		            Log.d("score", "Error: " + e.getMessage());
		        }
		    }

		});
		
		 }
		}