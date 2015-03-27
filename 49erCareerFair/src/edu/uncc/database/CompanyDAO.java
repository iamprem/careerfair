package edu.uncc.database;

import java.util.ArrayList;
import java.util.List;

import edu.uncc.dataclasses.Company;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class CompanyDAO {

	private SQLiteDatabase db;

	public CompanyDAO(SQLiteDatabase db) {
		super();
		this.db = db;
	}

	public long save(Company company) {
		ContentValues values = new ContentValues();
		values.put(CompanyTable.COLUMN_ID, company.getCompany_id());
		values.put(CompanyTable.COLUMN_NAME, company.getName());
		values.put(CompanyTable.COLUMN_VISIT_STATUS, company.getVisitStatus());
		long id = db.insert(CompanyTable.TABLENAME, null, values);

		return id;
	}

	public boolean update(Company company) {
		ContentValues values = new ContentValues();
		values.put(CompanyTable.COLUMN_ID, company.getCompany_id());
		values.put(CompanyTable.COLUMN_NAME, company.getName());
		values.put(CompanyTable.COLUMN_VISIT_STATUS, company.getVisitStatus());

		return db.update(CompanyTable.TABLENAME, values, CompanyTable.COLUMN_ID
				+ "=?", new String[] { company.getCompany_id() + "" }) > 0;
	}

	public boolean delete(Company company) {
		return db.delete(CompanyTable.TABLENAME, CompanyTable.COLUMN_ID + "=?",
				new String[] { company.getCompany_id() + "" }) > 0;
	}

	@SuppressLint("NewApi")
	public Company get(int id) {
		
		Company company = null;

		Cursor c = db.query(true, CompanyTable.TABLENAME, new String[] {
				CompanyTable.COLUMN_ID, CompanyTable.COLUMN_NAME,
				CompanyTable.COLUMN_VISIT_STATUS }, CompanyTable.COLUMN_ID + "=?",
				new String[] { id + "" }, null, null, null, null, null);

		if (c != null && c.moveToFirst()) {

			company = buildFromCursor(c);

			if (!c.isClosed()) {

				// c.close();
			}
		}
		return company;
	}

	Company buildFromCursor(Cursor c) {
		Company company = null;
		if (c != null) {
			company = new Company();
			company.setCompany_id(c.getInt(0));
			company.setName(c.getString(1));
			company.setVisitStatus(c.getString(2));
		}

		return company;
	}

	public List<Company> getAll() {
		List<Company> companies = new ArrayList<Company>();
		Cursor c1 = db.query(CompanyTable.TABLENAME, new String[] {
				CompanyTable.COLUMN_ID, CompanyTable.COLUMN_NAME,
				CompanyTable.COLUMN_VISIT_STATUS }, null, null, null, null, null);
		if (c1 != null && c1.moveToFirst()) {
			do {
				Company company = buildFromCursor(c1);
				if (company != null) {
					companies.add(company);
				}
				if (!c1.isClosed()) {
					// c1.close();
				}

			} while (c1.moveToNext());
		}
		return companies;
	}

}
