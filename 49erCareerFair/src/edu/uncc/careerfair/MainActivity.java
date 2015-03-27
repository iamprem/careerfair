package edu.uncc.careerfair;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
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

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import edu.uncc.database.DatabaseDataManager;
import edu.uncc.dataclasses.Company;

public class MainActivity extends FragmentActivity {

	private SmartFragmentStatePagerAdapter adapterViewPager;

	static DatabaseDataManager dm;

	public static ArrayList<Company> companiesAll = new ArrayList<Company>();
	public static ArrayList<Company> companiesFiltered = new ArrayList<Company>();
	public static ArrayList<Company> companiesToVisit = new ArrayList<Company>();
	public static ArrayList<Company> companiesVisited = new ArrayList<Company>();

	public static ArrayList<String> majorsSelected = new ArrayList<String>();
	public static ArrayList<String> positionsSelected = new ArrayList<String>();
	public static ArrayList<String> degreesSelected = new ArrayList<String>();
	public static ArrayList<String> workAuthsSelected = new ArrayList<String>();

	public static ArrayList<String> majors = new ArrayList<String>();
	public static ArrayList<String> positions = new ArrayList<String>();
	public static ArrayList<String> degrees = new ArrayList<String>();
	public static ArrayList<String> workAuths = new ArrayList<String>();

	ViewPager viewPager = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		dm = new DatabaseDataManager(this);

		Parse.initialize(this, "qX6M1NbiyH7Xp0aiRRM3NN3RVOQKXRLgT2PnMBsM",
				"zcSGGkNiYow6iaOKWaLz88PqC42jRlQkVgHva1Cc");

		ParseQuery<ParseObject> query = ParseQuery.getQuery("Company");

		query.findInBackground(new FindCallback<ParseObject>() {

			@Override
			public void done(List<ParseObject> objects, ParseException e) {
				// Log.d("4", "4");
				if (e == null) {
					// Log.d("5", "5");
					companiesAll.clear();
					companiesFiltered.clear();
					companiesToVisit.clear();
					companiesVisited.clear();
					
					majors.clear();
					positions.clear();
					degrees.clear();
					workAuths.clear();
					
					for (ParseObject o : objects) {
						// Log.d("6", "6");
						Company a = new Company(o);

						if (dm.getCompanyDao(a.getCompany_id()) != null) {
							Company com = dm.getCompanyDao(a.getCompany_id());
							a.setVisitStatus(com.getVisitStatus());

							if (a.getVisitStatus().equals("tovisit")) {
								companiesToVisit.add(a);
							} else if (a.getVisitStatus().equals("visited")) {
								companiesVisited.add(a);
							}
						}
						companiesAll.add(a);

					}
				} else {
					
				}

				MainActivity.majors.addAll(Company.majorsAll);
				MainActivity.positions.addAll(Company.positionsAll);
				MainActivity.degrees.addAll(Company.degreesAll);
				MainActivity.workAuths.addAll(Company.workAuthsAll);

				viewPager = (ViewPager) MainActivity.this
						.findViewById(R.id.pager);

				FragmentManager fragmentManager = getSupportFragmentManager();
				viewPager.setAdapter(new MyAdapter(fragmentManager));

				viewPager.setOffscreenPageLimit(0);

				viewPager
						.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

							@Override
							public void onPageSelected(int position) {
								// ((OnRefreshListener)
								// viewPager.getAdapter().(position)).onRefresh();
								refreshMe(position);

							}

							@Override
							public void onPageScrolled(int arg0, float arg1,
									int arg2) {
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

		});

	}

	private void refreshMe(int currentIndex) {
		// TODO Auto-generated method stub
		viewPager.clearDisappearingChildren();
		viewPager.getAdapter().notifyDataSetChanged();
		(((SmartFragmentStatePagerAdapter) viewPager.getAdapter())
				.getRegisteredFragment(currentIndex)).getView().findViewById(
				R.id.listView1);
		((CompanyAdapter) ((ListView) ((SmartFragmentStatePagerAdapter) viewPager
				.getAdapter()).getRegisteredFragment(currentIndex).getView()
				.findViewById(R.id.listView1)).getAdapter())
				.notifyDataSetChanged();
		// adapterViewPager.getRegisteredFragment(viewPager.getCurrentItem());

		// viewPager.clearDisappearingChildren();
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
			Intent intent = new Intent(MainActivity.this, FilterActivity.class);
			startActivity(intent);
			return true;
		}
		;
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		finish();
		super.onBackPressed();
	}

}

class MyAdapter extends SmartFragmentStatePagerAdapter {

	public MyAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int i) {
		Fragment fragment = null;
		// Log.d("VIVZ", "get Item is called "+i);
		if (i == 0) {
			// Log.d("A", "A");
			fragment = new FragmentA();
		}
		if (i == 1) {
			// Log.d("B", "B");
			fragment = new FragmentB();
		}
		if (i == 2) {
			// Log.d("C", "C");
			fragment = new FragmentC();
		}
		if (i == 3) {
			// Log.d("D", "D");
			fragment = new FragmentD();
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
			return "All";
		}
		if (position == 1) {
			return "Filtered";
		}
		if (position == 2) {
			return "To Visit";
		}
		if (position == 3) {
			return "Visited";
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
