package lecture5;

public class Camera implements PhotoDevice {

	@Override
	public void capture() {
		System.out.println("Camera is taking a picture");

	}

	public void changeBattery() {
		System.out.println("Changing Battery in Camera");
	}

}