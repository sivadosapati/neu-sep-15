package lecture5;

public class iPhone implements PhotoDevice {

	@Override
	public void capture() {
		System.out.println("iPhone is taking a picture");

	}

	@Override
	public String toString() {
		capture();
		return "iPhone";
	}

}