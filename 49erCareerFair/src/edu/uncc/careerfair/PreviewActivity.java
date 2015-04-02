package edu.uncc.careerfair;

import edu.uncc.dataclasses.Company;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class PreviewActivity extends Activity {

	Company company;
	TextView companyName, boothId, overviewDesc, websiteDesc, majorsDesc,
			positionDesc, degreeDesc, workauthDesc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preview);
		companyName = (TextView) findViewById(R.id.textViewCompanyName);
		boothId = (TextView) findViewById(R.id.textViewBoothId);
		overviewDesc = (TextView) findViewById(R.id.textViewOverviewDesc);
		websiteDesc = (TextView) findViewById(R.id.textViewWebsiteDesc);
		majorsDesc = (TextView) findViewById(R.id.textViewMajorsDesc);
		positionDesc = (TextView) findViewById(R.id.textViewPositionsDesc);
		degreeDesc = (TextView) findViewById(R.id.textViewDegreeDesc);
		workauthDesc = (TextView) findViewById(R.id.textViewWorkAuthDesc);

		// How to get the booth id of the company in this scope? -- Prem

		try {
			company = (Company) getIntent().getSerializableExtra(
					CompanyAdapter.COMPANY_KEY);

			if (company != null) {
				companyName.setText(company.getName());
				overviewDesc.setText(company.getOverview());
				websiteDesc.setText(company.getWebsite());
				String majorsList = "";
				for (String i : company.getMajors()) {
					majorsList += i + "\n";
				}
				majorsDesc.setText(majorsList);
				String positionsList = "";
				for (String i : company.getPositions()) {
					positionsList += i + "\n";
				}
				positionDesc.setText(positionsList);
				String degreesList = "";
				for (String i : company.getDegrees()) {
					degreesList += i + "\n";
				}
				degreeDesc.setText(degreesList);
				String workauthsList = "";
				for (String i : company.getWorkAuths()) {
					workauthsList += i + "\n";
				}
				workauthDesc.setText(workauthsList);

				// Show map button on company details page to Map screen
				findViewById(R.id.btn_showmap).setOnClickListener(
						new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								Intent intent = new Intent(
										PreviewActivity.this,
										SwitchImageExampleActivity.class);
								startActivity(intent);
							}
						});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.preview, menu);
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
}
