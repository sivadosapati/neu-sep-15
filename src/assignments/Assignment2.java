package assignments;

public class Assignment2 {
	public int[] findEvenNumbers(int number) {
		int size = number / 2;
		int evenNumbers[] = new int[size];
		int index = 0;
		for (int i = 0; i < size; i++) {
			evenNumbers[index] = 2 + i * 2;
			index++;
		}
		return evenNumbers;
	}

	public boolean isPrime(int number) {
		if (number == 2 || number == 2) {
			return true;
		}
		for (int i = 2; i < number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public int countNumberOfDigits(int number) {
		int count = 0;
		if (number == 0) {
			return 1;
		}
		for (int n = number; n != 0; n = n / 10) {
			count++;
		}
		return count;
	}

	public int getOccurencesOfLetterA(String string) {
		return getOccurencesOfLetter(string, 'a');
	}

	public int getOccurencesOfLetter(String string, char c) {
		char characters[] = string.toCharArray();
		int count = 0;
		for (int i = 0; i < characters.length; i++) {
			if (characters[i] == c) {
				count++;
			}
		}
		return count;

	}

	public int findMaximum(int numbers[]) {
		int maximum = Integer.MIN_VALUE;
		for (int i = 0; i < numbers.length; i++) {
			int number = numbers[i];
			if (number > maximum) {
				maximum = number;
			}
		}
		return maximum;
	}

	public int findMinimum(int numbers[]) {
		int minimum = Integer.MAX_VALUE;
		for (int i = 0; i < numbers.length; i++) {
			int number = numbers[i];
			if (number < minimum) {
				minimum = number;
			}
		}
		return minimum;
	}

	public static void main(String args[]) {
		Assignment2 assignment = new Assignment2();
		System.out.println("Even Numbers....");
		testFindEvenNumbers(assignment, 25);
		testFindEvenNumbers(assignment, 2);
		testFindEvenNumbers(assignment, 1);

		System.out.println("\n\nPrime Numbers....");
		testForPrime(assignment, 31);
		testForPrime(assignment, 7);
		testForPrime(assignment, 150);

		System.out.println("\n\nDigit Counts....");
		testForDigitCount(assignment, 12345);
		testForDigitCount(assignment, 0);
		testForDigitCount(assignment, 1);
		testForDigitCount(assignment, 349343434);

		System.out.println("\n\nCount occurences of a....");
		testForLetterAInString(assignment, "north eastern university");
		testForLetterAInString(assignment, "Alabama");
		testForLetterAInString(assignment, "All students are doing a great job in doing the assignments");

		System.out.println("\n\nCount occurences of a letter....");
		testForLetterInString(assignment, "north eastern university", 'e');
		testForLetterInString(assignment, "Alabama", 'e');
		testForLetterInString(assignment, "All students are doing a great job in doing the assignments", 'i');

		System.out.println("\n\nFind Maximum....");
		testForMaximum(assignment, new int[] { 87, 65, 1, 1981, 23, 36, 99 });
		testForMaximum(assignment, new int[] { 1, 2, 3 });

		System.out.println("\n\nFind Maximum and Minimum....");
		testForMaximumAndMinimum(assignment, new int[] { 87, 65, 1, 1981, 23, 36, 99 });
		testForMaximumAndMinimum(assignment, new int[] { 187, 65, 231, 981, 123, 11, 7223 });

	}

	private static void testFindEvenNumbers(Assignment2 assignment, int number) {
		int[] evenNumbers = assignment.findEvenNumbers(number);
		if (evenNumbers.length == 0) {
			System.out.println("No even numbers upto -> " + number);
			return;
		}
		System.out.println("Following Even numbers are upto -> " + number);
		for (int i = 0; i < evenNumbers.length; i++) {
			System.out.print(evenNumbers[i]);
			if (i < evenNumbers.length) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

	private static void testForPrime(Assignment2 assignment, int number) {
		boolean result = assignment.isPrime(number);
		if (result) {
			System.out.println(number + " is prime");
		} else {
			System.out.println(number + " is not prime");
		}
	}

	private static void testForDigitCount(Assignment2 assignment, int number) {
		int count = assignment.countNumberOfDigits(number);
		if (count == 1) {
			System.out.println(number + " has 1 digit");
		} else {
			System.out.println(number + " has " + count + " digits");
		}
	}

	private static void testForLetterAInString(Assignment2 assignment, String string) {
		int count = assignment.getOccurencesOfLetterA(string);
		if (count == 0) {
			System.out.println(string + " has no 'a' ");
		} else {
			System.out.println(string + " has " + count + " 'a' ");
		}
	}

	private static void testForLetterInString(Assignment2 assignment, String string, char character) {
		int count = assignment.getOccurencesOfLetter(string, character);
		if (count == 0) {
			System.out.println(string + " has no '" + character + "'");
		} else {
			System.out.println(string + " has " + count + " '" + character + "'");
		}
	}

	private static void testForMaximum(Assignment2 assignment, int[] numbers) {
		int max = assignment.findMaximum(numbers);
		System.out.println("Maximum " + toString(numbers) + " = " + max);
	}

	private static void testForMaximumAndMinimum(Assignment2 assignment, int[] numbers) {
		int max = assignment.findMaximum(numbers);
		int min = assignment.findMinimum(numbers);
		System.out.println("Max is " + max + " and Min is " + min + " in " + toString(numbers));
	}

	private static String toString(int[] numbers) {
		String output = "[";
		for (int i = 0; i < numbers.length; i++) {
			output = output + numbers[i] + ",";
		}
		return output + "]";
	}

}
