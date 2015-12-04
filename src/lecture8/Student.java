package lecture8;

import base.BaseObject;

public class Student extends BaseObject implements Runnable {

	private String name;

	public void askQuestion() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Ask a Question -> " + i);
			sleep(2);
		}
	}

	public Student(String name) {
		this.name = name;
	}
	
	public void talk(){
		for (int i = 0; i < 10; i++) {
			System.out.println(name + " is talking a word -> " + i);
			sleep(2);
		}
		
	}

	public void listenToLecture() {
		for (int i = 0; i < 10; i++) {
			System.out.println(name + " is listening to word -> " + i);
			sleep(2);
		}
	}

	@Override
	public void run() {
		listenToLecture();
	}
}
