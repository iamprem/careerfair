package edu.uncc.database;

import java.util.ArrayList;
import java.util.List;

import edu.uncc.dataclasses.Company;
import edu.uncc.dataclasses.Positions;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class PositionsDAO {

	private SQLiteDatabase db;

	public PositionsDAO(SQLiteDatabase db) {
		super();
		this.db = db;
	}

	public long save(Positions position) {
		ContentValues values = new ContentValues();
		values.put(PositionsTable.COLUMN_ID, position.getId());
		values.put(PositionsTable.COLUMN_NAME, position.getName());
		long id = db.insert(PositionsTable.TABLENAME, null, values);

		return id;
	}

	public boolean update(Positions position) {
		ContentValues values = new ContentValues();
		values.put(PositionsTable.COLUMN_ID, position.getId());
		values.put(PositionsTable.COLUMN_NAME, position.getName());
		return db.update(PositionsTable.TABLENAME, values, PositionsTable.COLUMN_ID
				+ "=?", new String[] { position.getId() + "" }) > 0;
	}

	public boolean delete(Positions position) {
		return db.delete(PositionsTable.TABLENAME, PositionsTable.COLUMN_ID + "=?",
				new String[] { position.getId() + "" }) > 0;
	}

	@SuppressLint("NewApi")
	public Positions get(int id) {

		Positions position = null;

		Cursor c = db.query(true, PositionsTable.TABLENAME, new String[] {
				PositionsTable.COLUMN_ID, PositionsTable.COLUMN_NAME },
				PositionsTable.COLUMN_ID + "=?", new String[] { id + "" }, null,
				null, null, null, null);

		if (c != null && c.moveToFirst()) {

			position = buildFromCursor(c);

			if (!c.isClosed()) {

				// c.close();
			}
		}
		return position;
	}

	Positions buildFromCursor(Cursor c) {
		Positions position = null;
		if (c != null) {
			position = new Positions();
			position.setId(c.getInt(0));
			position.setName(c.getString(1));
		}

		return position;
	}

	public List<Positions> getAll() {
		List<Positions> positions = new ArrayList<Positions>();
		Cursor c1 = db.query(PositionsTable.TABLENAME, new String[] {
				PositionsTable.COLUMN_ID, PositionsTable.COLUMN_NAME }, null, null,
				null, null, null);
		if (c1 != null && c1.moveToFirst()) {
			do {
				Positions position = buildFromCursor(c1);
				if (position != null) {
					positions.add(position);
				}
				if (!c1.isClosed()) {
					// c1.close();
				}

			} while (c1.moveToNext());
		}
		return positions;
	}

}
