package lecture10;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class WriteOutputToAFile {

	public static void main(String[] args) throws Exception {
		File f = new File(
				"/Users/dosapats/git/neu-sep-15/src/lecture10/output_to_file");
		FileOutputStream fos = new FileOutputStream(f);
		PrintStream ps = new PrintStream(fos);
		
		System.out.println("Siva");
		PrintStream consoleOut = System.out;
		System.setOut(ps);
		System.out.println("Kumar");
		System.out.println("NEU");
		System.setOut(consoleOut);
		System.out.println("Jigang");

	}
}
