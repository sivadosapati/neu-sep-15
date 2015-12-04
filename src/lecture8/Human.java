package lecture8;

import base.BaseObject;

public class Human extends BaseObject {
	
	private static Object SPEAKING_LOCK =  new Object();
	public static Object getSpeakingLock(){
		return SPEAKING_LOCK;
	}
	String name;

	private void loop(String message) {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + " is " + message + " -> " + i);
			sleep(5);
		}

	}

	public void speak() {
		synchronized (getSpeakingLock()) {
			loop("Speaking");
		}
	}

	public synchronized void eat() {
		loop("Eating");
	}

	public void walk() {
		loop("Walking");
	}

	public void see() {
		loop("Seeing");
	}
}
