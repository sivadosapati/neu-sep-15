package lecture8;

public class SynchronizedClassRoomTest {
	public static void main(String args[]) {
		Professor cva = new Professor();
		Student yang = new Student("Yang");
		Student ying = new Student("Ying");
		Thread teachingThread = new TeachingThread(cva);
		Thread yangListenThread = new Thread(yang);
		Thread yingListenThread = new Thread(ying);
		Thread yangQuestionThread = new QuestionThread(yang);
		Thread yingTalkingThread = new StudentTalkingThread(ying);
		Thread yangTalkingThread = new StudentTalkingThread(yang);
		teachingThread.start();
		yangListenThread.start();
		yingListenThread.start();
		yangQuestionThread.start();
		yingTalkingThread.start();
		yangTalkingThread.start();
	}
}

class TalkingStick {
	private static TalkingStick stick = new TalkingStick();
	private static TalkingStick student = new TalkingStick();

	public static TalkingStick get() {
		return stick;
	}

	public static TalkingStick getStudentTalkingStick() {
		return student;
	}
}

class QuestionThread extends Thread {
	private Student st;

	public QuestionThread(Student st) {
		this.st = st;
	}

	public void run() {
		synchronized (TalkingStick.get()) {
			st.askQuestion();
		}
	}
}

class StudentTalkingThread extends Thread {
	private Student st;

	public StudentTalkingThread(Student st) {
		this.st = st;
	}

	public void run() {
		synchronized (TalkingStick.getStudentTalkingStick()) {
			st.talk();
		}
	}
}