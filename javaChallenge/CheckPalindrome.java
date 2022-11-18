package javaChallenge;

public class CheckPalindrome {

	public static void main(String[] args) {
		
		String str="A man, a plan, a canal: Panama";
		String str1=str.replaceAll("[\\s,:]","").toLowerCase();
		System.out.println("The given input string is " +str1);
		String rev="";
		int len1 = str1.length();
		for(int i=len1-1;i>=0;i--) {
			rev=rev+str1.charAt(i);
		}
   System.out.println("After reversing String is " +rev);
      if (str1.equals(rev)) {
		System.out.println("The string " +str1+ " is a palindrome");
	}
      else {
		System.out.println("The string " +str1+ " is not a palindrome");
	}
      
      String s2="race a car";
  	String str2=s2.replaceAll("[\\s,:]","").toLowerCase();
  	System.out.println("The given input string is " +str2);
  	String rev2="";
  	int len2 = str2.length();
  	for(int i=len2-1;i>=0;i--) {
  		rev2=rev2+str2.charAt(i);
  	}
  System.out.println("After reversing String is " +rev2);
    if (str2.equals(rev2)) {
  	System.out.println("The string " +str2+ " is a palindrome");
  }
    else {
  	System.out.println("The string " +str2+ " is not a palindrome");
  }
    
    
    String s3=" ";
  	String str3=s3.replaceAll("[\\s,:]","").toLowerCase();
  	System.out.println("The given input string is " +str3);
  	String rev3="";
  	int len3 = str3.length();
  	for(int i=len3-1;i>=0;i--) {
  		rev3=rev3+str3.charAt(i);
  	}
  System.out.println("After reversing String is " +rev3);
    if (str3.equals(rev3)) {
  	System.out.println("The string " +str3+ " is a palindrome");
  }
    else {
  	System.out.println("The string " +str3+ " is not a palindrome");
  }
	}
}
	
	
	


