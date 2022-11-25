package week3.day2;

import java.util.Set;
import java.util.TreeSet;

public class MissingNumberUsingCollections {

	public static void main(String[] args) {
		
		int[] a = {1,10,2,3,5,6,8,9,1,2};
		Set<Integer> nums = new TreeSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			nums.add(a[i]);
		}
		System.out.println("Sorted array without duplicates: " + nums);
		System.out.println("Size of sorted array is " + nums.size());
		
		for (int j = 1; j < nums.size(); j++) {
			if (!nums.contains(j)) {
				System.out.println("Missing numbers: " + j);
			}
			
		}

	}

}
