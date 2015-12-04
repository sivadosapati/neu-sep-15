package lecture10;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadData {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		// File file = new File("/Users/dosapats/hello.txt");
		File file = new File("/Users/dosapats/data.txt");
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		long start = System.nanoTime();
		readDataBitByBit(bis);
		long end = System.nanoTime();
		long time = end - start;
		System.out.println("Time taken - " + time + " ns");
		// readDataInOneShot(fis);
		fis.close();
		bis.close();

	}

	private static void readDataInOneShot(FileInputStream fis)
			throws IOException {
		int available = fis.available();
		byte b[] = new byte[available];
		fis.read(b);
		String string = new String(b);
		System.out.println(string);

	}

	private static void readDataBitByBit(InputStream fis) throws IOException {
		while (true) {
			int i = fis.read();
			if (i == -1)
				break;
			char c = (char) i;
			// System.out.print(c);
		}
	}

}
