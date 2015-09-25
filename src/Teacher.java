
public class Teacher {
	int countOfStudents;
	int countOfMaleStudents;
	int countOfFemaleStudents;

	void count(Student student) {
		if (student.isMale()) {
			countOfMaleStudents = countOfMaleStudents + 1;
		}
		if (student.isFemale()) {
			countOfFemaleStudents = countOfFemaleStudents + 1;
		}
		countOfStudents = countOfStudents + 1;
	}

	void displayCount() {
		System.out.println("Male Students -> " + countOfMaleStudents);
		System.out.println("Female Students -> " + countOfFemaleStudents);
		System.out.println("Total Students -> " + countOfStudents);

	}
}
