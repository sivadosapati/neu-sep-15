package lecture7;

public class ArrayTest {
	
	void walkOutOfClassRoomWithOutArrays(){
		ClassRoom cr = new ClassRoom();
		cr.student1.walkOut();
		cr.student2.walkOut();
		cr.student3.walkOut();
	}
	
	void walkOutOfClassRoomWithArrays(){
		classRoomWithArrays crwa = new classRoomWithArrays();
		for( Student st : crwa.students){
			st.walkOut();
		}
	}
	
	void openLaptop(){
		ClassRoom cr = new ClassRoom();
		cr.student1.openLaptop();
		cr.student2.openLaptop();
		cr.student3.openLaptop();
		cr.student17.openLaptop();
		
	}
	
}

class classRoomWithArrays{
	Student students[] = new Student[15];
	
}

class ClassRoom{
	Student student1;
	Student student2;
	Student student3;
	
	Student student17;
}

class Student{
	String name;
	public Student(String s) {
		this.name = s;
	}

	void walkOut(){
		
	}

	public void openLaptop() {
		// TODO Auto-generated method stub
		
	}

	public void sitOnChair() {
		System.out.println(name + " is sitting on the chair");
		
	}
}
