package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * Encrypting allows us to send sensitive information with added security. Original message is encoded on the senders's side and is decoded on the receiver side. 
 * In this example a given paragraph is encoded into a single uppercase word. Your program must determine the frequency of each letter of the alphabet in a paragraph of text
 * 
 * Input:
 * The first lien of input is a single positive integer N > 0 giving the number of lines in the paragraph. 
 * The subsequent N lines are the lines of text in the paragraph. Each line will contains at most 255 characters.
 * 
 * Output:
 * The output will contain one line of uppercase characters (no space), arranged is sorted decreasing order of their frequency.
 * Letters with the same frequency must be output in alphabetical order. Please note that a lowercase letter, say 'a', counts towards the frequency of 'A'.
 * Display only those letters that occurred at least once.
 * 
 * 
2
This sentence has 4 t's in it.
And this one only has one.

NSETHIAOCDLY
 *
 */
public class Lab6_6A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lines = Integer.parseInt(sc.nextLine());

		Map<Character, Integer> map = new HashMap<>();
		while (lines > 0) {
			pushToMap(map, sc.nextLine());
			lines--;
		}

		List<Counter> list = new ArrayList<>();
		for (Entry<Character, Integer> entry : map.entrySet()) {
			list.add(new Counter(entry.getKey(), entry.getValue()));
		}

		Collections.sort(list);

		String result = "";
		for (Counter c : list) {
			result += c.letter;
		}

		System.out.println(result);
	}

	public static void pushToMap(Map<Character, Integer> map, String s) {
		char[] items = s.toUpperCase().toCharArray();
		for (char item : items) {
			if (Character.isUpperCase(item)) {
				map.put(item, map.getOrDefault(item, 0) + 1);
			}
		}
	}
}

class Counter implements Comparable {

	int count;
	char letter;

	public Counter(char letter, int count) {
		this.count = count;
		this.letter = letter;
	}

	@Override
	public int compareTo(Object o) {
		Counter another = (Counter) o;
		int result = Integer.compare(another.count, this.count);

		if (result == 0) {
			return Character.compare(this.letter, another.letter);
		}
		return result;
	}

	@Override
	public String toString() {
		return "Counter [count=" + count + ", letter=" + letter + "]";
	}

}
