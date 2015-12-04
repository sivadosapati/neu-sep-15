
class Pen{
	void write(){
		System.out.println("Writing..");
	}
}

class Dad{
	private String lastName;
	private String firstName;
	public final String getLastName(){
		return lastName;
	}
	public String getFirstName(){
		return firstName;
	}
}

class Son extends Dad{
	public String getFirstName(){
		return "Jr."+super.getFirstName();
	}
}
public class Student {
	
	private static Earth earth = new Earth();
	private static Marker marker = new Marker();
	//private static Professor p = new Professor();
	private Pen pen = new Pen();
	private int counter =0;
	public Student(){
		earth.addOneMorePerson();
	}
	public static int getTotalNumberOfPeopleOnEarth(){
		return earth.getNumberOfPeopleOnEarth();
	}
	public Pen getPen(){
		counter = counter + 1;
		if( counter > 2){
			System.out.println("I can't give you pen anymore ..");
			return null;
		}
		return pen;
	}
	
	boolean gender;

	public boolean isMale() {
		if(gender== true){
			return true;
			
		}
		else{
			return false;
		}
	}

	public boolean isFemale() {
		if(gender == false){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void writeHello(Book b, Pen p){
		System.out.println("Write Hello on Book with Pen");
	}
	
	public void writeHelloWithYourPen(Book b){
		System.out.println("Write hello with my pen in the book -> "+getPen());
	}
	
	public static void main(String args[]){
		Student s = new Student();
		//s.getPen().write();
		//s.getPen().write();
		//s.getPen().write();
		Book b = new Book();
		Pen p = new Pen();
		//Student.writeHello(b, p);
		//s.writeHello(b, p);
		
		Student ying = new Student();
		Student yang = new Student();
		Student abc = new Student();
		System.out.println(Student.getTotalNumberOfPeopleOnEarth());
		
	}

}
