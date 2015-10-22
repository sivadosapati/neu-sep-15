package lecture7;

import java.util.ArrayList;

import base.BaseObject;

public class ArrayListTest extends BaseObject {

	public static void main(String args[]) {
		JavaClassRoom jcr = new JavaClassRoom();
		createStudents(jcr);
		System.out.println(jcr.students.size());
		jcr.askStudentsToSitOnChair();
		System.out.println(jcr.students.size());
		jcr.askAFewStudentsToLeaveTheClass();
		System.out.println("After leaving the class -> " + jcr.students.size());

	}

	private static void createStudents(JavaClassRoom jcr) {
		while (true) {
			println("Please type a student name. Type quit to exit");
			String s = getStringFromConsole();
			if (s.equals("quit")) {
				break;
			}
			Student stu = new Student(s);
			jcr.students.add(stu);
			// jcr.students.add(s);
		}
	}

}

class JavaClassRoom {
	ArrayList<Student> students = new ArrayList<Student>();

	public void askStudentsToSitOnChair() {
		for (Object object : students) {
			Student student = (Student) object;
			student.sitOnChair();
		}
	}

	public void askAFewStudentsToLeaveTheClass() {
		ArrayList studentsToBeRemoved = new ArrayList();
		for (Object object : students) {
			Student st = (Student) object;
			int length = st.name.length();
			if (length > 6) {
				studentsToBeRemoved.add(st);
				//students.remove(st);
			}
		}
		students.removeAll(studentsToBeRemoved);
	}
}
