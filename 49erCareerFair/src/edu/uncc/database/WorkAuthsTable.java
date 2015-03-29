package edu.uncc.database;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class WorkAuthsTable {
	
	static final String TABLENAME = "Workauths";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	
	public static void onCreate(SQLiteDatabase db)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE " + TABLENAME +" ( ");
		sb.append(COLUMN_ID+" integer primary key autoincrement, ");
		sb.append(COLUMN_NAME+" text not null ); ");
		try
		{
			db.execSQL(sb.toString());
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		db.execSQL("DROP TABLE IF EXISTS "+ TABLENAME);
		WorkAuthsTable.onCreate(db);
	}
	

}
