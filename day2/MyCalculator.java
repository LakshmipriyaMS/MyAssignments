package week1.day2;

public class MyCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Calculator myCalc = new Calculator();
        int add = myCalc.add(10, 20, 30);
        int sub = myCalc.sub(60, 50, 30);
        double mul = myCalc.mul(40.5, 30.6);
        float div = myCalc.div(45.6f, 30.6f);
        System.out.println(add);
        System.out.println(sub);
        System.out.println(mul);
        System.out.println(div);

        
	}

}
