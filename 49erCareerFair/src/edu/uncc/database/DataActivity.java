package edu.uncc.database;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import edu.uncc.careerfair.R;
import edu.uncc.dataclasses.Company;

public class DataActivity extends Activity{

	DatabaseDataManager dm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 dm = new DatabaseDataManager(this);
		 
		 dm.saveCompanyDao(new Company(1,"Note1" , "Note1 text"));
		 dm.saveCompanyDao(new Company(2,"Note2" , "Note2 text"));
		 List<Company> allList = dm.getAllCompanyDao();
	             
	        for (Company company : allList) {
				Log.d("demo", company.toString());
			}
	        ListView myListView = (ListView) findViewById(R.id.listView1);
//	        ArrayAdapter<Note> adapter = new ArrayAdapter<Company>(this,
//	        android.R.layout.simple_list_item_1, android.R.id.text1, allList);
//	        myListView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	
}
	
	@Override
	protected void onDestroy() {
		
		super.onDestroy();
		dm.close();
	}

}
