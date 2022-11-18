package javaChallenge;

public class ReturnLengthOfLastWord {

	public static void main(String[] args) {
		
		String str1 = "Hello World";
		String str2 = " fly me  to  the moon";
		String str3 = "luffy is still joyboy";
		String[] strArray1 = str1.split("\\s");
        int length1 = strArray1[strArray1.length-1].length();
        System.out.println("Length of Last word in first string is " +length1);
        String[] strArray2 = str2.split("\\s");
        int length2 = strArray2[strArray2.length-1].length();
        System.out.println("Length of Last word in second string is " +length2);
        String[] strArray3 = str3.split("\\s");
        int length3 = strArray3[strArray3.length-1].length();
        System.out.println("Length of Last word in third string is " +length3);
	}

}
