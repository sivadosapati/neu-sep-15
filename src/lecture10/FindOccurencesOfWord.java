package lecture10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class FindOccurencesOfWord {
	public static void main(String args[]) throws IOException {

		File f = new File("/Users/dosapats/hello.txt");
		FileInputStream fis = new FileInputStream(f);
		InputStreamReader reader = new InputStreamReader(fis);
		BufferedReader buffered = new BufferedReader(reader);
		readThrougReader(buffered);
		//readThroughStreams(fis);

		fis.close();
	}

	public static void readThrougReader(BufferedReader buffered)
			throws IOException {
		//StringBuilder builder = new StringBuilder();
		int count =0;
		while(true){
			String line = buffered.readLine();
			if(line == null)break;
			Map<String,Integer> words = lecture7.WordTest.findWordOccurences(line);
			Integer x = words.get("and");
			if( x!=null){
				count = count + x;
			}
		}
		System.out.println(count);
	}

	public static void readThroughStreams(FileInputStream fis)
			throws IOException {
		String s = readDataInOneShot(fis);
		// System.out.println(s);
		Map<String, Integer> wordMap = lecture7.WordTest.findWordOccurences(s);
		System.out.println(wordMap.get("and"));
		// System.out.println(wordMap);
	}

	private static String readDataInOneShot(FileInputStream fis)
			throws IOException {
		int available = fis.available();
		byte b[] = new byte[available];
		fis.read(b);
		String string = new String(b);
		return string;

	}
}
