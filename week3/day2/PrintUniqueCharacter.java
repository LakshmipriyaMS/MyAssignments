package week3.day2;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueCharacter {

	public static void main(String[] args) {
		
		String s = "babu";
		char[] s1= s.toCharArray();
		Set<Character> unique = new HashSet<Character>();
		for (int i = 0; i < s1.length; i++) {
			boolean add = unique.add(s1[i]);
			if (!add) {
				if (unique.contains(s1[i])) {
					unique.remove(s1[i]);
				}
				
				else {
					unique.add(s1[i]);
				}
			}
		}
		System.out.println(unique);

	}

}
