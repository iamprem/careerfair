package edu.uncc.careerfair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
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
	public static int sortWay = 1;

	static DatabaseDataManager dm;
	public final int intentCode = 1001;

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

	public static HashSet<Company> majorsFilteredCompanies = new HashSet<Company>();
	public static HashSet<Company> positionsFilteredCompanies = new HashSet<Company>();
	public static HashSet<Company> degreesFilteredCompanies = new HashSet<Company>();
	public static HashSet<Company> workAuthsFilteredCompanies = new HashSet<Company>();

	ViewPager viewPager = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dm = new DatabaseDataManager(this);

		companiesAll.clear();
		companiesFiltered.clear();
		companiesToVisit.clear();
		companiesVisited.clear();

		majors.clear();
		positions.clear();
		degrees.clear();
		workAuths.clear();

		majorsSelected.clear();
		positionsSelected.clear();
		degreesSelected.clear();
		workAuthsSelected.clear();

		majorsFilteredCompanies.clear();
		positionsFilteredCompanies.clear();
		degreesFilteredCompanies.clear();
		workAuthsFilteredCompanies.clear();

		if (dm.getAllMajorsDao() != null) {
			majorsSelected.addAll(dm.getAllMajorsDao());
		}
		if (dm.getAllPositionsDao() != null) {
			positionsSelected.addAll(dm.getAllPositionsDao());
		}
		if (dm.getAllDegreesDao() != null) {
			degreesSelected.addAll(dm.getAllDegreesDao());
		}
		if (dm.getAllWorkAuthsDao() != null) {
			workAuthsSelected.addAll(dm.getAllWorkAuthsDao());
		}
		
		

		Parse.initialize(this, "qX6M1NbiyH7Xp0aiRRM3NN3RVOQKXRLgT2PnMBsM",
				"zcSGGkNiYow6iaOKWaLz88PqC42jRlQkVgHva1Cc");

		ParseQuery<ParseObject> query = ParseQuery.getQuery("Company");

		query.findInBackground(new FindCallback<ParseObject>() {

			@Override
			public void done(List<ParseObject> objects, ParseException e) {
				if (e == null) {

					for (ParseObject o : objects) {
						Company a = new Company(o);

						if (dm.getCompanyDao(a.getCompany_id()) != null) {
							Company com = dm.getCompanyDao(a.getCompany_id());
							a.setVisitStatus(com.getVisitStatus());

							if (a.getVisitStatus().equals("tovisit")) {
								companiesToVisit.add(a);
							} else if (a.getVisitStatus().equals("visited")) {
								companiesVisited.add(a);
							}
						} else {
							a.setVisitStatus("unchecked");
						}
						companiesAll.add(a);

						for (String s : majorsSelected) {
							if (a.getMajors().contains(s)) {
								majorsFilteredCompanies.add(a);
								break;
							}
						}

						for (String s : positionsSelected) {
							if (a.getPositions().contains(s)) {
								positionsFilteredCompanies.add(a);
								break;
							}
						}

						for (String s : degreesSelected) {
							if (a.getDegrees().contains(s)) {
								degreesFilteredCompanies.add(a);
								break;
							}
						}

						for (String s : workAuthsSelected) {
							if (a.getWorkAuths().contains(s)) {
								workAuthsFilteredCompanies.add(a);
								break;
							}
						}

					}
				}

				majors.addAll(Company.majorsAll);
				positions.addAll(Company.positionsAll);
				degrees.addAll(Company.degreesAll);
				workAuths.addAll(Company.workAuthsAll);
			
				Collections.sort(majors, new CustomFilterComparator(1));
				Collections.sort(positions, new CustomFilterComparator(1));
				Collections.sort(degrees, new CustomFilterComparator(1));
				Collections.sort(workAuths, new CustomFilterComparator(1));

				if (majorsSelected.size() != 0 || positionsSelected.size() != 0
						|| degreesSelected.size() != 0
						|| workAuthsSelected.size() != 0) {

					if (majorsSelected.size() == 0) {
						majorsFilteredCompanies.addAll(companiesAll);
					}
					if (positionsSelected.size() == 0) {
						positionsFilteredCompanies.addAll(companiesAll);
					}
					if (degreesSelected.size() == 0) {
						degreesFilteredCompanies.addAll(companiesAll);
					}
					if (workAuthsSelected.size() == 0) {
						workAuthsFilteredCompanies.addAll(companiesAll);
					}

					for (Company com : companiesAll) {
						if (majorsFilteredCompanies.contains(com)
								&& positionsFilteredCompanies.contains(com)
								&& degreesFilteredCompanies.contains(com)
								&& workAuthsFilteredCompanies.contains(com)) {

							companiesFiltered.add(com);

						}
					}
				}

				viewPager = (ViewPager) MainActivity.this
						.findViewById(R.id.pager);

				FragmentManager fragmentManager = getSupportFragmentManager();
				viewPager.setAdapter(new MyAdapter(fragmentManager));

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
		((CompanyAdapter) ((ListView) ((SmartFragmentStatePagerAdapter) viewPager
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

		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Intent intent = new Intent(MainActivity.this, FilterActivity.class);
			startActivityForResult(intent, intentCode);
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
		} else if (id == R.id.action_sort_status) {
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
		finish();
		super.onBackPressed();
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == intentCode) {
			if (resultCode == RESULT_OK) {
				finish();
				startActivity(getIntent());
			} else if (resultCode == RESULT_CANCELED) {
				finish();
				startActivity(getIntent());
			}
		}
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
			return "Visit";
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
