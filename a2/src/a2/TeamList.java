/*
 * Name and ID: Yan Ren 40212201
 * Assignment #2
 * Due Date: November 27, 2022
 */
package a2;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TeamList {

	public class TeamNode implements Cloneable {
		private Team team;
		private TeamNode next;

		public TeamNode() {
			super();
		}

		public TeamNode(Team team, TeamNode next) {
			super();
			this.team = team;
			this.next = next;
		}

		public TeamNode(TeamNode node) {
			this.team = node.team;
			this.next = node.next;
		}

		@Override
		public TeamNode clone() throws CloneNotSupportedException {
			TeamNode clonedObj = (TeamNode) super.clone();
			clonedObj.team = (Team) this.team.clone();
			clonedObj.next = this.next.clone();
			return clonedObj;
		}

		public Team getTeam() {
			return team;
		}

		public void setTeam(Team team) {
			this.team = team;
		}

		public TeamNode getNext() {
			return next;
		}

		public void setNext(TeamNode next) {
			this.next = next;
		}
	}

	private TeamNode head;
	private int size;

	public TeamList() {
		head = null;
		size = 0;
	}

	public TeamList(TeamList l) throws CloneNotSupportedException {
		this.head = l.head.clone();
		this.size = l.size;
	}

	public void addToStart(Team value) {
		TeamNode newNode = new TeamNode();
		newNode.team = value;
		newNode.next = head;
		head = newNode;
		size++;
	}

	/**
	 * 
	 * If the index is not valid (a valid index must have a value between zero and
	 * size-1), then the method must throw a NoSuchElementException and terminates
	 * the program. If index is valid, then the method creates a node with passed
	 * Team object and inserts this node at the given index.
	 * 
	 * @param team
	 * @param index
	 */
	public void insertAtIndex(Team team, int index) {
		if (index < 0 || index > size - 1) {
			throw new NoSuchElementException("insertAtIndex");
		}
		TeamNode newNode = new TeamNode();
		newNode.team = team;

		// insert as the new head
		if (index == 0) {
			newNode.next = head;
			head = newNode;
		} else {
			// The 2nd case.
			// start from the head:
			TeamNode node = head;
			// find position just before the expected one:
			while (--index > 0) {
				node = node.next;
			}
			// insert the new node:
			newNode.next = node.next;
			node.next = newNode;
		}
		size++;
	}

	/**
	 * If index is not valid, method must throw a NoSuchElementException and
	 * terminate the program. Otherwise, node pointed by that index is deleted from
	 * the list.
	 * 
	 * @param index
	 */
	public void deleteFromIndex(int index) {
		if (head == null || index < 0 || index > size - 1)
			throw new NoSuchElementException("deleteFromIndex");

		TeamNode temp = head;
		if (index == 0) {
			head = temp.next;
			size--;
			return;
		}
		for (int i = 0; temp != null && i < index - 1; i++)
			temp = temp.next;
		if (temp == null || temp.next == null)
			return;
		TeamNode next1 = temp.next.next;

		temp.next = next1;
		size--;
	}

	/**
	 * Deletes the first node in the list (the one pointed by head)
	 */
	public void deleteFromStart() {
		if (size == 0) {
			throw new NoSuchElementException("deleteFromStart");
		}

		TeamNode temp = head;
		head = head.next;
		temp.next = null;
		size--;
	}

	/**
	 * If index is not valid, the method simply returns; otherwise, object in list
	 * at passed index must be replaced with the object passed.
	 * 
	 * @param team
	 * @param index
	 */
	public void replaceAtIndex(Team team, int index) {
		if (index < 0 || index > size - 1) {
			return;
		}

		// start from the head:
		TeamNode node = head;
		while (index > 0) {
			node = node.next;
			index--;
		}
		// replace the object
		node.team = team;
	}

	/**
	 * If such an object is found, then method returns a pointer to that teamNode;
	 * otherwise, method returns null.
	 * 
	 * @param teamID
	 * @return
	 */
	public TeamNode find(String teamID) {
		TeamNode node = head;
		int iteration = 0;
		while (node != null) {
			if (node.team.getTeamID().equals(teamID)) {
				System.out.println("find method iteration: " + iteration);
				return node;
			}

			node = node.next;
			iteration++;
		}

		System.out.println("find method iteration: " + iteration);
		return node;
	}

	/**
	 * Method returns true if a team with that teamID is in the list; otherwise, the
	 * method returns false
	 * 
	 * @param teamID
	 * @return
	 */
	public boolean contains(String teamID) {
		TeamNode node = head;
		while (node != null) {
			if (node.team.getTeamID().equals(teamID)) {
				return true;
			}

			node = node.next;
		}

		return false;
	}

	public boolean contains(Team t) {
		TeamNode node = head;
		while (node != null) {
			if (node.team.equals(t)) {
				return true;
			}

			node = node.next;
		}

		return false;
	}

	public boolean equals(TeamList t2) {
		if (size != t2.size) {
			return false;
		}

		TeamNode node1 = head;
		TeamNode node2 = t2.head;
		while (node1 != null) {
			if (!node1.team.equals(node2.team)) {
				return false;
			}

			node1 = node1.next;
			node2 = node2.next;
		}

		return true;
	}

	public ArrayList<Team> toArrayList() {
		ArrayList<Team> list = new ArrayList<>();
		TeamNode node = head;
		while (node != null) {
			list.add(node.team);
			node = node.next;
		}

		return list;
	}

	@Override
	public String toString() {
		String s = "";
		TeamNode node = head;
		while (node != null) {
			s += node.team + "->";
			node = node.next;
		}

		return s;
	}

	public int getSize() {
		return size;
	}
}
