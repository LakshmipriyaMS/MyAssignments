package week1.day2;

import org.apache.poi.hssf.record.MulBlankRecord;

public class Calculator {
	
	public int add(int num1,int num2,int num3) {
		// TODO Auto-generated method stub
      int sum = num1+num2+num3;
      return sum;
	}
	
	public int sub(int num1,int num2,int num3) {
		int sub = num1-num2-num3;
		return sub;
	}
	
	public double mul(double num1,double num2) {
		double mul = num1*num2;
		return mul;
	}
	
	public float div(float num1,float num2) {
		float div = num1/num2;
		return div;
	}
	

}
