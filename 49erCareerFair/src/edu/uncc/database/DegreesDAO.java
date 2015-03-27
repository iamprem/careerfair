package edu.uncc.database;

import java.util.ArrayList;
import java.util.List;

import edu.uncc.dataclasses.Degrees;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DegreesDAO {

	private SQLiteDatabase db;

	public DegreesDAO(SQLiteDatabase db) {
		super();
		this.db = db;
	}

	public long save(Degrees degree) {
		ContentValues values = new ContentValues();
		values.put(DegreesTable.COLUMN_ID, degree.getId());
		values.put(DegreesTable.COLUMN_NAME, degree.getName());
		long id = db.insert(DegreesTable.TABLENAME, null, values);

		return id;
	}

	public boolean update(Degrees degree) {
		ContentValues values = new ContentValues();
		values.put(DegreesTable.COLUMN_ID, degree.getId());
		values.put(DegreesTable.COLUMN_NAME, degree.getName());
		return db.update(DegreesTable.TABLENAME, values, DegreesTable.COLUMN_ID
				+ "=?", new String[] { degree.getId() + "" }) > 0;
	}

	public boolean delete(Degrees degree) {
		return db.delete(DegreesTable.TABLENAME, DegreesTable.COLUMN_ID + "=?",
				new String[] { degree.getId() + "" }) > 0;
	}

	@SuppressLint("NewApi")
	public Degrees get(int id) {
		
		Degrees degree = null;

		Cursor c = db.query(true, DegreesTable.TABLENAME, new String[] {
				DegreesTable.COLUMN_ID, DegreesTable.COLUMN_NAME }, DegreesTable.COLUMN_ID + "=?",
				new String[] { id + "" }, null, null, null, null, null);

		if (c != null && c.moveToFirst()) {

			degree = buildFromCursor(c);

			if (!c.isClosed()) {

				// c.close();
			}
		}
		return degree;
	}

	Degrees buildFromCursor(Cursor c) {
		Degrees degree = null;
		if (c != null) {
			degree = new Degrees();
			degree.setId(c.getInt(0));
			degree.setName(c.getString(1));
		}

		return degree;
	}

	public List<Degrees> getAll() {
		List<Degrees> degrees = new ArrayList<Degrees>();
		Cursor c1 = db.query(DegreesTable.TABLENAME, new String[] {
				DegreesTable.COLUMN_ID, DegreesTable.COLUMN_NAME }, null, null, null, null, null);
		if (c1 != null && c1.moveToFirst()) {
			do {
				Degrees degree = buildFromCursor(c1);
				if (degree != null) {
					degrees.add(degree);
				}
				if (!c1.isClosed()) {
					// c1.close();
				}

			} while (c1.moveToNext());
		}
		return degrees;
	}

}
