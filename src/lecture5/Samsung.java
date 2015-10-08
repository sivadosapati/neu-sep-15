package lecture5;

public class Samsung implements PhotoDevice {

	@Override
	public void capture() {
		System.out.println("Samsung is taking a picture");

	}

	@Override
	public String toString() {
		capture();
		return "Samsung";
	}

}