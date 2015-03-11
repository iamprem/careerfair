package edu.uncc.careerfair;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class LaunchAdapter extends ArrayAdapter<String> {
	Context context;
	ArrayList<String> objects = new ArrayList<String>();
	String listViewItemName;
	
	public LaunchAdapter(Context context, int resource, ArrayList<String> objects) {
		super(context, R.layout.item_row_layout, objects);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.objects = (ArrayList<String>) objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// Log.d("story adapter", "position: " + position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.item_row_layout, parent,
					false);
		}

		listViewItemName = objects.get(position);

		// get views
		ImageView iv = (ImageView) convertView.findViewById(R.id.imageView1);
		TextView titleText = (TextView) convertView
				.findViewById(R.id.textView1);

		if (listViewItemName.equals("Companies")) {
			Picasso.with(context).load(R.drawable.companies).into(iv);
			titleText.setText("Companies");
		} else {
			Picasso.with(context).load(R.drawable.fairmap).into(iv);
			titleText.setText("Fair Map");
		}
		
		return convertView;
	}

}
