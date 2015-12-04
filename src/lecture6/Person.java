package lecture6;

import base.BaseObject;

public class Person extends BaseObject {
	String name;

	Person(String name) {
		this.name = name;
	}

	public void callFriend() {
		System.out.println(name + " is calling friend");
	}

	public void walk() throws RainException {
		int random = getRandomNumber(20);
		for (int i = 0; i < 10; i++) {
			println(name + " -> Step # " + i);
			if (i == random) {
				RainException re = new RainException();
				throw re;
			}
		}
	}

	void eat() throws DontLikeFoodException, FoodSpoiltException {
		int random = getRandomNumber(20);
		if (random < 5) {
			throw new DontLikeFoodException();
		}
		if (random > 6 && random < 9) {
			throw new FoodSpoiltException();
		}
	}

	void eat(Food food) throws DontLikeFoodException{
		int random = getRandomNumber(20);
		for (int i = 0; i < 10; i++) {
			food.consume();
			if( i == random){
				throw new DontLikeFoodException(food.quantity);
			}
		}
	}

	public void run() throws CarHitException {
		int random = getRandomNumber(500);
		for (int i = 0; i < 10; i++) {
			println(name + " -> Run Step # " + i);
			if (i == random) {
				CarHitException ce = new CarHitException();
				throw ce;
			}
		}

	}
}

class RainException extends Exception {

}

class CarHitException extends RuntimeException {

}