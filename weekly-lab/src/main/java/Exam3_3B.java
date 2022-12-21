
import java.util.Arrays;
import java.util.Scanner;

/*
 * binary numbers comprise of on 0 and 1, however, there are a few interesting mechanisms to generate encoding patterns through them.
 * One such pattern is referred to as reflected gray codes. We start with sequence [0, 1], moving forward for every bit, we simply reflect the sequence on x-axis (horizontal line)
 * and prepend 0 to upper half and 1 to the lower half. This process is explained in detail in the table below
 * 
 *  1-bit
 *  0
 *  1
 *  
 *  2-bit
 *  00
 *  01
 *  11
 *  10
 *  
 *  3-bit
 *  000
 *  001
 *  011
 *  010
 *  110
 *  111
 *  101
 *  100
 *  
 *  Input:
 *  The input to this program will have only one line with 2 integers: n(1<=n<=20), and k separated by a single space
 *  
 *  Output:
 *  The output will will a single integer representing the decimal value of the number that appears in position k(0 based index) of the n-bit Reflected Gray Code
 *  
 *  Sample Test Cases:
 *  input:
 *  3 5
 *  output:
 *  7
 *  
 *  input:
 *  2 1
 *  output:
 *  1
 *  
 *  input:
 *  5 9
 *  output:
 *  13
 */
public class Exam3_3B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);

		int[][] start = { { 0 }, { 1 } };
		while (n > 1) {
			start = reflect(start);
			n--;
		}

		System.out.println(getDecimalByIndex(start, k));
	}

	public static int getDecimalByIndex(int[][] input, int index) {
		int[] binary = input[index];
		int result = 0;
		for (int i = binary.length - 1; i >= 0; i--) {
			result += binary[i] * Math.pow(2, binary.length - 1 - i);
		}

		return result;
	}

	public static int[][] reflect(int[][] input) {
		int[][] result = new int[input.length * 2][input[0].length + 1];

		// copy first half
		for (int i = 0; i < input.length; i++) {
			for (int j = 1; j < result[i].length; j++) {
				result[i][j] = input[i][j - 1];
			}
		}
		// copy second half
		for (int i = input.length; i < result.length; i++) {
			result[i][0] = 1;
			for (int j = 1; j < result[i].length; j++) {
				result[i][j] = input[result.length - 1 - i][j - 1];
			}
		}

		return result;
	}

	public static void printArrays(int[][] input) {
		for (int[] row : input) {
			System.out.println(Arrays.toString(row));
		}
	}
}
