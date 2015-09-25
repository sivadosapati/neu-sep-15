
class Pen{
	void write(){
		System.out.println("Writing..");
	}
}
public class Student {
	private Pen pen = new Pen();
	private int counter =0;
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
	
	public static void main(String args[]){
		Student s = new Student();
		s.getPen().write();
		s.getPen().write();
		s.getPen().write();
	}

}
