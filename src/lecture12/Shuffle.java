package lecture12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Shuffle {
	
	String[] team1 = {"Nan","Ying","Jessie","Kristine"};
	String[] team2 = {"Jigang","Yang","Amy","Chengzheng"};
	String[] team3 = {"Yi Hong","KK","Jian Hou","Ding Xin"};

	String team1Lead = "Nan";
	String team2Lead = "Amy";
	String team3Lead ="Jian Hou";
	
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 1; i <= 12; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		int count = 0;
		for (Integer integer : numbers) {
			if( count%4 == 0){
				System.out.println("Team -> ");
			}
			System.out.println(integer);
			count++;

		}
	}

}
