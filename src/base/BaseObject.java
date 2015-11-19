package base;

import java.util.Random;
import java.util.Scanner;

public class BaseObject {

	public static String getStringFromConsole() {
		Scanner s = new Scanner(System.in);
		String next = s.next();
		// s.close();
		return next;
	}
	
	public static String getLineFromConsole(){
		Scanner s = new Scanner(System.in);
		String next = s.nextLine();
		// s.close();
		return next;
	}

	public void waitForAWhile() {
		try {
			wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
		}
	}

	public static int getRandomNumber(int x) {
		return (int) (Math.random() * x);
	}

	public static String stripLastCharacter(String s) {
		return s.substring(0, s.length() - 1);
	}

	public static void println(String string) {
		System.out.println(string);
	}

}
