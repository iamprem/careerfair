package edu.uncc.dataclasses;

public class Semesters {

	String name;
	int year, sem_id;

	public Semesters(String name, int year, int sem_id) {
		super();
		this.name = name;
		this.year = year;
		this.sem_id = sem_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSem_id() {
		return sem_id;
	}

	public void setSem_id(int sem_id) {
		this.sem_id = sem_id;
	}

	@Override
	public String toString() {
		return "Semesters [name=" + name + ", year=" + year + ", sem_id="
				+ sem_id + "]";
	}

}
