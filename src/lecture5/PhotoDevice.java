package lecture5;
public interface PhotoDevice {
	void capture();
}

class Sony extends Camera {
	@Override
	public void capture() {
		System.out.println("Sony can take better pictures");

	}

	@Override
	public void changeBattery() {
		System.out.println("Changing Battery in Sony");
	}

}
