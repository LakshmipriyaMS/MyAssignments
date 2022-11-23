package week3.day1;

public class AxisBank extends BankInfo{
	
	public void deposit() {
		System.out.println("Deposit in child class using overriding");

	}

	public static void main(String[] args) {
		AxisBank bank = new AxisBank();
		bank.deposit();
		bank.saving();
		bank.fixed();
	
	}

}
