package edu.uncc.database;

import java.util.ArrayList;
import java.util.List;

import edu.uncc.dataclasses.Majors;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class MajorsDAO {

	private SQLiteDatabase db;

	public MajorsDAO(SQLiteDatabase db) {
		super();
		this.db = db;
	}

	public long save(Majors major) {
		ContentValues values = new ContentValues();
		values.put(MajorsTable.COLUMN_NAME, major.getName());
		long id = db.insert(MajorsTable.TABLENAME, null, values);

		return id;
	}

	public boolean update(Majors major) {
		ContentValues values = new ContentValues();
		values.put(MajorsTable.COLUMN_NAME, major.getName());
		return db.update(MajorsTable.TABLENAME, values, MajorsTable.COLUMN_ID
				+ "=?", new String[] { major.getId() + "" }) > 0;
	}

	public boolean delete(Majors major) {
		return db.delete(MajorsTable.TABLENAME, MajorsTable.COLUMN_NAME + "=?",
				new String[] { major.getName() }) > 0;
	}
	
	public boolean delete() {
		return db.delete(MajorsTable.TABLENAME, null, null) > 0;
	}

	@SuppressLint("NewApi")
	public Majors get(int id) {
		
		Majors major = null;

		Cursor c = db.query(true, MajorsTable.TABLENAME, new String[] {
				MajorsTable.COLUMN_ID, MajorsTable.COLUMN_NAME }, MajorsTable.COLUMN_ID + "=?",
				new String[] { id + "" }, null, null, null, null, null);

		if (c != null && c.moveToFirst()) {

			major = buildFromCursor(c);

			if (!c.isClosed()) {

				// c.close();
			}
		}
		return major;
	}

	Majors buildFromCursor(Cursor c) {
		Majors major = null;
		if (c != null) {
			major = new Majors();
			major.setId(c.getInt(0));
			major.setName(c.getString(1));
		}

		return major;
	}

	public ArrayList<String> getAll() {
		ArrayList<String> majors = new ArrayList<String>();
		Cursor c1 = db.query(MajorsTable.TABLENAME, new String[] {
				MajorsTable.COLUMN_ID, MajorsTable.COLUMN_NAME }, null, null, null, null, null);
		if (c1 != null && c1.moveToFirst()) {
			do {
				Majors major = buildFromCursor(c1);
				if (major != null) {
					majors.add(major.getName());
				}
				if (!c1.isClosed()) {
					// c1.close();
				}

			} while (c1.moveToNext());
		}
		return majors;
	}

}
