package lecture7;

import java.util.ArrayList;

public class GenericTest {
	public static void main(String args[]) {
		testWithNonGenerics();
		testWithGenerics();
	}

	private static void testWithGenerics() {
		ArrayList<Cable> cables = new ArrayList<Cable>();
		//cables.add("siva");
		cables.add(new Cable());
		//cables.add(new Paper());
		//cables.add(new Integer(764));

	}

	private static void testWithNonGenerics() {
		ArrayList cables = new ArrayList();
		cables.add("siva");
		cables.add(new Cable());
		cables.add(new Paper());
		cables.add(new Integer(764));
	}
}

class Paper {
}

class Cable {
}