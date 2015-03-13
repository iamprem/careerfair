package edu.uncc.dataclasses;

public class Majors {

	String name;
	int major_id;

	public Majors(String name, int major_id) {
		super();
		this.name = name;
		this.major_id = major_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMajor_id() {
		return major_id;
	}

	public void setMajor_id(int major_id) {
		this.major_id = major_id;
	}

	@Override
	public String toString() {
		return "Majors [name=" + name + ", major_id=" + major_id + "]";
	}
}
