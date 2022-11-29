package test;

import java.util.Scanner;

/*
 * People in the country X use a special type of paper bills as currency. The values of these bills are square numbers less than or equal to 289. They have the following bills:
 * 1-credit bill
 * 4-credit bill(4=2*2)
 * 9-credit bill(9=3*3)
 * ...
 * 289-credit bill(289=17*17)
 * This means, if they want to pay 10 credits, there are four different combinations:
 * ten 1-credit bills
 * one 4-credit bill + six 1-credit bills
 * two 4-credit bills + two 1-credit bills
 * one 9-credit bill + one 1-credit bill
 * 
 * Write a java program to find number of different combinations of bills to pay a given amount of money and the minimum number of bills to pay that amount of money
 * 
 * Input
 * The first line of input is an integer N indicating the number of credits to be paid. The next N lines are each individual credit to be paid.
 * You may assume that all the amounts are positive and less than 300
 * 
 * Output
 * The output has N lines each representing output for credits to be paid from the input query. Each line contains two integers, separated by a single space,
 * first represents the number of different combinations possible and second represents minimum number of bills required to pay that credit.
 * 
 * Input
 * 2
 * 10
 * 30
 * 
 * Output
 * 4 2
 * 27 3
 * 
 * Input
 * 4
 * 101
 * 82
 * 37
 * 16
 * 
 * Output
 * 1167 2
 * 526 2
 * 46 2
 * 8 1
 */
public class Lab8_8B {
	static class Counter {
		int combinations;
		int minNumberOfBills = Integer.MAX_VALUE;
	}

	public static void main(String[] args) {

		int[] bills = getBills();

		Scanner sc = new Scanner(System.in);
		int credits = Integer.parseInt(sc.nextLine());

		while (credits > 0) {
			int target = Integer.parseInt(sc.nextLine());
			Counter c = new Counter();
			payBill(target, 0, bills, 0, c);
			System.out.println(c.combinations + " " + c.minNumberOfBills);
			credits--;
		}
	}

	public static void payBill(int current, int index, int[] bills, int numberOfBills, Counter counter) {
		// base case
		if (current == 0) {
			counter.combinations++;
			counter.minNumberOfBills = Math.min(counter.minNumberOfBills, numberOfBills);
		} else if (current < 0) {
			return;
		}

		for (int i = index; i < bills.length; i++) {
			payBill(current - bills[i], i, bills, numberOfBills + 1, counter);
		}
	}

	public static int[] getBills() {
		int[] bills = new int[17];
		for (int i = 0; i < bills.length; i++) {
			bills[i] = (i + 1) * (i + 1);
		}

		return bills;
	}

}
