package lecture6;

import base.BaseObject;

public class PassByTest extends BaseObject {
	public static void main(String args[]) {
		Box box = new Box();
		println(box.color);
		changeColor(box, "yellow");
		println(box.color);
		
		String color = "blue";
		println(color);
		changeColor(color);
		println(color);
	}

	private static void changeColor(String color) {
		color = "yellow";
		
	}

	private static void changeColor(Box box, String string) {
		box = new Box();
		box.color = string;
	}
}

class Box {
	String color = "red";
}
