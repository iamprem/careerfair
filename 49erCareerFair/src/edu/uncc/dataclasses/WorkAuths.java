package edu.uncc.dataclasses;

public class WorkAuths {
	String name;
	int work_auth_id;

	public WorkAuths(String name, int work_auth_id) {
		super();
		this.name = name;
		this.work_auth_id = work_auth_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWork_auth_id() {
		return work_auth_id;
	}

	public void setWork_auth_id(int work_auth_id) {
		this.work_auth_id = work_auth_id;
	}

	@Override
	public String toString() {
		return "WorkAuths [name=" + name + ", work_auth_id=" + work_auth_id
				+ "]";
	}

}
