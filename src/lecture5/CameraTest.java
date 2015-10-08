package lecture5;

public class CameraTest {
	public static void main(String []a){
		Camera c1 = new Sony();
		Camera c = new Camera();
		Sony s = new Sony();
		c1.changeBattery();
		c.changeBattery();
		s.changeBattery();
	}
}
