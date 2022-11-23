package week2.day2;

public class FindTypes {

	public static void main(String[] args) {
		
		String test = "$$ Welcome to 2nd Class of Automation $$ ";
		int  letter = 0, space = 0, digit = 0, specialChar = 0;
		char c[] = test.toCharArray();
		int len = c.length;
		System.out.println("The total number of characters in the string is: " +len);
        for(int i=0;i<len;i++) {
        	if(Character.isLetter(c[i])) {
        		letter++;
        	}
        	else if (Character.isDigit(c[i])) {
				digit++;
			}
        	else if (Character.isSpaceChar(c[i])) {
        		space++;
			}
        	else {
				specialChar++;
			}
        	
        	
        }
        System.out.println("letter: " + letter);
		System.out.println("space: " + space);
		System.out.println("number: " + digit);
		System.out.println("specialCharcter: " + specialChar);
	}

}
