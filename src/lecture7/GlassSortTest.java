package lecture7;

import java.util.ArrayList;
import java.util.HashSet;

public class GlassSortTest {

	public static void main(String args[]) {
		Glass a = new Glass(10);
		Glass b = new Glass(10);
		Glass c = new Glass(15);

		ArrayList<Glass> glassesList = new ArrayList<Glass>();
		glassesList.add(a);
		glassesList.add(b);
		glassesList.add(c);
		System.out.println(glassesList.size());

		HashSet<Glass> glassesSet = new HashSet<Glass>();
		glassesSet.add(a);
		glassesSet.add(b);
		glassesSet.add(c);

		System.out.println(glassesSet.size());
		if (a.equals(b)) {
			System.out.println("Both are equal");
		} else {
			System.out.println("Both are not equal");
		}
	}

}
