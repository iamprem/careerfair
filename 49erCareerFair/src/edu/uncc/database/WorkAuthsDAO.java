package edu.uncc.database;

import java.util.ArrayList;
import java.util.List;

import edu.uncc.dataclasses.WorkAuths;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class WorkAuthsDAO {

	private SQLiteDatabase db;

	public WorkAuthsDAO(SQLiteDatabase db) {
		super();
		this.db = db;
	}

	public long save(WorkAuths workAuth) {
		ContentValues values = new ContentValues();
		values.put(WorkAuthsTable.COLUMN_ID, workAuth.getId());
		values.put(WorkAuthsTable.COLUMN_NAME, workAuth.getName());
		long id = db.insert(WorkAuthsTable.TABLENAME, null, values);

		return id;
	}

	public boolean update(WorkAuths workAuth) {
		ContentValues values = new ContentValues();
		values.put(WorkAuthsTable.COLUMN_ID, workAuth.getId());
		values.put(WorkAuthsTable.COLUMN_NAME, workAuth.getName());
		return db.update(WorkAuthsTable.TABLENAME, values, WorkAuthsTable.COLUMN_ID
				+ "=?", new String[] { workAuth.getId() + "" }) > 0;
	}

	public boolean delete(WorkAuths workAuth) {
		return db.delete(WorkAuthsTable.TABLENAME, WorkAuthsTable.COLUMN_ID + "=?",
				new String[] { workAuth.getId() + "" }) > 0;
	}

	@SuppressLint("NewApi")
	public WorkAuths get(int id) {
		
		WorkAuths workAuth = null;

		Cursor c = db.query(true, WorkAuthsTable.TABLENAME, new String[] {
				WorkAuthsTable.COLUMN_ID, WorkAuthsTable.COLUMN_NAME }, WorkAuthsTable.COLUMN_ID + "=?",
				new String[] { id + "" }, null, null, null, null, null);

		if (c != null && c.moveToFirst()) {

			workAuth = buildFromCursor(c);

			if (!c.isClosed()) {

				// c.close();
			}
		}
		return workAuth;
	}

	WorkAuths buildFromCursor(Cursor c) {
		WorkAuths workAuth = null;
		if (c != null) {
			workAuth = new WorkAuths();
			workAuth.setId(c.getInt(0));
			workAuth.setName(c.getString(1));
		}

		return workAuth;
	}

	public List<WorkAuths> getAll() {
		List<WorkAuths> workAuths = new ArrayList<WorkAuths>();
		Cursor c1 = db.query(WorkAuthsTable.TABLENAME, new String[] {
				WorkAuthsTable.COLUMN_ID, WorkAuthsTable.COLUMN_NAME }, null, null, null, null, null);
		if (c1 != null && c1.moveToFirst()) {
			do {
				WorkAuths workAuth = buildFromCursor(c1);
				if (workAuth != null) {
					workAuths.add(workAuth);
				}
				if (!c1.isClosed()) {
					// c1.close();
				}

			} while (c1.moveToNext());
		}
		return workAuths;
	}

}
