package edu.uncc.careerfair;

import java.util.ArrayList;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import edu.uncc.database.DatabaseDataManager;
import edu.uncc.dataclasses.Company;

public class CompanyAdapter extends ArrayAdapter<Company> {
	Context context;
	ArrayList<Company> companies = new ArrayList<Company>();
	Company company = null;
	ImageView iv;
	TextView tv;
	DatabaseDataManager dm;

	public CompanyAdapter(Context context, int resource,
			ArrayList<Company> objects, DatabaseDataManager dm) {
		super(context, R.layout.gallery_row_item, objects);
		this.context = context;
		this.companies = (ArrayList<Company>) objects;
		this.dm = dm;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.gallery_row_item, parent,
					false);

		}

		company = companies.get(position);

		tv = (TextView) convertView.findViewById(R.id.textViewTitle);

		tv.setText(company.getName());

		tv.setOnClickListener(new textViewClickListener(position));

		iv = (ImageView) convertView.findViewById(R.id.imageViewStar);
		//Log.d("Log",company.toString());
		if(company.getVisitStatus().equals("")){
			company.setVisitStatus("unchecked");
		}
		if (company.getVisitStatus().equals("unchecked")) {
			//Log.d("1","1");
			iv.setImageResource(R.drawable.white);
			Picasso.with(context).load(R.drawable.white).into(iv);
			iv.setTag("unchecked");
		} else if (company.getVisitStatus().equals("tovisit")) {
			iv.setImageResource(R.drawable.red);
			Picasso.with(context).load(R.drawable.red).into(iv);
			iv.setTag("tovisit");
			//Log.d("2","2");
		} else if (company.getVisitStatus().equals("visited")) {
			iv.setImageResource(R.drawable.green);
			Picasso.with(context).load(R.drawable.green).into(iv);
			iv.setTag("visited");
			//Log.d("3","3");
		}

		iv.setOnClickListener(new imageViewClickListener(position));

		return convertView;
	}

	class textViewClickListener implements OnClickListener {
		int position;

		public textViewClickListener(int pos) {
			this.position = pos;
		}

		public void onClick(View v) {
			{
				//Log.d("position", companies.get(position).toString());
				Intent intent = new Intent(context, PreviewActivity.class);
				context.startActivity(intent);
			}

		}
	}

	class imageViewClickListener implements OnClickListener {
		int position;

		public imageViewClickListener(int pos) {
			this.position = pos;
		}

		public void onClick(View v) {
			{
//				Log.d("position", position + "");
//				Log.d("id", v.getId() + "");
//				Log.d("tag", v.getTag() + "");

				Company company = companies.get(position);
				if (company.getVisitStatus().equals("unchecked")
						&& v.getTag().equals("unchecked")) {

					((ImageView) v).setImageResource(R.drawable.red);
					v.setTag("tovisit");

					company.setVisitStatus("tovisit");
					MainActivity.companiesToVisit.add(company);
					
					dm.saveCompanyDao(company);
					
					notifyDataSetChanged();
				} else if (company.getVisitStatus().equals("tovisit")
						&& v.getTag().equals("tovisit")) {

					((ImageView) v).setImageResource(R.drawable.green);
					v.setTag("visited");

					company.setVisitStatus("visited");
					MainActivity.companiesToVisit.remove(company);
					MainActivity.companiesVisited.add(company);
					
					dm.updateCompanyDao(company);
					
					notifyDataSetChanged();
				} else if (company.getVisitStatus().equals("visited")
						&& v.getTag().equals("visited")) {

					((ImageView) v).setImageResource(R.drawable.white);
					v.setTag("unchecked");

					company.setVisitStatus("unchecked");
					MainActivity.companiesVisited.remove(company);
					dm.deleteCompanyDao(company);
					
					notifyDataSetChanged();
				}
			}

		}
	}
}