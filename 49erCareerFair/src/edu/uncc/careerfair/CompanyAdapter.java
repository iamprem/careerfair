package edu.uncc.careerfair;

import java.util.ArrayList;

import edu.uncc.dataclasses.Company;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CompanyAdapter extends ArrayAdapter<Company> {
	Context context;
	ArrayList<Company> companies = new ArrayList<Company>();
	Company company;

	public CompanyAdapter(Context context, int resource,
			ArrayList<Company> objects) {
		super(context, R.layout.gallery_row_item, objects);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.companies = (ArrayList<Company>) objects;
	}



	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// Log.d("story adapter", "position: " + position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.gallery_row_item, parent,
					false);
		}

		company = companies.get(position);

		// get views

		TextView titleText = (TextView) convertView
				.findViewById(R.id.textView1);

		titleText.setText(company.getName());

		return convertView;
	}

}
