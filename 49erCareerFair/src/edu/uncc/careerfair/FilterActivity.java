package edu.uncc.careerfair;

import java.util.ArrayList;
import java.util.HashSet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ListView;
import edu.uncc.database.DatabaseDataManager;
import edu.uncc.dataclasses.Company;

public class FilterActivity extends FragmentActivity {

	static DatabaseDataManager dm;

	ViewPager viewPager = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		viewPager = (ViewPager) FilterActivity.this.findViewById(R.id.pager);

		FragmentManager fragmentManager = getSupportFragmentManager();
		viewPager.setAdapter(new MyAdapterFilter(fragmentManager));

		viewPager.setOffscreenPageLimit(0);

		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// ((OnRefreshListener)
				// viewPager.getAdapter().(position)).onRefresh();
				refreshMe(position);

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				// viewPager.getAdapter().notifyDataSetChanged();
				// refreshMe();
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				// viewPager.getAdapter().notifyDataSetChanged();
				// refreshMe();
			}

		});

	}

	private void refreshMe(int currentIndex) {
		// TODO Auto-generated method stub
		viewPager.clearDisappearingChildren();
		viewPager.getAdapter().notifyDataSetChanged();
		(((SmartFragmentStatePagerAdapter) viewPager.getAdapter())
				.getRegisteredFragment(currentIndex)).getView().findViewById(
				R.id.listView1);
		((FilterAdapter) ((ListView) ((SmartFragmentStatePagerAdapter) viewPager
				.getAdapter()).getRegisteredFragment(currentIndex).getView()
				.findViewById(R.id.listView1)).getAdapter())
				.notifyDataSetChanged();
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
			Intent intent = new Intent(FilterActivity.this,
					FilterActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		finish();
		super.onBackPressed();
	}

}

class MyAdapterFilter extends SmartFragmentStatePagerAdapter {

	public MyAdapterFilter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int i) {
		Fragment fragment = null;
		// Log.d("VIVZ", "get Item is called "+i);
		if (i == 0) {
			Log.d("A", "A");
			fragment = new FragmentE();
		}
		if (i == 1) {
			Log.d("B", "B");
			fragment = new FragmentF();
		}
		if (i == 2) {
			Log.d("C", "C");
			fragment = new FragmentG();
		}
		if (i == 3) {
			Log.d("D", "D");
			fragment = new FragmentH();
		}
		return fragment;
	}

	@Override
	public int getCount() {
		// Log.d("VIVZ", "get Count is called");
		return 4;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		if (position == 0) {
			return "Majors";
		}
		if (position == 1) {
			return "Positions";
		}
		if (position == 2) {
			return "Degree";
		}
		if (position == 3) {
			return "Work Auths";
		}
		return null;
	}

	@Override
	public int getItemPosition(Object object) {
		// TODO Auto-generated method stub
		return super.getItemPosition(object);
	}

	@Override
	public Object instantiateItem(ViewGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		Log.d("called", "called");

		return super.instantiateItem(arg0, arg1);
	}
}
