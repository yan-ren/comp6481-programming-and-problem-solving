//
// Assignment 1, part II B
// © Yan Ren
// Written by: Yan Ren 40212201
//

package a1;

import java.util.Arrays;
import java.util.Scanner;

public class Driver {

	public static final String USER_PASSWORD = "123";
	public static final int MAX_RETRIES = 12;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to the voter tracking system");
		System.out.println("Please enter the maximum number of voters: ");

		int maxVoters = Integer.parseInt(sc.nextLine());
		Voter[] voterBase = new Voter[maxVoters];
		int passErrorCount = 0;

		while (true) {
			if (passErrorCount == MAX_RETRIES) {
				System.out.println("Program detected suspicious activities and will terminate immediately!");
				System.exit(0);
			}

			System.out.println("What do you want to do?\n" + "1. Enter new voters (password required)\n"
					+ "2. Change information of a voter (password required)\n"
					+ "3. Display all voters by a specific voterPcode\n"
					+ "4. Display all voters under a certain age.\n" + "5. Quit\n" + "Please enter your choice >");
			String input = sc.nextLine();
			if (input.equals("1")) {
				int attemps = 3;
				while (attemps > 0) {
					System.out.println("Please enter the password: ");
					String pass = sc.nextLine();
					if (pass.equals(USER_PASSWORD)) {
						passErrorCount = 0;
						processVoterEnter(sc, voterBase);
						break;
					}
					attemps--;
					passErrorCount++;
				}
			} else if (input.equals("2")) {
				passErrorCount = 0;
				int attemps = 3;
				while (attemps > 0) {
					System.out.println("Please enter the password: ");
					String pass = sc.nextLine();
					if (pass.equals(USER_PASSWORD)) {
						processVoterUpdate(sc, voterBase);
						break;
					}
					attemps--;
				}
			} else if (input.equals("3")) {
				System.out.println("Enter postcode for lookup: ");
				char[] postcode = sc.nextLine().trim().toCharArray();
				Arrays.stream(voterBase).filter(voter -> Arrays.equals(voter.getVoterPcode(), postcode))
						.forEach(System.out::println);
			} else if (input.equals("4")) {
				System.out.println("Enter age for lookup: ");
				int age = Integer.parseInt(sc.nextLine());
				Arrays.stream(voterBase).filter(voter -> voter.getVoterAge() < age).forEach(System.out::println);
			} else if (input.equals("5")) {
				System.out.println("Bye!");
				System.exit(0);
			}
		}
	}

	private static void processVoterUpdate(Scanner sc, Voter[] voterBase) {
		while (true) {
			System.out.println("Enter the voter id, you wish to update: ");
			long id = Integer.parseInt(sc.nextLine());
			int index = getVoterById(voterBase, id);
			if (index == -1) {
				System.out.println("voter not found, enter: 'quit' to go back to main menu"
						+ " or 'continue' to enter another voter");
				if (sc.nextLine().trim().equals("quit")) {
					return;
				}
			} else {
				System.out.println("What information would you like to change?\n" + "1. Name\n" + "2. Age\n"
						+ "3. Email\n" + "4. PCode\n" + "5. Quit\n" + "Enter your choice >");
				int option = Integer.parseInt(sc.nextLine());
				if (option == 1) {
					System.out.println("Enter the new voter name: ");
					voterBase[index].setVoterName(sc.nextLine());
				} else if (option == 2) {
					System.out.println("Enter the new voter age: ");
					voterBase[index].setVoterAge(Byte.parseByte(sc.nextLine()));
				} else if (option == 3) {
					System.out.println("Enter the new voter email: ");
					voterBase[index].setVoterEmail(sc.nextLine());
				} else if (option == 4) {
					System.out.println("Enter the new voter postcode: ");
					voterBase[index].setVoterPcode(sc.nextLine().toCharArray());
				} else if (option == 5) {
					return;
				}
			}
		}

	}

//	print the voter by id and return the index
	private static int getVoterById(Voter[] voterBase, long id) {
		for (int i = 0; i < voterBase.length; i++) {
			if (voterBase[i].getVoterID() == id) {
				System.out.println("Voter: #" + i + "\n" + "ID: " + id + "\n" + "Name: " + voterBase[i].getVoterName()
						+ "\n" + "Age: " + voterBase[i].getVoterAge() + "\n" + "Email: " + voterBase[i].getVoterEmail()
						+ "\n" + "PCode: " + String.valueOf(voterBase[i].getVoterPcode()));
				return i;
			}
		}

		return -1;
	}

	private static void processVoterEnter(Scanner sc, Voter[] voterBase) {
		System.out.println("How many voters do you wish to enter: ");
		int voters = Integer.parseInt(sc.nextLine());
		if (voters > getEmptySpace(voterBase)) {
			voters = getEmptySpace(voterBase);
			System.out.println("You can only add the number of remaining places " + voters);
		}
		while (voters > 0) {
			System.out.println("Please enter the voter name, age, email, postcode, in following foramt:" + ""
					+ "Joe Smith,23,js@gmail.com,HHH1B1");
			if (addVoter(sc.nextLine(), voterBase)) {
				System.out.println("success added");
				voters--;
			} else {
				System.out.println("invalid input, enter again");
			}
		}
	}

	private static boolean addVoter(String nextLine, Voter[] voterBase) {
		String[] items = nextLine.split(",");
		if (items.length != 4) {
			return false;
		}

		for (int i = 0; i < voterBase.length; i++) {
			if (voterBase[i] == null) {
				voterBase[i] = new Voter(i, items[0].trim(), Byte.parseByte(items[1].trim()), items[2].trim(),
						items[3].trim().toCharArray());
				return true;
			}
		}
		return false;
	}

	private static int getEmptySpace(Voter[] voterBase) {
		int empty = 0;
		for (int i = 0; i < voterBase.length; i++) {
			if (voterBase[i] == null) {
				empty++;
			}
		}

		return empty;
	}

}
