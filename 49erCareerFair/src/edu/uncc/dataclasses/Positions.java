package edu.uncc.dataclasses;

public class Positions {
	String name;
	int position_id;

	public Positions(String name, int position_id) {
		super();
		this.name = name;
		this.position_id = position_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition_id() {
		return position_id;
	}

	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}

	@Override
	public String toString() {
		return "Positions [name=" + name + ", position_id=" + position_id + "]";
	}

}
