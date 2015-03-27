package edu.uncc.dataclasses;

import java.io.Serializable;

public class Majors implements Serializable {
	int id;
	String name;

	public Majors(String name) {
		super();
		this.name = name;
	}

	public Majors() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Majors [id=" + id + ", name=" + name + "]";
	}

}
