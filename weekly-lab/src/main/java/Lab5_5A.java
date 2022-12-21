
import java.util.Arrays;
import java.util.Scanner;

public class Lab5_5A {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int counter = Integer.parseInt(scanner.nextLine());
		while (counter > 0) {
			System.out.println(compare(scanner.nextLine(), scanner.nextLine()));
			counter--;
		}
	}

	public static String compare(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		Arrays.sort(c1);
		Arrays.sort(c2);

		s1 = "";
		for (int i = c1.length - 1; i >= 0; i--) {
			s1 += c1[i];
		}
		s2 = "";
		for (int i = c2.length - 1; i >= 0; i--) {
			s2 += c2[i];
		}

		// System.out.println(s1);
		// System.out.println(s2);

		if (s1.compareTo(s2) < 0) {
			return "SMALLER";
		} else if (s1.compareTo(s2) > 0) {
			return "LARGER";
		}

		return "SAME";
	}
}
