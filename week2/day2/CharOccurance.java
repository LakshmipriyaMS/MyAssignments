package week2.day2;

public class CharOccurance {

	public static void main(String[] args) {
		
		String str = "welcome to chennai";
		int totallength = str.length();
		int tot_len_after_replace = str.replace("e", "").length();
		int count = totallength - tot_len_after_replace;
		System.out.println("The number of occurecences of character e is: "+count );

	}

}
