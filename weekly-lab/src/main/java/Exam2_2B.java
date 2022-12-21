
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exam2_2B {
	/*
	 * word matching
	 * 
	 * ? - matches any single character * - matches any series of 0 or more
	 * character
	 * 
	 * The input: The first line of each test case contains an integer 1 <= N <=
	 * 1000, the number of words in the dictionary. The next N lines each contain a
	 * unique word, consisting of only capital letters, up to 256 characters in
	 * length. The next 5 lines are test queries, consisting of capital letters, ?
	 * and *
	 * 
	 * The output: The output will contain 5 lines. Each line is a comma separated
	 * with a space list of all matches found in the dictionary. The results in the
	 * list appear in the same order as they do in the supplied dictionary. If no
	 * match is found output NO MATCH
	 * 
	 * 5 MONDAY TUESDAY WEDNESDAY WEDDING WADDING WEDDING *SDAY W?DDING W?D* N*D*
	 * 
	 * 
	 * 6 TALK TEAR TURF TIPS TURN TWIST ? T??? ?U?? TA??? *W*
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lineNumber = Integer.parseInt(sc.nextLine());
		Map<String, String> words = new LinkedHashMap<>();
		while (lineNumber > 0) {
			String word = sc.nextLine();
			words.put("@" + word + "@", word);
			lineNumber--;
		}

		int testLines = 5;
		while (testLines > 0) {
			String regex = generateRegex(sc.nextLine());
			Pattern p = Pattern.compile(regex);
			List<String> result = match(p, words);
			printResult(result);
			testLines--;
		}
	}

	public static void printResult(List<String> res) {
		if (res.size() == 0) {
			System.out.println("NO MATCH");
			return;
		}

		String s = res.get(0);
		for (int i = 1; i < res.size(); i++) {
			s += ", " + res.get(i);
		}

		System.out.println(s);
	}

	public static List<String> match(Pattern p, Map<String, String> words) {
		List<String> res = new ArrayList<>();
		Matcher m;
		for (Entry<String, String> entry : words.entrySet()) {
			m = p.matcher(entry.getKey());
			if (m.find()) {
				res.add(entry.getValue());
			}
		}

		return res;
	}

	public static String generateRegex(String s) {
		String r = "@";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '*') {
				r += ".*";
			} else if (s.charAt(i) == '?') {
				r += ".";
			} else {
				r += s.charAt(i);
			}

		}

		return r + "@";
	}

}
