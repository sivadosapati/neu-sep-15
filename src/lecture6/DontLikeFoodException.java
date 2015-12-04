package lecture6;

public class DontLikeFoodException extends Exception {

	public int quantity;

	public DontLikeFoodException(int quantity) {
		this.quantity = quantity;
	}

	public DontLikeFoodException() {

	}

}
