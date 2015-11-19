package lecture7;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WordTest {
	public static void main(String args[]) {
		String string = "Siva is teaching to Students . Students are listening. Students are good";
		// Siva 1
		// is 1
		// teaching 1
		// to 1
		// Students 3

		Map<String, Integer> wordOccurences = findWordOccurences(string);
		Set<String> keys = wordOccurences.keySet();
		for (String key : keys) {
			Integer count = wordOccurences.get(key);
			System.out.println(key + " -> " + count);
		}

	}

	public static Map<String, Integer> findWordOccurences(String string) {
		String tokens[] = string.split(" ");
		TreeMap<String, Integer> wordCountMap = new TreeMap<String, Integer>();
		for (String token : tokens) {
			boolean b = wordCountMap.containsKey(token);
			if (b == false) {
				wordCountMap.put(token, 1);
			} else {
				Integer i = wordCountMap.get(token);
				wordCountMap.put(token, i + 1);
			}
		}
		return wordCountMap;
	}
}
