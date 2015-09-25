import java.util.Scanner;

public class ClassRoom {
	public static void main(String args[]) {
		// boringExecution();
		scannerBasedExecution();
	}

	private static void scannerBasedExecution() {
		Scanner scanner = new Scanner(System.in);
		Teacher t = new Teacher();
		for(;;){
			System.out.println("Enter Student's Gender - true for Male - false for female - exit for break");
			String s = scanner.next();
			if( s.equals("true")){
				Student student = new Student();
				student.gender = true;
				t.count(student);
				continue;
			}
			if( s.equals("false")){
				Student student = new Student();
				student.gender = false;
				t.count(student);
				continue;
			}	
			if( s.equals("exit")){
				break;
			}
		}
		t.displayCount();
	}

	private static void boringExecution() {
		Teacher t = new Teacher();
		Student s1 = new Student();
		s1.gender = false;
		t.count(s1);
		Student s2 = new Student();
		s2.gender = false;
		t.count(s2);
		// t.displayCount();
		Student s3 = new Student();
		s3.gender = true;
		t.count(s3);
		t.displayCount();
	}
}
