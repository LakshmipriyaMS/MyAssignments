package week3.day1;
//Overloading
public class Students {
	
	public void getStudentInfo() {
		System.out.println("Student Information");

	}
	
	public void getStudentInfo(int id) {
		System.out.println(id);
	}
	
	public void getStudentInfo(int id,String name) {
		System.out.println(id + name);
	}
	
	public void getStudentInfo(String email,int phoneNumber) {
		System.out.println(email + phoneNumber);
	}

	public static void main(String[] args) {
		Students details = new Students();
		details.getStudentInfo();
		details.getStudentInfo(29);
		details.getStudentInfo(29, "Priya");
		details.getStudentInfo("priya@gmail.com", 90234);
	
	}

}
