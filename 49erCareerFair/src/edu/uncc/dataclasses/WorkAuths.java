package edu.uncc.dataclasses;

import java.io.Serializable;


public class WorkAuths implements Serializable{
	int id;
	String name;
	
	public WorkAuths(String name) {
		super();
		this.name = name;
	}

	public WorkAuths() {
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
		return "WorkAuths [id=" + id + ", name=" + name + "]";
	}
}
