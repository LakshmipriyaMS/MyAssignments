package week1.day1;

public class ArmstrongNumber {

	public static void main(String[] args) {
		int num =153 ; 
		int remainder , quotient, original ,calculated = 0;
		original = num;
		while (original>0) {
			remainder = original%10;
			quotient = original/10;
			calculated = calculated + (remainder*remainder*remainder);
			original = quotient;
			}
		if (calculated==num) {
			System.out.println(num  + " is an Armstrong number");
		}
		else {
			System.out.println(num + " is not an Armstrong number");
		}
	}

}
