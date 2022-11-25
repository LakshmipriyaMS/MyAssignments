package week3.day2;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesUsingSet {

	public static void main(String[] args) {
		
		String companyname = "google";
		char a[] = companyname.toCharArray();
		Set<Character> uniquechar = new HashSet<Character>();
		for (int i = 0; i < a.length; i++) {
			uniquechar.add(a[i]);
		}
		
		System.out.println(uniquechar);

	}

}
