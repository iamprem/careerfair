<<<<<<< HEAD
package edu.uncc.careerfair;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import edu.uncc.dataclasses.Event;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EventDetailActivity extends Activity {
	TextView eventName, timeInfo , venueInfo , detailsInfo , contactInfo;
	Button bttnAdd , bttnCall,bttnEmail;
	Event event;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_detail);
		eventName= (TextView) findViewById(R.id.textViewEventName);
		timeInfo = (TextView) findViewById(R.id.textViewTimeDetail);
		venueInfo = (TextView) findViewById(R.id.textViewVenue);
		detailsInfo = (TextView) findViewById(R.id.textViewDetails);
		contactInfo = (TextView) findViewById(R.id.textViewContactInfo);
		bttnAdd = (Button)findViewById(R.id.buttonCalender);
		bttnCall = (Button)findViewById(R.id.buttonCall);
		bttnEmail = (Button)findViewById(R.id.buttonEmail);
		
		if(getIntent().getExtras()!=null){
			event = (Event) getIntent().getExtras().getSerializable(EventActivity.EVENT_KEY);
			Log.d("In detail" , event.toString());
			
			eventName.setText(event.getEventName());
			timeInfo.setText(event.getTimeToShow());
			venueInfo.setText(event.getEventVenue());
			detailsInfo.setText(event.getEventDetail());
			contactInfo.setText(event.getContactPerson());
			
			//Log.d("Extra date" , ""+event.getExtraDate());
			//To call contact
			bttnCall.setText(event.getContact());
			bttnCall.setOnClickListener(new View.OnClickListener() {
			String number = event.getContact().replaceAll("-", "");
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(Intent.ACTION_CALL , Uri.parse("tel:"+number));
					startActivity(intent);
					
				}
			});
			
			bttnEmail.setText(event.getContactEmail());
			bttnEmail.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent i = new Intent(Intent.ACTION_SEND);
					i.setType("message/rfc822");
					i.putExtra(Intent.EXTRA_EMAIL  , new String[]{event.getContactEmail()});
					i.putExtra(Intent.EXTRA_SUBJECT, "Query regarding "+event.getEventName() +" event");
					//i.putExtra(Intent.EXTRA_TEXT   , "body of email");
					try {
					    startActivity(Intent.createChooser(i, "Send mail..."));
					} catch (android.content.ActivityNotFoundException ex) {
					    Toast.makeText(EventDetailActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
					}
					
				}
			});
			
			
			
			
			//To add event to Calendar
			bttnAdd.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					//Date formatting
					DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
					Date date = new Date(01/01/2015);
					try {
						date = formatter.parse(event.geteventDate());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				    Calendar cal = Calendar.getInstance();
				    cal.clear();
				    cal.setTime(date);
				    int year = cal.get(Calendar.YEAR);
				    int month = cal.get(Calendar.MONTH);
				    int day = cal.get(Calendar.DAY_OF_MONTH);
				    
				    //time formating
				    String startTimeIn , endTimeIn;
				    String time = event.getEventTime();
				    String timeArray[] = time.split("-");
				   
				    //event Start time
				    String str = timeArray[0].trim();
				    Date timeParsed = null;
				    DateFormat formatterTime = new SimpleDateFormat("hh:mm a");
				    try {
						timeParsed = (Date)formatterTime.parse(str);	
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    cal.clear();
				    cal.setTime(timeParsed);
				    int startHour = cal.get(Calendar.HOUR);
				    int startMin = cal.get(Calendar.MINUTE);
				   // int am_pm = cal.get(Calendar.AM_PM);
				    
				    
				    
				    //event end Time
				    Log.d("end time" , timeArray[1]);
				    String str1 = timeArray[1].trim();
				    Date timeParsedEnd = null;
				   
				    try {
				    	timeParsedEnd = (Date)formatterTime.parse(str1);	
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    cal.clear();
				    cal.setTime(timeParsedEnd);
				    int endHour = cal.get(Calendar.HOUR);
				    int endMin = cal.get(Calendar.MINUTE);
				    
				    Log.d("year" , ""+year);
				    Log.d("month" , ""+month);
				    Log.d("day" , ""+day);
					
					
					final int JAN = 01;
					Calendar beginCal = Calendar.getInstance();
					beginCal.clear();
	                beginCal.set(year, month, day, startHour, startMin);
	                long startTime = beginCal.getTimeInMillis();

	                Calendar endCal = Calendar.getInstance();
	                endCal.clear();
	                endCal.set(year, month, day,endHour,endMin);
	                long endTime = endCal.getTimeInMillis();     

	                Intent intent = new Intent(Intent.ACTION_INSERT);
	                intent.setType("vnd.android.cursor.item/event");
	                String summary= "Test";
					intent.putExtra(Events.TITLE, event.getEventName());
	               // intent.putExtra(Events.DESCRIPTION, summar);
	                intent.putExtra(Events.EVENT_LOCATION, event.getEventVenue());     
	                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginCal.getTimeInMillis());
	                intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endCal.getTimeInMillis());
	                //intent.putExtra(Events.ALL_DAY, allDayFlag);
	                intent.putExtra(Events.STATUS, 1);
	                intent.putExtra(Events.VISIBLE, 0);
	               intent.putExtra(Events.HAS_ALARM, 1);
	                startActivity(intent);
				}
			});

			
		}
	}
}
=======
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
>>>>>>> 2c5d44b1cd7214fe649610cbee13a2224612ef77
