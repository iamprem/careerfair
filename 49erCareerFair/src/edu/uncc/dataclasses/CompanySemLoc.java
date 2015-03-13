package edu.uncc.dataclasses;

public class CompanySemLoc {

	int companySecLoc_id;
	Company company;
	Locations location;
	Semesters semester;

	public CompanySemLoc(int companySecLoc_id, Company company,
			Locations location, Semesters semester) {
		super();
		this.companySecLoc_id = companySecLoc_id;
		this.company = company;
		this.location = location;
		this.semester = semester;
	}

	public int getCompanySecLoc_id() {
		return companySecLoc_id;
	}

	public void setCompanySecLoc_id(int companySecLoc_id) {
		this.companySecLoc_id = companySecLoc_id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Locations getLocation() {
		return location;
	}

	public void setLocation(Locations location) {
		this.location = location;
	}

	public Semesters getSemester() {
		return semester;
	}

	public void setSemester(Semesters semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "CompanySemLoc [companySecLoc_id=" + companySecLoc_id
				+ ", company=" + company + ", location=" + location
				+ ", semester=" + semester + "]";
	}
	
	

}
