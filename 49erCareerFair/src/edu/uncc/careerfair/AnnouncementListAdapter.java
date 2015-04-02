package edu.uncc.careerfair;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import edu.uncc.dataclasses.AnnouncementsData;
import edu.uncc.dataclasses.Event;

public class AnnouncementListAdapter extends ArrayAdapter<AnnouncementsData>{
	Context context;
	ArrayList<AnnouncementsData> objects;

	public AnnouncementListAdapter(Context context, ArrayList<AnnouncementsData> objects) {
		 	 super(context, R.layout.item_row_layout, objects);
		 	 this.context = context;
		 	 this.objects = objects;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		 	 LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		 	 View itemRowView = inflater.inflate(R.layout.event_single_row, parent, false);
					
		 	 TextView aName = (TextView) itemRowView.findViewById(R.id.eventTitle);
		 	 TextView aDayandTime = (TextView) itemRowView.findViewById(R.id.eventDayTime); 	 	 	 	
		 	 aName.setText(objects.get(position).getAnnouncement());
		 	 aDayandTime.setText(objects.get(position).getTimeToShow());	 	 	 	
		 	 return itemRowView;		 	 	
	}
	}