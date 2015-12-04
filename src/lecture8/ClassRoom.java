package lecture8;

import base.BaseObject;

public class ClassRoom extends BaseObject {
	public static void main(String args[]) throws InterruptedException{
		Professor cva = new Professor();
		// teachSequentially(cva);
		//teachConcurrently(cva);
		// System.out.println("DONE");
		Student[] students = createStudents();
		// makeStudentsListenSequentially(students);
		makeStudentsListenParallely(students);
		//System.out.println("DONE");
	}

	private static void makeStudentsListenParallely(Student[] students) throws InterruptedException{
		Thread[] threads = new Thread[students.length];
		int count =0;
		for (Student student : students) {
			threads[count++]= new Thread(student);
		}
		for(Thread t : threads){
			t.start();
		}
		for(Thread t: threads){
			t.join();
		}

		System.out.println("Done listening");
	}

	private static void makeStudentsListenSequentially(Student[] students) {
		for (Student student : students) {
			student.listenToLecture();
		}
	}

	private static Student[] createStudents() {
		Student[] students = new Student[3];
		students[0] = new Student("Jigang");
		students[1] = new Student("Yang");
		students[2] = new Student("Ying");
		return students;
	}

	private static void teachConcurrently(Professor cva) {
		TeachingThread tt = new TeachingThread(cva);
		SeeingThread st = new SeeingThread(cva);
		ThinkingThread tth = new ThinkingThread(cva);
		tt.start();
		st.start();
		tth.start();
		// sleep(2000);
		// System.out.println("Start again..");
		// new TeachingThread(cva).start();
		// tt.start();
		// st.start();
		// tth.start();

	}

	private static void teachSequentially(Professor cva) {
		cva.think();
		cva.teach();
		cva.seeStudents();
	}
}

class TeachingThread extends Thread {
	private Professor p;

	public TeachingThread(Professor p) {
		this.p = p;
	}

	@Override
	public void run() {
		synchronized(TalkingStick.get()){
			p.teach();
		}
	}

}

class SeeingThread extends Thread {
	private Professor p;

	public SeeingThread(Professor p) {
		this.p = p;
	}

	@Override
	public void run() {
		p.seeStudents();
	}

}

class ThinkingThread extends Thread {
	private Professor p;

	public ThinkingThread(Professor p) {
		this.p = p;
	}

	@Override
	public void run() {
		p.think();
	}

}
