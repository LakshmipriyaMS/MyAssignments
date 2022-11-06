package week1.day1;

public class Mobile {
	
	String mobileBrandName = "RedMi Note 5 Pro";
	char mobileLogo = 'R';
	short noOfMobilePiece = 2;
	int modelNumber = 5;
	long mobileImeiNumber = 234665431L;
	float mobilePrice = 500000.08F;
	boolean isDamaged = false;

	public void makeCall() {
		// TODO Auto-generated method stub
		System.out.println("call mobile");
	}
	public void sendMsg() {
		// TODO Auto-generated method stub
       System.out.println("send a message");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Mobile callPhone = new Mobile();
       callPhone.makeCall();
       callPhone.sendMsg();
       System.out.println(callPhone.mobileBrandName);
       System.out.println(callPhone.mobileLogo);
       System.out.println(callPhone.noOfMobilePiece);
       System.out.println(callPhone.modelNumber);
       System.out.println(callPhone.mobileImeiNumber);
       System.out.println(callPhone.mobilePrice);
       System.out.println(callPhone.isDamaged);
	}

}
