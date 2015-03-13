package edu.uncc.dataclasses;

import java.util.ArrayList;

public class Company {
	String name, overview, website;
	int company_id;
	ArrayList<Majors> majors;
	ArrayList<Positions> positions;
	ArrayList<Degrees> degrees;
	ArrayList<WorkAuths> workAuths;
	
	public Company(String name, String overview, String website,
			int company_id, ArrayList<Majors> majors,
			ArrayList<Positions> positions, ArrayList<Degrees> degrees,
			ArrayList<WorkAuths> workAuths) {
		super();
		this.name = name;
		this.overview = overview;
		this.website = website;
		this.company_id = company_id;
		this.majors = majors;
		this.positions = positions;
		this.degrees = degrees;
		this.workAuths = workAuths;
	}
	
	public Company(String name, String overview, String website,
			int company_id) {
		super();
		this.name = name;
		this.overview = overview;
		this.website = website;
		this.company_id = company_id;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public ArrayList<Majors> getMajors() {
		return majors;
	}

	public void setMajors(ArrayList<Majors> majors) {
		this.majors = majors;
	}

	public ArrayList<Positions> getPositions() {
		return positions;
	}

	public void setPositions(ArrayList<Positions> positions) {
		this.positions = positions;
	}

	public ArrayList<Degrees> getDegrees() {
		return degrees;
	}

	public void setDegrees(ArrayList<Degrees> degrees) {
		this.degrees = degrees;
	}

	public ArrayList<WorkAuths> getWorkAuths() {
		return workAuths;
	}

	public void setWorkAuths(ArrayList<WorkAuths> workAuths) {
		this.workAuths = workAuths;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", overview=" + overview
				+ ", website=" + website + ", company_id=" + company_id
				+ ", majors=" + majors + ", positions=" + positions
				+ ", degrees=" + degrees + ", workAuths=" + workAuths + "]";
	}
	
	
	


}
