package lecture6;

import base.BaseObject;

public class CountNumbers extends BaseObject {
	public static void main(String args[]) {
		countNumbers();
	}

	public static void countNumbers() {
		int count = 0;
		String output = "(";
		while (true) {
			println("Please enter a number and for quit enter #");
			String s = getStringFromConsole();
			if (s.equals("#")) {
				break;
			}
			count += Integer.parseInt(s);
			output = output + s + "+";
		}
		output = stripLastCharacter(output) + ") = " + count;
		System.out.println(output);
	}
}
