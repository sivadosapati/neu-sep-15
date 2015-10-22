package lecture7;

import java.util.ArrayList;

import base.BaseObject;

public class ArrayAndCollectionTest extends BaseObject {
	public static void main(String args[]) {
		String[] names = new String[10];
		ArrayList namesList = new ArrayList();
		int max = 2500 + getRandomNumber(25);
		System.out.println(max);
		for (int i = 0; i < max; i++) {
			namesList.add("NEU"+i);
		}
		System.out.println("Done");
	}
}
