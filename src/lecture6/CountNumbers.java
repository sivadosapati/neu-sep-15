package lecture6;

import base.BaseObject;

public class CountNumbers extends BaseObject {
	public static void main(String args[]) {
		countNumbers();
	}

	public static void countNumbers() {
		int count = 0;
		String newOutput = "(";
		while (true) {
			println("Please enter a number and for quit enter #");
			String s = getStringFromConsole();
			if (s.equals("#")) {
				break;
			}
			count += Integer.parseInt(s);
			newOutput = newOutput + s + "+";
		}
		newOutput = stripLastCharacter(newOutput) + ") = " + count;
		System.out.println(newOutput);
	}
}
