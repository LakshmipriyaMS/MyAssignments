package week3.day1;

public class SmartPhone extends AndroidPhone{
	
	public void connectWhatsapp() {
		System.out.println("Connect Whatsapp");

	}
	
	public void takeVideo() {
		System.out.println("Verification of video in smartphone- overriding concept");
	}

	public static void main(String[] args) {
		
		SmartPhone sp = new SmartPhone();
		sp.sendMsg();
		sp.makeCall();
		sp.saveContact();
		sp.takeVideo();
		sp.connectWhatsapp();

	}

}
