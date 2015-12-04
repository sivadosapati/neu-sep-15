package lecture8;

import base.BaseObject;

public class Professor extends BaseObject{
	public void teach() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Teaching a word -> "+i);
			sleep(100);
		}
	}
	
	public void seeStudents(){
		for (int i = 0; i < 10; i++) {
			System.out.println("See a student -> "+i);
			sleep(500);
		}
		
	}
	
	public void think(){
		for (int i = 0; i < 10; i++) {
			System.out.println("Thinking a word -> "+i);
			sleep(200);
		}

	}
}
