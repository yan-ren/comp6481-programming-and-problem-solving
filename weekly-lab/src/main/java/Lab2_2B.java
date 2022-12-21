
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab2_2B {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);

		int mapLines = Integer.parseInt(sc.nextLine());
		while (mapLines > 0) {
			buildMap(map, sc.nextLine());
			mapLines--;
		}

		int A = 1;
		int B = 1;
		boolean aTurn = true;
		sc.nextLine();

		int[] plays = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int count = 0;
		while (count < plays.length) {
			// System.out.println("current A:" + A);
			// System.out.println("current B:" + B);
			if (aTurn) {
				A = A + plays[count];
				A = applySnakeOrLadder(A, map);
			} else {
				B = B + plays[count];
				B = applySnakeOrLadder(B, map);
			}

			if (A >= 100) {
				System.out.println("A " + 100);
				System.exit(0);
			}

			if (B >= 100) {
				System.out.println("B " + 100);
				System.exit(0);
			}
			aTurn = !aTurn;
			count++;
		}

		if (A > B) {
			System.out.println("A " + A);
		} else {
			System.out.println("B " + B);
		}

	}

	private static int applySnakeOrLadder(int a, Map<Integer, Integer> map) {
		int start = a;
		while (map.containsKey(start)) {
			start = map.get(start);
		}
		return start;
	}

	public static void buildMap(Map<Integer, Integer> map, String pair) {
		String[] items = pair.split(" ");
		map.put(Integer.parseInt(items[0]), Integer.parseInt(items[1]));
	}
}
