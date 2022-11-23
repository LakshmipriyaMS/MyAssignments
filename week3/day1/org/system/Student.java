package org.system;
//multilevel inheritance
public class Student extends Department {
	
	public void studentName() {
		System.out.println("Priya");

	}
	
	public void studentDept() {
		System.out.println("ECE");

	}
	
	private void studentID() {
		System.out.println("15EC059");

	}

	public static void main(String[] args) {
		Student s = new Student();
		s.collegeName();
		s.collegeCode();
		s.collegeRank();
		s.deptName();
		s.studentName();
		s.studentDept();
		s.studentID();

	}

}
