package edu.uncc.careerfair;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ListView;

public class FilterActivity extends FragmentActivity {

	public static int refreshFilter = 0;
	public static int sortWay = 1;
	ViewPager viewPager = null;

	public static LinkedHashSet<String> majorsFilterSorted = new LinkedHashSet<String>();
	public static LinkedHashSet<String> positionsFilterSorted = new LinkedHashSet<String>();
	public static LinkedHashSet<String> degreesFilterSorted = new LinkedHashSet<String>();
	public static LinkedHashSet<String> workAuthsFilterSorted = new LinkedHashSet<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		if(sortWay == 1){
//			Collections.sort(MainActivity.majors);
//			Collections.sort(MainActivity.positions);
//			Collections.sort(MainActivity.degrees);
//			Collections.sort(MainActivity.workAuths);
//		}
		
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
		((FilterAdapter) ((ListView) ((SmartFragmentStatePagerAdapter) viewPager
				.getAdapter()).getRegisteredFragment(currentIndex).getView()
				.findViewById(R.id.listView1)).getAdapter())
				.notifyDataSetChanged();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.filer, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_clear) {
			MainActivity.dm.deleteAllMajorsDao();
			MainActivity.dm.deleteAllPositionsDao();
			MainActivity.dm.deleteAllDegreesDao();
			MainActivity.dm.deleteAllWorkAuthsDao();

			MainActivity.majorsSelected.clear();
			MainActivity.positionsSelected.clear();
			MainActivity.degreesSelected.clear();
			MainActivity.workAuthsSelected.clear();

			refreshFilter = 1;
			finish();
			startActivity(getIntent());
			return true;
		} else if (id == R.id.action_sort_asc) {
			sortWay = 1;
			finish();
			startActivity(getIntent());
			return true;
		} else if (id == R.id.action_sort_desc) {
			sortWay = 2;
			finish();
			startActivity(getIntent());
			return true;
		}else if (id == R.id.action_sort_selected) {
			sortWay = 3;
			finish();
			startActivity(getIntent());
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		if (refreshFilter == 0) {
			setResult(RESULT_CANCELED);
		} else if (refreshFilter == 1) {
			setResult(RESULT_OK);
		}
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
