package week2.day2;

public class Palindrome {

	public static void main(String[] args) {
		
		String str="madam";
		//String str1=str.replaceAll("[\\s,:]","").toLowerCase();
		System.out.println("The given input string is " +str);
		String rev="";
		int len1 = str.length();
		for(int i=len1-1;i>=0;i--) {
			rev=rev+str.charAt(i);
		}
   System.out.println("After reversing String is " +rev);
      if (str.equals(rev)) {
		System.out.println("The string " +str+ " is a palindrome");
	}
      else {
		System.out.println("The string " +str+ " is not a palindrome");
	}

	}

}
