
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exam1_1B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String numberSeq = sc.nextLine();
		String target = sc.nextLine();

		// List<String> res = binarySearch("2 4 5 3 1 7 6 9 0", 3);
		// List<String> res = binarySearch("12 54 25 13 31 3 16 69 100 29 36", 13);
		// List<String> res = binarySearch("2 5 25 3 1 6 8 7", 18);
		// List<String> res = binarySearch("2 5", 5);

		List<String> res = binarySearch(numberSeq, Integer.parseInt(target));

		String resString = "";
		for (String s : res) {
			resString += s + " ";
		}
		System.out.println(resString.trim());
	}

	public static List<String> binarySearch(String numberSeq, int target) {
		List<Integer> numbers = Arrays.asList(numberSeq.trim().split(" ")).stream().map(Integer::parseInt)
				.collect(Collectors.toList());
		// System.out.println(numbers);
		Collections.sort(numbers);
		List<String> result = new ArrayList<>();

		int lo = 0;
		int hi = numbers.size() - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (target == numbers.get(mid)) {
				result.add("found");
				return result;
			} else if (target < numbers.get(mid)) {
				result.add("-1");
				hi = mid - 1;
			} else {
				result.add("1");
				lo = mid + 1;
			}

		}

		result.add("notfound");
		return result;
	}

}
