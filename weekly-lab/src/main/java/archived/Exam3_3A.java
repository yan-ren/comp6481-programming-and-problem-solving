package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * Given a string, find all non-duplicated permutations and output in alphabetically ascending sorted order
 * 
 * Input:
 * The input will contain a single lien string with length l where 0<l<=5 lower-case characters
 * 
 * Output:
 * The output will container all the combinations printed in an alphabetically ascending sorted order on the same lien separated by a single space
 * 
 * Sample Test Cases:
 * input:
 * bc
 * output:
 * bc cb
 * 
 * input:
 * aba
 * output:
 * aab aba baa
 * 
 * input:
 * z
 * output:
 * z
 * 
 * input:
 * abc
 * output:
 * abc acb bac bca cab cba
 */
public class Exam3_3A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] input = sc.nextLine().toCharArray();
		ArrayList<Character> charList = new ArrayList<>();
		for (char c : input) {
			charList.add(c);
		}

		List<String> permutation = new ArrayList<>();
		Collections.sort(charList);

		permutation(charList, new ArrayList<>(), permutation);

		Collections.sort(permutation);

		System.out.println(String.join(" ", permutation));
	}

	public static void permutation(ArrayList<Character> charList, List<Character> current, List<String> permutation) {
		if (charList.size() == 0) {
			String s = listToString(current);
			if (!permutation.contains(s)) {
				permutation.add(s);
			}
			return;
		}

		for (int i = 0; i < charList.size(); i++) {
			char c = charList.get(i);
			charList.remove(i);
			current.add(c);
			permutation(charList, current, permutation);
			current.remove(current.size() - 1);
			charList.add(i, c);
		}
	}

	public static String listToString(List<Character> charList) {
		String s = "";
		for (char c : charList) {
			s += c;
		}

		return s;
	}
}
