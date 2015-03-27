package edu.uncc.dataclasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONStringer;
import edu.uncc.careerfair.*;

import android.util.Log;

import com.parse.ParseObject;

import edu.uncc.careerfair.MainActivity;

public class Company implements Serializable{
	String name, overview, website, visitStatus;
	int company_id;
	ArrayList<String> majors;
	ArrayList<String> positions;
	ArrayList<String> degrees;
	ArrayList<String> workAuths;

	public static HashSet<String> majorsAll = new HashSet<String>();
	public static HashSet<String> positionsAll = new HashSet<String>();
	public static HashSet<String> degreesAll = new HashSet<String>();
	public static HashSet<String> workAuthsAll = new HashSet<String>();

	public Company(String name, String overview, String website,
			int company_id, int visitStatus, ArrayList<String> majors,
			ArrayList<String> positions, ArrayList<String> degrees,
			ArrayList<String> workAuths) {

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

	public Company(String name, String overview, String website, int company_id, String visitStatus) {
		super();
		this.name = name;
		this.overview = overview;
		this.website = website;
		this.company_id = company_id;
	}
	
	public Company(){
		
	}
	
	public Company(int company_id, String name, String visitStatus){
		this.company_id = company_id;
		this.name = name;
		this.visitStatus = visitStatus;
	}

	public Company(ParseObject o) {
		this.name = o.getString("name");
		this.overview = o.getString("overview");
		this.website = o.getString("website");
		this.company_id = o.getInt("company_id");
		this.majors = tokenizeMajors(o.getJSONArray("majors"));
		this.positions = tokenizePositions(o.getJSONArray("positions"));
		this.degrees = tokenizeDegrees(o.getJSONArray("degrees"));
		this.workAuths = tokenizeWorkAuths(o.getJSONArray("workAuths"));
//		if(MainActivity.companiesAll.contains(object));
		this.visitStatus = "";
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
	
	public String getVisitStatus() {
		return visitStatus;
	}

	public void setVisitStatus(String visitStatus) {
		this.visitStatus = visitStatus;
	}

	public ArrayList<String> getMajors() {
		return majors;
	}

	public void setMajors(ArrayList<String> majors) {
		this.majors = majors;
	}

	public ArrayList<String> getPositions() {
		return positions;
	}

	public void setPositions(ArrayList<String> positions) {
		this.positions = positions;
	}

	public ArrayList<String> getDegrees() {
		return degrees;
	}

	public void setDegrees(ArrayList<String> degrees) {
		this.degrees = degrees;
	}

	public ArrayList<String> getWorkAuths() {
		return workAuths;
	}

	public void setWorkAuths(ArrayList<String> workAuths) {
		this.workAuths = workAuths;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", overview=" + overview
				+ ", website=" + website + ", company_id=" + company_id
				+ ", visitStatus=" + visitStatus
				+ ", majors=" + majors + ", positions=" + positions
				+ ", degrees=" + degrees + ", workAuths=" + workAuths + "]";
	}

	public ArrayList<String> tokenizeMajors(JSONArray tempList) {
		ArrayList<String> arrayList = new ArrayList<String>();
		// ArrayList<String> elephantList = Arrays.asList(tempList.split(","));
		for (int i = 0; i < tempList.length(); i++) {
			try {
				arrayList.add((String) tempList.get(i));
				majorsAll.add((String) tempList.get(i));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return arrayList;
	}

	public ArrayList<String> tokenizePositions(JSONArray tempList) {
		ArrayList<String> arrayList = new ArrayList<String>();
		// ArrayList<String> elephantList = Arrays.asList(tempList.split(","));
		for (int i = 0; i < tempList.length(); i++) {
			try {
				arrayList.add((String) tempList.get(i));
				// positionsAll.add((String) tempList.get(i));
				positionsAll.add((String) tempList.get(i));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return arrayList;
	}

	public ArrayList<String> tokenizeDegrees(JSONArray tempList) {
		ArrayList<String> arrayList = new ArrayList<String>();
		// ArrayList<String> elephantList = Arrays.asList(tempList.split(","));
		for (int i = 0; i < tempList.length(); i++) {
			try {
				arrayList.add((String) tempList.get(i));
				// degreesAll.add((String) tempList.get(i));
				degreesAll.add((String) tempList.get(i));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return arrayList;
	}

	public ArrayList<String> tokenizeWorkAuths(JSONArray tempList) {
		ArrayList<String> arrayList = new ArrayList<String>();
		// ArrayList<String> elephantList = Arrays.asList(tempList.split(","));
		for (int i = 0; i < tempList.length(); i++) {
			try {
				arrayList.add((String) tempList.get(i));
				// workAuthsAll.add((String) tempList.get(i));
				workAuthsAll.add((String) tempList.get(i));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return arrayList;
	}

}
