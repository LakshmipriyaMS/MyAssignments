package week3.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargest {

	public static void main(String[] args) {
		
		int[] data = {3,2,11,4,6,7,2,3,3,6,7};
		//a) Create a empty Set Using TreeSet
		Set<Integer> SortedArray = new TreeSet<Integer>();
		//b) Declare for loop iterator from 0 to data.length and add into Set 
		for (int i = 0; i < data.length; i++) {
			SortedArray.add(data[i]);
		}
        
		int size = SortedArray.size();
		
		//c) converted Set into List
		
		List<Integer> elem = new ArrayList<Integer>(size);
		for (Integer i : SortedArray) {
			elem.add(i);
		}
		System.out.println(elem);
		//second largest element
		System.out.println("Second largest element in array is " + elem.get(size-2));
	}
        
}
