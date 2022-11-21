/*
 * Name and ID: Yan Ren 40212201
 * Assignment #2
 * Due Date: November 27, 2022
 */
package a2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
ENGLAND 5 4 1 +2.464 8
AUSTRALIA 5 4 1 +1.216 8
SOUTH_AFRICA 5 4 1 +0.739 8
SRI_LANKA 5 2 3 -0.269 4
WEST_INDIES 5 1 4 -1.641 2
BANGLADESH 5 0 5 -2.383 0

PAKISTAN 5 5 0 +1.583 10
NEW_ZEALAND 5 4 1 +1.162 8
INDIA 5 3 2 +1.747 6
AFGHANISTAN 5 2 3 +1.053 4
NAMIBIA 5 1 4 -1.890 2
SCOTLAND 5 0 5 -3.543 0

TeamName, number of matches played, number of matches won, number
of matches lost, net runrate, and number of points

Figure 2
AUSTRALIA
NEW_ZEALAND
 */
public class TournamentResults {

	public static int teamID = 0;

	public static void main(String[] args) {
		TeamList t1 = new TeamList();
		TeamList t2 = new TeamList();

		populateList(t1, "Group A");
		populateList(t2, "Group B");

		ArrayList<Team> l1 = t1.toArrayList();
		ArrayList<Team> l2 = t2.toArrayList();
		Collections.sort(l1);
		Collections.sort(l2);
//		System.out.println(l1);
//		System.out.println(l2);
		processRequestInformation(l1, l2);

		processRequestSearchTeamByID(t1, t2);
	}

	public static void processRequestSearchTeamByID(TeamList t1, TeamList t2) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter teamID for search: ");
		String teamID = sc.nextLine().trim();
		while (!teamID.equals("")) {
			if (t1.contains(teamID)) {
				System.out.println(t1.find(teamID).getTeam());
			} else if (t2.contains(teamID)) {
				System.out.println(t2.find(teamID).getTeam());
			} else {
				System.out.println("TeamID: " + teamID + " not found");
			}
			teamID = sc.nextLine().trim();
		}
	}

	public static void processRequestInformation(ArrayList<Team> l1, ArrayList<Team> l2) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Request for team outcome:");
		String input = sc.nextLine().trim();
		while (!input.equals("")) {
			if (teamRank(l1, input) != -1) {
				printOutcome(l1, teamRank(l1, input), input);
			} else if (teamRank(l2, input) != -1) {
				printOutcome(l2, teamRank(l2, input), input);
			} else {
				System.out.println("Team: " + input + " not found");
			}
			input = sc.nextLine().trim();
		}
	}

	public static void printOutcome(ArrayList<Team> teams, int rank, String teamName) {
		if (rank == 0 || rank == 1) {
			if (teams.get(2).getPoints() < teams.get(rank).getPoints()) {
				System.out.println("Team " + teamName
						+ " qualifies for the second round as it has more points than four other teams.");
			} else {
				System.out.println(
						"Team " + teamName + " qualifies for the second round as it has a higher net run rate.");
			}
		} else {
			if (teams.get(1).getPoints() == teams.get(rank).getPoints()) {
				System.out.println("Team " + teamName
						+ " can’t qualify for the second round as it doesn’t have high enough run rate.");
			} else {
				System.out.println(
						"Team " + teamName + " can’t qualify for the second round as it doesn’t have enough points.");
			}
		}
	}

	public static int teamRank(ArrayList<Team> teams, String teamName) {
		for (int i = 0; i < teams.size(); i++) {
			if (teams.get(i).getTeamName().equals(teamName)) {
				return i;
			}
		}

		return -1;
	}

	public static void populateList(TeamList t, String groupName) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input team information for " + groupName);

		String input = sc.nextLine();
		while (!input.trim().equals("")) {
			String[] items = input.split(" ");
			if (items.length != 6) {
				System.out.println("Invalid input: " + input);
				return;
			}
			Team newTeam = new Team(Integer.toString(TournamentResults.teamID), items[0], Integer.parseInt(items[1]),
					Integer.parseInt(items[2]), Integer.parseInt(items[3]), Double.parseDouble(items[4]),
					Integer.parseInt(items[5]), groupName);
			if (!t.contains(newTeam)) {
				t.addToStart(newTeam);
			} else {
				System.out.println("Duplicate input: " + newTeam);
			}

			input = sc.nextLine();
			TournamentResults.teamID++;
		}
	}
}
