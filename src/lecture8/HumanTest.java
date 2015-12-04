package lecture8;

public class HumanTest {

	public static void main(String[] args) {
		Human jian = new Human();
		jian.name = "Jian";
		Human chengzheng = new Human();
		chengzheng.name = "Chengzheng";
		HumanThread a1 = new HumanThread(jian, "see");
		HumanThread a2 = new HumanThread(jian, "speak");
		HumanThread a3 = new HumanThread(jian, "walk");
		HumanThread a4 = new HumanThread(jian, "eat");
		a1.start();
		a2.start();
		a3.start();
		a4.start();

		HumanThread a11 = new HumanThread(chengzheng, "see");
		HumanThread a21 = new HumanThread(chengzheng, "speak");
		HumanThread a31 = new HumanThread(chengzheng, "walk");
		HumanThread a41 = new HumanThread(chengzheng, "eat");

		a11.start();
		a21.start();
		a31.start();
		a41.start();

		
	}
}

class HumanThread extends Thread {
	private Human h;
	private String operation;

	HumanThread(Human h, String operation) {
		this.h = h;
		this.operation = operation;
	}

	public void run() {
		if (operation.equals("see")) {
			h.see();
			return;
		}
		if (operation.equals("speak")) {
			h.speak();
			return;
		}
		if (operation.equals("walk")) {
			h.walk();
			return;
		}
		h.eat();
	}
}
