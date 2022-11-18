package javaChallenge;

public class CheckHappyNumber {

	public static void main(String[] args) {
		
		int num1=19;
		int s,r;
		while(num1>9) {
			s=0;
			while(num1>0) {
			r = num1%10; //9 , 0
			s = s + r*r; //81, 1
			num1 = num1/10; //1 ,0
		}
		num1=s;
		}
     if(num1==1){
    	 System.out.println("The given number is a happy number");
     }
     else {
    	 System.out.println("The given number is not a happy number");
     }
}
}
