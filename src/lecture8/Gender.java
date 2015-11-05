package lecture8;

public enum Gender {
	MALE(6,5), FEMALE(5,4);
	int subjectsToBePassed;
	int height;
	Gender(int subjectsToBePassed, int height){
		this.subjectsToBePassed = subjectsToBePassed;
		this.height = height;
	}
}

class Person {
	Gender gender;
	String name;
	int passedSubjects;
	int height;
	boolean isPass(){
		int subjectsToBePassed = gender.subjectsToBePassed;
		if( passedSubjects >= subjectsToBePassed){
			return true;
		}
		return false;
	}
	
	boolean canDoTheRide(){
		if( height > gender.height){
			return true;
		}
		return false;
	}
	boolean isPassTraditionalWay() {
		if (gender == Gender.MALE) {
			if (passedSubjects >= 6) {
				return true;
			}
		}
		if (gender == Gender.FEMALE) {
			if (passedSubjects >= 5) {
				return true;
			}

		}
		return false;
	}
}

class PersonTest {
	public static void main(String args[]) {
		Person p = new Person();
		p.gender = Gender.MALE;
	}
}
