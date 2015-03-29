package edu.uncc.careerfair;

import edu.uncc.dataclasses.Event;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class EventDetailActivity extends Activity {
	TextView eventName, timeInfo , venueInfo , detailsInfo , contactInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_detail);
		eventName= (TextView) findViewById(R.id.textViewEventName);
		timeInfo = (TextView) findViewById(R.id.textViewTimeDetail);
		venueInfo = (TextView) findViewById(R.id.textViewVenue);
		detailsInfo = (TextView) findViewById(R.id.textViewDetails);
		contactInfo = (TextView) findViewById(R.id.textViewContactInfo);
		
		if(getIntent().getExtras()!=null){
			Event event = (Event) getIntent().getExtras().getSerializable(EventActivity.EVENT_KEY);
			Log.d("In detail" , event.toString());
			
			eventName.setText(event.getEventName());
			timeInfo.setText(event.getTimeToShow());
			venueInfo.setText(event.getEventVenue());
			detailsInfo.setText(event.getEventDetail());
			contactInfo.setText(event.getContactToShow());
		}
	}
}
