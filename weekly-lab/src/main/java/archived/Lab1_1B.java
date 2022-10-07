package archived;

import java.util.Scanner;

public class Lab1_1B {

	public static void main(String[] args) {
		run();
	}

	public static void run() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		char[] digits = input.toCharArray();
		int digitsSum = digitSum(digits);

		if (digitsSum % 10 == 0) {
			System.out.print("VALID");
		} else {
			findCheckDigit(digits, digitsSum);
		}
	}

	public static void findCheckDigit(char[] digits, int sum) {
		int rightMostDigit = digits[digits.length - 1] - '0';
		int errorDigit = sum % 10;
		int roundUp = 10 - errorDigit;
		int roundDown = errorDigit;
		if (roundDown <= rightMostDigit) {
			System.out.print("INVALID " + (rightMostDigit - roundDown));
		} else {
			System.out.print("INVALID " + (rightMostDigit + roundUp));
		}
	}

	public static int digitSum(char[] digits) {
		int sum = 0;
		boolean doubleValue = false;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (!doubleValue) {
				sum += (digits[i] - '0');
			} else {
				int doubledValue = (digits[i] - '0') * 2;
				while (doubledValue > 0) {
					sum += doubledValue % 10;
					doubledValue = doubledValue / 10;
				}
			}
			doubleValue = !doubleValue;
		}

		return sum;
	}
}
