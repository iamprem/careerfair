package edu.uncc.database;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import edu.uncc.dataclasses.Company;
import edu.uncc.dataclasses.Degrees;
import edu.uncc.dataclasses.Majors;
import edu.uncc.dataclasses.Positions;
import edu.uncc.dataclasses.WorkAuths;

public class DatabaseDataManager {
	private Context mContex;
	private DatabaseOpenHelper dbDatabaseOpenHelper;
	private SQLiteDatabase db;
	private CompanyDAO companyDAO;
	private MajorsDAO majorsDAO;
	private PositionsDAO positionsDAO;
	private DegreesDAO degreesDAO;
	private WorkAuthsDAO workAuthsDAO;

	public DatabaseDataManager(Context mContext) {
		this.mContex = mContext;
		this.dbDatabaseOpenHelper = new DatabaseOpenHelper(this.mContex);
		db = dbDatabaseOpenHelper.getWritableDatabase();
		companyDAO = new CompanyDAO(db);
		majorsDAO = new MajorsDAO(db);
		positionsDAO = new PositionsDAO(db);
		degreesDAO = new DegreesDAO(db);
		workAuthsDAO = new WorkAuthsDAO(db);
	}

	public void close() {
		if (db != null) {
			db.close();
		}
	}

	public long saveCompanyDao(Company company) {
		return this.companyDAO.save(company);
	}

	public boolean updateCompanyDao(Company company) {
		return this.companyDAO.update(company);
	}

	public boolean deleteCompanyDao(Company company) {
		return this.companyDAO.delete(company);
	}

	public Company getCompanyDao(int id) {
		return this.companyDAO.get(id);
	}

	public List<Company> getAllCompanyDao() {
		return this.companyDAO.getAll();
	}
	
	
	// Majors

	public long saveMajorsDao(Majors major) {
		return this.majorsDAO.save(major);
	}

	public boolean updateMajorsDao(Majors major) {
		return this.majorsDAO.update(major);
	}

	public boolean deleteMajorsDao(Majors major) {
		return this.majorsDAO.delete(major);
	}
	
	public boolean deleteAllMajorsDao() {
		return this.majorsDAO.delete();
	}

	public Majors getMajorsDao(int id) {
		return this.majorsDAO.get(id);
	}

	public ArrayList<String> getAllMajorsDao() {
		return this.majorsDAO.getAll();
	}
	
	// Positions
	
	
	public long savePositionsDao(Positions position) {
		return this.positionsDAO.save(position);
	}

	public boolean updatePositionsDao(Positions position) {
		return this.positionsDAO.update(position);
	}

	public boolean deletePositionsDao(Positions position) {
		return this.positionsDAO.delete(position);
	}
	
	public boolean deleteAllPositionsDao() {
		return this.positionsDAO.delete();
	}

	public Positions getPositionsDao(int id) {
		return this.positionsDAO.get(id);
	}

	public ArrayList<String> getAllPositionsDao() {
		return this.positionsDAO.getAll();
	}
	
	
	// Degrees
	
	public long saveDegreesDao(Degrees degree) {
		return this.degreesDAO.save(degree);
	}

	public boolean updateDegreesDao(Degrees degree) {
		return this.degreesDAO.update(degree);
	}

	public boolean deleteDegreesDao(Degrees degree) {
		return this.degreesDAO.delete(degree);
	}
	
	public boolean deleteAllDegreesDao() {
		return this.degreesDAO.delete();
	}

	public Degrees getDegreesDao(int id) {
		return this.degreesDAO.get(id);
	}

	public ArrayList<String> getAllDegreesDao() {
		return this.degreesDAO.getAll();
	}
	
	// Work Auths
	
	public long saveWorkAuthsDao(WorkAuths workAuth) {
		return this.workAuthsDAO.save(workAuth);
	}

	public boolean updateWorkAuthsDao(WorkAuths workAuth) {
		return this.workAuthsDAO.update(workAuth);
	}

	public boolean deleteWorkAuthsDao(WorkAuths workAuth) {
		return this.workAuthsDAO.delete(workAuth);
	}
	
	public boolean deleteAllWorkAuthsDao() {
		return this.workAuthsDAO.delete();
	}

	public WorkAuths getWorkAuthsDao(int id) {
		return this.workAuthsDAO.get(id);
	}

	public ArrayList<String> getAllWorkAuthsDao() {
		return this.workAuthsDAO.getAll();
	}


}
