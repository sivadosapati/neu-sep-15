package class4;

import java.util.Date;

public class Student {
	private String name;
	protected int age;
	Date birthday;
	public GPA gpa;

	public GPA getGpa() {
		return gpa;
	}

	public void setGpa(GPA gpa) {
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	void listen() {
		System.out.println(name + " is listening the class");
		System.out.println(name + " is asking the question in the class");
	}
}
