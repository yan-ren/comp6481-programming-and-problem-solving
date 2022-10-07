package archived;

import java.util.Scanner;

public class Lab1_1A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		String[] names = input.split(" ");

		if (names.length == 2) {
			nameTwo(names);
		} else if (names.length == 3) {
			nameThree(names);
		} else if (names.length == 1) {
			System.out.print(names[0]);
		}
	}

	public static void nameTwo(String[] names) {
		char secondNameLastChar = names[1].charAt(names[1].length() - 1);

		if ("aeiouAEIOU".indexOf(secondNameLastChar) == -1) {
			System.out.print(names[0] + " " + names[1]);
		} else {
			System.out.print(names[1] + " " + names[0]);
		}
	}

	public static void nameThree(String[] names) {
		System.out.print(names[2] + " " + names[0] +  " " + names[1]);
	}
}
