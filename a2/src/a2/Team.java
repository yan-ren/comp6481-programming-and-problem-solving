/*
 * Name and ID: Yan Ren 40212201
 * Assignment #2
 * Due Date: November 27, 2022
 */
package a2;

import java.util.Objects;
import java.util.Scanner;

public class Team implements Groupable, Cloneable, Comparable<Team> {

	private String teamID;
	private String teamName;
	private int gamesPlayed;
	private int gamesWon;
	private int gamesLost;
	private double netRunRate;
	private int points;
	private String group;

	public Team(String teamID, String teamName, int gamesPlayed, int gamesWon, int gamesLost, double netRunRate,
			int points, String group) {
		super();
		this.teamID = teamID;
		this.teamName = teamName;
		this.gamesPlayed = gamesPlayed;
		this.gamesWon = gamesWon;
		this.gamesLost = gamesLost;
		this.netRunRate = netRunRate;
		this.points = points;
		this.group = group;
	}

	public Team(Team team, String teamID) {
		this.teamID = teamID;
		this.teamName = team.teamName;
		this.gamesPlayed = team.gamesPlayed;
		this.gamesWon = team.gamesWon;
		this.gamesLost = team.gamesLost;
		this.netRunRate = team.netRunRate;
		this.points = team.points;
	}

	public String getTeamID() {
		return teamID;
	}

	public void setType(String teamID) {
		this.teamID = teamID;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public int getGamesWon() {
		return gamesWon;
	}

	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}

	public int getGamesLost() {
		return gamesLost;
	}

	public void setGamesLost(int gamesLost) {
		this.gamesLost = gamesLost;
	}

	public double getNetRunRate() {
		return netRunRate;
	}

	public void setNetRunRate(double netRunRate) {
		this.netRunRate = netRunRate;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public boolean isInTheGroup(Team t) {
		if (this.group == "" || t.group == "") {
			return false;
		}
		return group.equals(t.group);
	}

	@Override
	public Object clone() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new team ID:");
		String teamID = sc.nextLine();
		sc.close();
		return new Team(this, teamID);
	}

	@Override
	public String toString() {
		return "Team [teamID=" + teamID + ", teamName=" + teamName + ", gamesPlayed=" + gamesPlayed + ", gamesWon="
				+ gamesWon + ", gamesLost=" + gamesLost + ", netRunRate=" + netRunRate + ", points=" + points + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(gamesLost, gamesPlayed, gamesWon, netRunRate, points, teamName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Team other = (Team) obj;
		return gamesLost == other.gamesLost && gamesPlayed == other.gamesPlayed && gamesWon == other.gamesWon
				&& Double.doubleToLongBits(netRunRate) == Double.doubleToLongBits(other.netRunRate)
				&& points == other.points && Objects.equals(teamName, other.teamName);
	}

	@Override
	public int compareTo(Team o) {
		if (Integer.compare(o.points, this.points) != 0) {
			return Integer.compare(o.points, this.points);
		}
		return Double.compare(o.netRunRate, this.netRunRate);
	}
}
