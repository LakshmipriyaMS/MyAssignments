package week3.day2;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesWords {

	public static void main(String[] args) {
		
		String text = "We learn java basics as part of java sessions in java week1";
		System.out.println("Original string is: " + text);
		//to split string based on single or double space
		String[] split = text.split("\\s+");
		//to print string array
		System.out.println(Arrays.toString(split));
		//convert String array to LinkedHashSet to remove duplicates
		LinkedHashSet<String> Uniquewords = new LinkedHashSet<String>(Arrays.asList(split));
		StringBuilder sb = new StringBuilder();
		int index = 0;
		//to join words again by space
		for (String s : Uniquewords) {
			if (index>0) {
				sb.append(" ");
			}
			sb.append(s);
			index++;
		}
		
		String str = sb.toString();
		System.out.println("String after removing duplicate words:");
        System.out.println(str);
	}

}
