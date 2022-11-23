package week3.day1;
//Overloading concept
public class Calculator {
	
	public void add(int num1 , int num2) {
		int sum = num1+num2;
		System.out.println(sum);
	}
	
	public void add(int num1 , int num2, int num3) {
		int sum = num1+num2+num3;
		System.out.println(sum);
	}
	
	public void sub(double num1 , double num2) {
		double sub = num1-num2;
		System.out.println(sub);
	}
	
	public void sub(int num1 , int num2) {
		double sub = num1-num2;
		System.out.println(sub);
	}
	
	public void mul(int num1 , double num2) {
		double mul = num1*num2;
		System.out.println(mul);
	}
	
	public void mul(double num1 , double num2) {
		double mul = num1*num2;
		System.out.println(mul);
	}

	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		cal.add(30, 40);
		cal.add(50, 40, 30);
		cal.sub(65.5, 0.5);
		cal.sub(20, 30);
		cal.mul(1.5, 1.5);
		cal.mul(20, 10);
		
	}

}
