package edu.uncc.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper{
	public DatabaseOpenHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		// TODO Auto-generated constructor stub
	}
	static final String DB_NAME ="mycompany.db";
	static final int DB_VERSION = 6;
	@Override
	
	public void onCreate(SQLiteDatabase db) {
		
		CompanyTable.onCreate(db);
		MajorsTable.onCreate(db);
		PositionsTable.onCreate(db);
		DegreesTable.onCreate(db);

		
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		CompanyTable.onUpgrade(db, oldVersion, newVersion);
		MajorsTable.onUpgrade(db, oldVersion, newVersion);
		PositionsTable.onUpgrade(db, oldVersion, newVersion);
		DegreesTable.onUpgrade(db, oldVersion, newVersion);
		
	}
	

}
