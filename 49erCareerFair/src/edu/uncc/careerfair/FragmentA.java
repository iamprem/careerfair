package edu.uncc.careerfair;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import edu.uncc.dataclasses.Company;

/**
 * Created by Vivz on 10/25/13.
 */
public class FragmentA extends Fragment {

	CompanyAdapter adapter = null;
	ListView listView = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		Log.d("VIVZ", "onCreateView");

		View rootView = inflater.inflate(R.layout.fragment_a, container, false);

		Log.d("VIVZ", "onCreate FIRST TIME");
		listView = (ListView) rootView.findViewById(R.id.listView1);
		adapter = new CompanyAdapter(getActivity(), R.layout.gallery_row_item,
				MainActivity.companiesAll, MainActivity.dm);
		adapter.setNotifyOnChange(true);
		listView.setAdapter(adapter);

		return rootView;

	}
}
