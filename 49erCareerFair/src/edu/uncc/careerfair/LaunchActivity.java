package edu.uncc.careerfair;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class LaunchActivity extends Activity {

	ArrayList<String> launchs;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        
       
        ListView listView = (ListView) findViewById(R.id.listView1);
        launchs = new ArrayList<String>();
        launchs.add("Companies");
        launchs.add("Fair Map");
        

        LaunchAdapter adapter = new LaunchAdapter(this, R.layout.item_row_layout, launchs);
        adapter.setNotifyOnChange(true);
        listView.setAdapter(adapter);
        

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
       			 public void onItemClick(AdapterView<?> parent, View view, int position,
       					 long id) {
       				 if(position == 0){
       		        	Intent intent = new Intent(LaunchActivity.this, MainActivity.class);
       		        	startActivity(intent);
       				 }else{
       					 
       				 } 	 	 	 	 	
       			 }
        });
    }
}
