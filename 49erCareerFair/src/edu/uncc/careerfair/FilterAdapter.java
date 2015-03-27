package edu.uncc.careerfair;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import edu.uncc.database.DatabaseDataManager;
import edu.uncc.dataclasses.Degrees;
import edu.uncc.dataclasses.Majors;
import edu.uncc.dataclasses.Positions;
import edu.uncc.dataclasses.WorkAuths;

public class FilterAdapter extends ArrayAdapter<String> {
	Context context;
	ArrayList<String> values = new ArrayList<String>();
	String value;
	ImageView iv;
	DatabaseDataManager dm;

	public FilterAdapter(Context context, int resource,
			ArrayList<String> objects, DatabaseDataManager dm) {
		super(context, R.layout.filter_row_item, objects);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.values = (ArrayList<String>) objects;
		this.dm = dm;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// Log.d("story adapter", "position: " + position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.filter_row_item, parent,
					false);
		}

		value = values.get(position);

		TextView titleText = (TextView) convertView
				.findViewById(R.id.textViewTitle);

		titleText.setText(value);

		iv = (ImageView) convertView.findViewById(R.id.imageViewStar);

		convertView.setOnClickListener(new listItemViewClickListener(position));

		return convertView;
	}

	class listItemViewClickListener implements OnClickListener {
		int position;

		public listItemViewClickListener(int pos) {
			this.position = pos;
		}

		public void onClick(View v) {
			{
				iv = (ImageView) v.findViewById(R.id.imageViewStar);
				if (iv.getTag().equals("unchecked")) {
					iv.setImageResource(R.drawable.accept);
					iv.setTag("checked");
					
					if(MainActivity.majors.contains(value)){
						Majors major = new Majors(value);
						dm.saveMajorsDao(major);
						
					}else if(MainActivity.positions.contains(value)){
						Positions position = new Positions(value);
						
					}else if(MainActivity.degrees.contains(value)){
						Degrees degree = new Degrees(value);
						
					}else if(MainActivity.workAuths.contains(value)){
						WorkAuths workAuth = new WorkAuths(value);
					}
					
				} else if (iv.getTag().equals("checked")) {
					iv.setImageDrawable(null);
					iv.setTag("unchecked");
				}

			}

		}
	}
}
