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

	public int getRandomNumber( int x ){
		return (int )(Math.random() * x );
	}

	public static String stripLastCharacter(String s) {
		return s.substring(0, s.length() - 1);
	}

	public static void println(String string) {
		System.out.println(string);
	}

}
