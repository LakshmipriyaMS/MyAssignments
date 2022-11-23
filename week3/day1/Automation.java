package week3.day1;

public class Automation extends MultipleLanguage {
	
	public void java() {
		System.out.println("Java Programming");
		
	}
	
	public void selenium() {
		System.out.println("Selenium using Java");
		
	}
	
	@Override
	public void ruby() {
		System.out.println("Ruby newly implemented method");
		
	}

	public static void main(String[] args) {
		
		Automation a = new Automation();
		a.java();
		a.selenium();
		a.python();
		a.ruby();
		

	}

}
