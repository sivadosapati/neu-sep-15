package lecture5;

import java.util.Scanner;

public class Trip {

	void takePicture(PhotoDevice pd) {
		pd.capture();
	}

	public static void main(String[] args) {
		// takeOnePicture();
		Trip t = new Trip();
		t.takePicturesInTraditionalWay();
		t.takePicturesInABetterWay();
	}

	private static void takeOnePicture() {
		Trip t = new Trip();
		iPhone ip = new iPhone();
		Camera c = new Camera();
		t.takePicture(ip);
		t.takePicture(c);
	}

	public void takePicturesInABetterWay() {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("Please enter a device type - iPhone or Camera or other object");
			String n = scanner.nextLine();
			Object o = createObject(n);
			// System.out.println("test"+o.toString());
			if (o instanceof PhotoDevice) {
				PhotoDevice pd = (PhotoDevice) o;
				takePicture(pd);
				continue;
			}
			System.out.println(n + " is not an object that can take pictures");
			break;
		}
	}

	private Object createObject(String n) {
		try {
			return Class.forName(n).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void takePicturesInTraditionalWay() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Please enter a device type - iPhone or Camera or other object");
			String n = scanner.nextLine();
			if (n.equals("iPhone")) {
				iPhone i = new iPhone();
				takePicture(i);
				continue;
			}
			if (n.equals("Camera")) {
				Camera c = new Camera();
				takePicture(c);
				continue;
			}
			if (n.equals("Samsung")) {
				Samsung s = new Samsung();
				takePicture(s);
				continue;
			}
			System.out.println(n + " is not an object that can take pictures");
			break;
		}
	}

}
