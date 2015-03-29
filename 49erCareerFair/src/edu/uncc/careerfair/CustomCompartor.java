/* FullName: Rohit Pankaj Ruparel*/

package edu.uncc.careerfair;

import java.util.Comparator;

import edu.uncc.dataclasses.Company;

public class CustomCompartor implements Comparator<Company> {
	int sortWay;

	public CustomCompartor(int i) {
		// TODO Auto-generated constructor stub
		sortWay = i;
	}

	@Override
	public int compare(Company o1, Company o2) {
		if (sortWay == 1) {
			return o1.getName().compareTo(o2.getName());
		} else if (sortWay == 2) {
			return o2.getName().compareTo(o1.getName());
		} else if (sortWay == 3) {
			return o1.getVisitStatus().compareTo(o2.getVisitStatus());
		}
		return 0;
	}
}