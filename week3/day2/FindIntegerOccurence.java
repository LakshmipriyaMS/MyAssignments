package week3.day2;

import java.util.HashMap;
import java.util.Map;

public class FindIntegerOccurence {

	public static void main(String[] args) {
		
		int nums[] = {1,2,1,3,2,1};
		
		Map<Integer, Integer> find = new HashMap<Integer,Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			
			/*if (find.containsKey(nums[i])) {
				find.put(nums[i], find.get(nums[i])+1);
			}
			
			else {
				find.put(nums[i], 1);
			}*/
			
			//below is a single line function in java 8
			find.put(nums[i], find.getOrDefault(nums[i], 0)+1);
		}

		System.out.println(find);
	}

}
