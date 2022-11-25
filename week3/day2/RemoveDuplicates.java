package week3.day2;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
//		Declare a String as PayPal India		
		String str = "PayPal India";
		
//		Convert it into a character array
		char[] charArray = str.toCharArray();
//		Declare a Set as charSet for Character
		
		Set<Character> charSet = new HashSet<Character>();
	
//		Declare a Set as dupCharSet for duplicate Character
		
		Set<Character> dupCharSet = new HashSet<Character>();
		
//		Iterate character array and add it into charSet
//		if the character is already in the charSet then, add it to the dupCharSet
		
		for (Character a : charArray) {
			if (!charSet.add(a)) {
				dupCharSet.add(a);
			}
			else {
				charSet.add(a);
			}
		
		}
        System.out.println(charSet);
        System.out.println(dupCharSet);


//		Check the dupCharSet elements and remove those in the charSet
        
        for (Character b : dupCharSet) {
       	 charSet.remove(b);
        }

        System.out.println("After removing duplicate characters "+charSet);

//		Iterate using charSet
        for (Character c : charSet) {
//    	Check the iterator variable isn't equals to an empty space
        if (c.equals(' ')) {
			charSet.remove(c);
			break;
		}	
		}

//		print it
        System.out.println(charSet);
	}

}
