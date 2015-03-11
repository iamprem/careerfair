package edu.uncc.dataclasses;

public class Locations {
	String name;
	int location_id, booth_no;

	public Locations(String name, int location_id, int booth_no) {
		super();
		this.name = name;
		this.location_id = location_id;
		this.booth_no = booth_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public int getBooth_no() {
		return booth_no;
	}

	public void setBooth_no(int booth_no) {
		this.booth_no = booth_no;
	}

	@Override
	public String toString() {
		return "Locations [name=" + name + ", location_id=" + location_id
				+ ", booth_no=" + booth_no + "]";
	}

}
