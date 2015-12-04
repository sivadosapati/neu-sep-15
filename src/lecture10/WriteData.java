package lecture10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteData {

	public static void main(String[] args) {
		File file = new File("/Users/dosapats/hello1.txt");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			String hello = "I want to write Hello Everybody";
			// writeUsingOneByOneCharacter(fos, hello);
			writeTheEntireString(fos, hello);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void writeTheEntireString(FileOutputStream fos, String hello)
			throws IOException {
		byte b[] = hello.getBytes();
		fos.write(b);
	}

	private static void writeUsingOneByOneCharacter(FileOutputStream fos,
			String hello) throws IOException {
		char ch[] = hello.toCharArray();
		for (char c : ch) {
			fos.write((int) c);
		}
	}

}
