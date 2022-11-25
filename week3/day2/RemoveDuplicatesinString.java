package week3.day2;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesinString {

	public static void main(String[] args) {
		
		String text = "We learn java basics as part of java sessions in java week1";
		String text1 = text.replaceAll(" ", "");
		System.out.println(text1);
		//int count;
		char[] charArray = text1.toCharArray();
		Set<Character> uniquechar = new HashSet<Character>();
		for (int i = 0; i < charArray.length; i++) {
			uniquechar.add(charArray[i]);
		}
		
		System.out.println(uniquechar);

		

	}

}
