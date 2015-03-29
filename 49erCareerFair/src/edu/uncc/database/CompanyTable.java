package edu.uncc.database;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CompanyTable {
	
	static final String TABLENAME = "Company";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_VISIT_STATUS = "status";
	
	public static void onCreate(SQLiteDatabase db)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE " + TABLENAME +"(");
		sb.append(COLUMN_ID+" integer primary key, ");
		sb.append(COLUMN_NAME + " text not null, ");
		sb.append(COLUMN_VISIT_STATUS + " text not null); ");
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
		CompanyTable.onCreate(db);
	}
	

}
