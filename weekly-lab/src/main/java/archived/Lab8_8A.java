package test;

import java.util.Scanner;

/*
 * A checksum is a type of simple error detection scheme, meat to catch incorrectly entered data such as typos.
 * In the following a letter is appended to the end of a number as checksum as validation
 * 
 * A simple scheme used to validate 6-digit student ids is as follows:
 * - separate into digits and add them together to get a new number
 * - repeat the process until the result is only a single digit
 * - the checksum letter is the capital letter in that position (A for position 1, B for position 2 ..., Z for position 26)
 * 
 * Example:
 * 123456
 * 1+2+3+4+5+6=21
 * 2+1=3
 * 3=C
 * 
 * Given a list of pairs <id, letter>, your program must output a binary string with 0 (no match) and 1 (match) for each pair in the given order
 * 
 * Input specification:
 * The first line contains an integer N (maximum value 10) indicating the number of pairs and the next N lines, each contains a pair - an integer followed by the capital letter
 * separated by a single space.
 * 
 * Output specification:
 * The output is a binary integer of length N, showing the result of matching the checksum letter. No leading or tailing spaces and terminated by a new line
 * 
 * Sample Test Cases:
 * 6
 * 123456 C
 * 123456 A
 * 100000 A
 * 111111 F
 * 111114 I
 * 123456 A
 * 
 * Output
 * 101110
 * 
 */
public class Lab8_8A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ids = Integer.parseInt(sc.nextLine());
		String result = "";
		while (ids > 0) {
			String[] input = sc.nextLine().split(" ");

			if (getChecksum(input[0]) == input[1].charAt(0)) {
				result += "1";
			} else {
				result += "0";
			}
			ids--;
		}
		System.out.println(result);
	}

	public static char getChecksum(String id) {
		int sum = 0;
		for (int i = 0; i < id.length(); i++) {
			sum += Integer.parseInt(Character.toString(id.charAt(i)));
		}

		while (sum > 10) {
			sum = getDigitSum(sum);
		}

		return (char) (64 + sum);
	}

	public static int getDigitSum(int input) {
		int sum = 0;
		while (input > 0) {
			sum += input % 10;
			input = input / 10;
		}

		return sum;
	}

}
