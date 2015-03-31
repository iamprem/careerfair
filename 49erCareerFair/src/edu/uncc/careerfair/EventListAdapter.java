package edu.uncc.careerfair;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import edu.uncc.dataclasses.Event;

public class EventListAdapter extends ArrayAdapter<Event>{
Context context;
ArrayList<Event> objects;

public EventListAdapter(Context context, ArrayList<Event> objects) {
	 	 super(context, R.layout.item_row_layout, objects);
	 	 this.context = context;
	 	 this.objects = objects;
}
@Override
public View getView(int position, View convertView, ViewGroup parent) {
	 	 LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 	 View itemRowView = inflater.inflate(R.layout.event_single_row, parent, false);
				
	 	 TextView eventName = (TextView) itemRowView.findViewById(R.id.eventTitle);
	 	 TextView eventDayandTime = (TextView) itemRowView.findViewById(R.id.eventDayTime); 	 	 	 	
	 	 eventName.setText(objects.get(position).getEventName());
	 	 StringBuilder sb = new StringBuilder();
	 	 eventDayandTime.setText(objects.get(position).getTimeToShow());	 	 	 	
	 	 return itemRowView;		 	 	
}
}