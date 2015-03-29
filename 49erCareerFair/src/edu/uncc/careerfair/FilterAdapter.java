package edu.uncc.careerfair;

import java.util.ArrayList;
import java.util.Collections;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import edu.uncc.database.DatabaseDataManager;
import edu.uncc.dataclasses.Degrees;
import edu.uncc.dataclasses.Majors;
import edu.uncc.dataclasses.Positions;
import edu.uncc.dataclasses.WorkAuths;

public class FilterAdapter extends ArrayAdapter<String> {
	Context context;
	ArrayList<String> values = new ArrayList<String>();
	ImageView iv;
	DatabaseDataManager dm;
	int filterScreenPos;

	public FilterAdapter(Context context, int resource,
			ArrayList<String> objects, DatabaseDataManager dm, int filterScreenPos) {
		super(context, R.layout.filter_row_item, objects);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.filterScreenPos = filterScreenPos;

		if (FilterActivity.sortWay == 1) {
			Collections.sort(objects, new CustomFilterComparator(FilterActivity.sortWay));
			this.values = (ArrayList<String>) objects;
		} else if (FilterActivity.sortWay == 2) {
			Collections.sort(objects, new CustomFilterComparator(FilterActivity.sortWay));
			this.values = (ArrayList<String>) objects;
		}  else if (FilterActivity.sortWay == 3) {
			FilterActivity.majorsFilterSorted.clear();
			FilterActivity.positionsFilterSorted.clear();
			FilterActivity.degreesFilterSorted.clear();
			FilterActivity.workAuthsFilterSorted.clear();

			FilterActivity.majorsFilterSorted.addAll(MainActivity.majorsSelected);
			FilterActivity.positionsFilterSorted.addAll(MainActivity.positionsSelected);
			FilterActivity.degreesFilterSorted.addAll(MainActivity.degreesSelected);
			FilterActivity.workAuthsFilterSorted.addAll(MainActivity.workAuthsSelected);

			FilterActivity.majorsFilterSorted.addAll(MainActivity.majors);
			FilterActivity.positionsFilterSorted.addAll(MainActivity.positions);
			FilterActivity.degreesFilterSorted.addAll(MainActivity.degrees);
			FilterActivity.workAuthsFilterSorted.addAll(MainActivity.workAuths);

			if(filterScreenPos == 1){
				this.values.addAll(FilterActivity.majorsFilterSorted);
			}else if(filterScreenPos == 2){
				this.values.addAll(FilterActivity.positionsFilterSorted);
			} else if(filterScreenPos == 3){
				this.values.addAll(FilterActivity.degreesFilterSorted);
			} else if(filterScreenPos == 4){
				this.values.addAll(FilterActivity.workAuthsFilterSorted);
			}

		}else{
			this.values = (ArrayList<String>) objects;
		}

		
		this.dm = dm;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		String value;
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

		if (MainActivity.majorsSelected.contains(value)) {

			iv.setTag("checked");
			// iv.setImageResource(R.drawable.accept);
			Picasso.with(context).load(R.drawable.accept).into(iv);

		} else if (MainActivity.positionsSelected.contains(value)) {

			iv.setTag("checked");
			// //iv.setImageResource(R.drawable.accept);
			Picasso.with(context).load(R.drawable.accept).into(iv);

		} else if (MainActivity.degreesSelected.contains(value)) {

			iv.setTag("checked");
			// iv.setImageResource(R.drawable.accept);
			Picasso.with(context).load(R.drawable.accept).into(iv);

		} else if (MainActivity.workAuthsSelected.contains(value)) {

			iv.setTag("checked");
			// iv.setImageResource(R.drawable.accept);
			Picasso.with(context).load(R.drawable.accept).into(iv);

		} else {

			iv.setTag("unchecked");
			iv.setImageDrawable(null);

		}

		convertView.setOnClickListener(new listItemViewClickListener(position));

		return convertView;
	}

	class listItemViewClickListener implements OnClickListener {
		int position;
		String value = null;

		public listItemViewClickListener(int pos) {
			this.position = pos;
			value = values.get(position);
		}

		public void onClick(View v) {
			{
				FilterActivity.refreshFilter = 1;
				iv = (ImageView) v.findViewById(R.id.imageViewStar);
				if (iv.getTag().equals("unchecked")) {
					Picasso.with(context).load(R.drawable.accept).into(iv);
					// iv.setImageResource(R.drawable.accept);
					iv.setTag("checked");

					if (MainActivity.majors.contains(value)) {
						Majors major = new Majors(value);
						dm.saveMajorsDao(major);

						MainActivity.majorsSelected.add(value);
						notifyDataSetChanged();
					} else if (MainActivity.positions.contains(value)) {
						Positions position = new Positions(value);
						dm.savePositionsDao(position);

						MainActivity.positionsSelected.add(value);
						notifyDataSetChanged();
					} else if (MainActivity.degrees.contains(value)) {
						Degrees degree = new Degrees(value);
						dm.saveDegreesDao(degree);

						MainActivity.degreesSelected.add(value);
						notifyDataSetChanged();
					} else if (MainActivity.workAuths.contains(value)) {
						WorkAuths workAuth = new WorkAuths(value);
						dm.saveWorkAuthsDao(workAuth);

						MainActivity.workAuthsSelected.add(value);
						notifyDataSetChanged();
					}

				} else if (iv.getTag().equals("checked")) {
					iv.setImageDrawable(null);
					iv.setTag("unchecked");

					if (MainActivity.majors.contains(value)) {
						Majors major = new Majors(value);
						dm.deleteMajorsDao(major);

						MainActivity.majorsSelected.remove(value);

					} else if (MainActivity.positions.contains(value)) {
						Positions position = new Positions(value);
						dm.deletePositionsDao(position);

						MainActivity.positionsSelected.remove(value);

					} else if (MainActivity.degrees.contains(value)) {
						Degrees degree = new Degrees(value);
						dm.deleteDegreesDao(degree);

						MainActivity.degreesSelected.remove(value);

					} else if (MainActivity.workAuths.contains(value)) {
						WorkAuths workAuth = new WorkAuths(value);
						dm.deleteWorkAuthsDao(workAuth);

						MainActivity.workAuthsSelected.remove(value);
					}
				}

			}

		}
	}
}
