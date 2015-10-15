package lecture6;

class Burger extends Food {

}

public class WalkOnTheRoad {
	public static void main(String args[]) throws Exception {

		Burger b = new Burger();
		// createAnError();
		Person nan = new Person("Nan");
		Person yang = new Person("Yang");
		eat(nan, b);
		// nan.walk();
		// yang.walk();

		walk(nan, yang);
		// run(nan,yang);
		eat(nan);
	}

	private static void eat(Person nan, Burger b) {
		try {
			nan.eat(b);
		} catch (DontLikeFoodException e) {
			if (e.quantity < 5) {
				System.out.println("Go to shop and buy another burger");
			} else {
				System.out.println("Take it easy and relax. Throw the burger in garbage");
			}
		}
	}

	private static void eat(Person nan) {
		try {
			nan.eat();
		} catch (DontLikeFoodException de) {
			System.out.println("Dontlike");
		} catch (FoodSpoiltException fe) {
			System.out.println("Food spoilt");
		} catch (Exception e) {
			System.out.println("Final catch");
		}
	}

	private static void createAnError() {
		Person[] p = new Person[50000000];
		for (int i = 0; i < 50000000; i++) {
			p[i] = new Person("NEU is a nice university. It's good to be here -> " + i);
			if (i % 1000 == 0) {
				System.out.println("Created " + i + " objects");
			}
		}
	}

	private static void run(Person nan, Person yang) {
		nan.run();
		yang.run();
	}

	private static void walk(Person nan, Person yang) {
		try {
			nan.walk();
			System.out.println("Nan finished walking");
			nan.callFriend();
		} catch (RainException re) {
			System.out.println("Open Umbrella");
			nan.callFriend();
		} finally {
			System.out.println("Nan is done walking - he wants to relax");
		}

		try {
			yang.walk();
			System.out.println("Yang finished walking");
		} catch (RainException re) {
			System.out.println("Go into car");
		} finally {
			yang.callFriend();
		}
		System.out.println("Everyone finished walking");
	}
}
