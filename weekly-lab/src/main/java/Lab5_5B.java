
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Lab5_5B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = Integer.parseInt(sc.nextLine());
		Map<String, Integer> countMap = new HashMap<>();
		Map<String, List<String>> storeMap = new HashMap<>();

		while (count > 0) {
			String line = sc.nextLine();
			storeToMap(line, countMap, storeMap);
			count--;
		}

		// System.out.println(countMap);
		// System.out.println(storeMap);
		List<String> result = getResult(countMap, storeMap);
		Collections.sort(result);
		String p = result.get(0);
		for (int i = 1; i < result.size(); i++) {
			p += " " + result.get(i);
		}

		System.out.println(p);
	}

	public static List<String> getResult(Map<String, Integer> countMap, Map<String, List<String>> storeMap) {
		List<String> result = new ArrayList<>();

		for (Entry<String, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() == 1) {
				result.add(storeMap.get(entry.getKey()).get(0));
			}
		}

		return result;
	}

	public static boolean allSameChar(String s) {
		if (s.length() == 0) {
			return true;
		}

		char first = s.charAt(0);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != first) {
				return false;
			}
		}

		return true;
	}

	public static void storeToMap(String key, Map<String, Integer> countMap, Map<String, List<String>> storeMap) {
		String[] words = key.split(" ");
		for (String word : words) {
			if (word.trim().equals("")) {
				continue;
			}
			char[] items = word.toLowerCase().toCharArray();
			Arrays.sort(items);
			String newKey = "";
			String newValue = "";
			for (char c : items) {
				if ("abcdefghijklmnopqrstuvwxyz".indexOf(c) != -1) {
					newKey += c;
				}
			}

			for (char c : word.toCharArray()) {
				if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(c) != -1) {
					newValue += c;
				}
			}
			if (newKey.equals("")) {
				continue;
			}
			if (countMap.containsKey(newKey)) {
				countMap.put(newKey, countMap.get(newKey) + 1);
			} else {
				countMap.put(newKey, 1);
				storeMap.put(newKey, new ArrayList<>());
			}
			storeMap.get(newKey).add(newValue);
		}
	}
}
