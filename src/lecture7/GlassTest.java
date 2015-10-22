package lecture7;

import java.util.TreeSet;

public class GlassTest {

	public static void main(String args[]) {
		Glass a = new Glass(10);
		Glass b = new Glass(101);
		Glass c = new Glass(5);
		Glass d = new Glass(15);

		TreeSet<Glass> glassesSet = new TreeSet<Glass>();
		glassesSet.add(a);
		glassesSet.add(b);
		glassesSet.add(c);
		glassesSet.add(d);

		System.out.println("Size -> " + glassesSet.size());

		for (Glass g : glassesSet) {
			System.out.println("Glass -> " + g.volumeOfWater);
		}
	}

}