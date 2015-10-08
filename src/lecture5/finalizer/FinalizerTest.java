package lecture5.finalizer;

public class FinalizerTest {
	public static void main(String args[]) throws Exception{
		Cup cups[] = new Cup[10];
		for (int i = 0; i < 10; i++) {
			cups[i] = new Cup();
		}

		for (int i = 0; i < cups.length; i++) {
			System.gc();
			Thread.sleep(500);
			System.out.println(Cup.totalNumberOfCupsInUse());
			cups[i] = null;
			
		}
		System.gc();
		Thread.sleep(2000);
		System.out.println("Cup count -> "+Cup.totalNumberOfCupsInUse());
	}

}

class Cup {
	private static int count = 0;
	private int index;

	public Cup() {
		count++;
		index = count;
		System.out.println("Cup -> " + index);
	}

	@Override
	public void finalize() {
		count--;
	}

	public static int totalNumberOfCupsInUse() {
		return count;
	}

}