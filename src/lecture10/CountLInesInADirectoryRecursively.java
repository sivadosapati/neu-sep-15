package lecture10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountLInesInADirectoryRecursively {

	public static void main(String[] args) throws IOException {
		File file = new File("/Users/dosapats/git/neu-sep-15/src/");
		if (file.isDirectory()) {
			int lines = countLinesInDirectory(file);
			System.out.println("Total Lines : " + lines);
		}
	}

	private static int countLinesInDirectory(File file) throws IOException {
		File[] files = file.listFiles();
		int count = 0;
		for (File f : files) {
			if (f.isDirectory()) {
				count += countLinesInDirectory(f);
			} else {
				count += countLinesInFile(f);
			}
		}
		return count;
	}

	private static int countLinesInFile(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		int count = 0;
		while (br.readLine() != null) {
			count ++;
		}
		br.close();
		return count;
	}

}
