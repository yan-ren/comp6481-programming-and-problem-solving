
import java.util.Scanner;

public class Exam2_2A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int s = sum(input);
		// System.out.println(s);
		if (isPrime(s)) {
			System.out.println("PRIME");
		} else {
			System.out.println("NOT PRIME");
		}
	}

	public static int sum(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				sum += ((int) s.charAt(i) - 64 + 26);
			} else {
				sum += ((int) s.charAt(i) - 96);
			}
		}

		return sum;
	}

	public static boolean isPrime(int num) {
		int i = 1;
		int prime = 0;
		while (i < num) {
			if (num % i == 0) {
				prime++;
			}

			if (prime > 1) {
				return false;
			}
			i++;
		}

		return true;
	}
}
