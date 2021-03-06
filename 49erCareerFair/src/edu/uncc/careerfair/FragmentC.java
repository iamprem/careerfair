package edu.uncc.careerfair;
import java.util.ArrayList;

import edu.uncc.dataclasses.Company;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Vivz on 10/25/13.
 */
public class FragmentC extends Fragment {
	
	CompanyAdapter adapter = null;
    ListView listView = null;
	

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        Log.d("VIVZ","onCreateView");
        
        View rootView = inflater.inflate(R.layout.fragment_c, container, false);
        
        //Log.d("Companies",MainActivity.companies.toString());
        Log.d("VIVZ","onCreate FIRST TIME");
		listView = (ListView) rootView
				.findViewById(R.id.listView1);
		adapter = new CompanyAdapter(getActivity(),
				R.layout.company_row_item, MainActivity.companiesToVisit, MainActivity.dm);
		adapter.setNotifyOnChange(true);
		if(listView.getChildAt(0) != null){
			listView.removeAllViews();
		}else{
			//listView.removeAllViews();
		}
		listView.setAdapter(adapter);
		
        return rootView;
    }
}
