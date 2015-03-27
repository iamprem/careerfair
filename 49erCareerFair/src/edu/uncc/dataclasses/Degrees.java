package edu.uncc.dataclasses;

import java.io.Serializable;

public class Degrees  implements Serializable{
	int id;
	String name;
	
	public Degrees(String name) {
		super();
		this.name = name;
	}

	public Degrees() {
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
		return "Degrees [id=" + id + ", name=" + name + "]";
	}
}
