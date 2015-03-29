/* FullName: Rohit Pankaj Ruparel*/

package edu.uncc.careerfair;

import java.util.Comparator;

import edu.uncc.dataclasses.Company;

public class CustomFilterComparator implements Comparator<String> {
	int sortWay;

	public CustomFilterComparator(int i) {
		// TODO Auto-generated constructor stub
		sortWay = i;
	}

	public int compare(String o1, String o2) {
		if (sortWay == 1) {
			return o1.compareTo(o2);
		} else if (sortWay == 2) {
			return o2.compareTo(o1);
		}
		return 0;
	}
}