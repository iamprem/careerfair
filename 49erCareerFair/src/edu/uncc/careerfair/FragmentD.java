package edu.uncc.careerfair;
import android.app.Activity;
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
public class FragmentD extends Fragment {
	
	
	
	
	CompanyAdapter adapter = null;
    ListView listView = null;
    
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("VIVZ","onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null)
        {
            Log.d("VIVZ","onCreate FIRST TIME");
        }
        else
        {
            Log.d("VIVZ","onCreate SUBSEQUENT TIME");
        }

    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        Log.d("VIVZ","onCreateView");
        
        View rootView = inflater.inflate(R.layout.fragment_d, container, false);
        
        //Log.d("Companies",MainActivity.companies.toString());
        Log.d("VIVZ","onCreate FIRST TIME");
		listView = (ListView) rootView
				.findViewById(R.id.listView1);
		adapter = new CompanyAdapter(getActivity(),
				R.layout.company_row_item, MainActivity.companiesVisited, MainActivity.dm);
		adapter.setNotifyOnChange(true);
		if(listView.getChildAt(0) != null){
			listView.removeAllViews();
		}else{
			//listView.removeAllViews();
		}
		listView.setAdapter(adapter);
		
        return rootView;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("VIVZ","onActivityCreated");
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("VIVZ","onStart");
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("VIVZ","onResume");
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("VIVZ","onPause");
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("VIVZ","onSaveInstanceState");
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("VIVZ","onStop");
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("VIVZ","onDestroyView");
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("VIVZ","onDestroy");
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("VIVZ","onDetach");
        adapter.notifyDataSetChanged();
    }
    
    public interface OnRefreshListener {
        public void onRefresh();
    }

}
