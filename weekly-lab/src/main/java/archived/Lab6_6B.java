package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * In the modern age people come from different parts of the world and their names are sometimes long and rather different to pronounce.
 * As such, nick names are very handy to communicate in an efficient manner. This problem deals with you producing unique nick names by truncating the names at a character where a unique combination is reached.
 * For example, if you were given the names 'aaacc', 'bba' and 'abababab', we can call 'aaacc' by 'aa'.
 * Just 'a' is not enough as there is another person with the name 'abababab' which also starts with an 'a'.
 * Write a Java program to find nick names for everybody in a given group, which would be a prefix to their names, and also of the shortest length possible.
 * Your program should output the total number of characters required to produce all the nick names.
 * For instance, in the group mentioned above you will has 'aa' for 'aaacc', 'b' for 'bba' and 'ab' for 'abababab' and the total characters used will be 2 for 'aa' + 1 for 'b' + 2 for 'ab' = 5
 * 
 * Input
 * Input will have one integer 1<=n<=10 on the first line representing the total number of people present in the group.
 * Each of the following n lines will contain one string consisting of lowercase letters, representing the name of one person.
 * 
 * Output
 * Output will contain only a single integer representing total number of characters required to produce the nick names for everybody in the given group
 * 
3
aaacc
bba
abababab

8
demetrius
montgomery
pneumoencephalographically
psychophysicotherapeutics
psychoneuroendocrinological
radioimmunoelectrophoresis
radiology
radiography
 */
public class Lab6_6B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lines = Integer.parseInt(sc.nextLine());

		List<String> input = new ArrayList<>();
		while (lines > 0) {
			input.add(sc.nextLine());
			lines--;
		}

		List<String> prefix = prefix(input);
		int count = 0;
		for (String s : prefix) {
			count += s.length();
		}

		System.out.println(count);
	}

	public static List<String> prefix(List<String> input) {
		List<String> prefix = new ArrayList<>();
		int stringIndex = 0;
		int endIndex = 1;
		while (stringIndex < input.size()) {
			String current = input.get(stringIndex);
			String p = current.substring(0, endIndex);
			if (endIndex == current.length()) {
				prefix.add(p);
				stringIndex++;
				endIndex = 1;
				continue;
			}
			boolean conflict = false;
			for (int k = 0; k < input.size(); k++) {
				if (stringIndex != k && input.get(k).startsWith(p)) {
					endIndex++;
					conflict = true;
					break;
				}
			}

			if (!conflict) {
				prefix.add(p);
				stringIndex++;
				endIndex = 1;
			}
		}
		return prefix;
	}
}
