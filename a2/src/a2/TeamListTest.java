package a2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TeamListTest {

	@Test
	void testAddToStart() {
		TeamList teamList = new TeamList();
		teamList.addToStart(new Team("teamId1", "teamName", 1, 1, 0, 1.0, 3, "group"));
		assertEquals(1, teamList.getSize());
	}

	@Test
	void testInsertAtIndex() {
		TeamList teamList = new TeamList();
		teamList.addToStart(new Team("teamId1", "teamName", 1, 1, 0, 1.0, 3, "group"));
		teamList.insertAtIndex(new Team("teamId2", "teamName", 1, 1, 0, 1.0, 3, "group"), 0);
		teamList.insertAtIndex(new Team("teamId3", "teamName", 1, 1, 0, 1.0, 3, "group"), 1);

		assertEquals(3, teamList.getSize());
		assertEquals(
				"Team [teamID=teamId2, teamName=teamName, gamesPlayed=1, gamesWon=1, gamesLost=0, netRunRate=1.0, points=3]->Team [teamID=teamId3, teamName=teamName, gamesPlayed=1, gamesWon=1, gamesLost=0, netRunRate=1.0, points=3]->Team [teamID=teamId1, teamName=teamName, gamesPlayed=1, gamesWon=1, gamesLost=0, netRunRate=1.0, points=3]->",
				teamList.toString());

		// invalid insert index
		Exception exception = assertThrows(RuntimeException.class, () -> {
			teamList.insertAtIndex(new Team("teamId3", "teamName", 1, 1, 0, 1.0, 3, "group"), 3);
		});
		assertTrue(exception.getMessage().contains("insertAtIndex"));
	}

	@Test
	void testDeleteFromIndex() {
		TeamList teamList = new TeamList();
		teamList.addToStart(new Team("teamId1", "teamName", 1, 1, 0, 1.0, 3, "group"));
		teamList.insertAtIndex(new Team("teamId2", "teamName", 1, 1, 0, 1.0, 3, "group"), 0);
		teamList.insertAtIndex(new Team("teamId3", "teamName", 1, 1, 0, 1.0, 3, "group"), 1);

		assertEquals(3, teamList.getSize());
		assertEquals(
				"Team [teamID=teamId2, teamName=teamName, gamesPlayed=1, gamesWon=1, gamesLost=0, netRunRate=1.0, points=3]->Team [teamID=teamId3, teamName=teamName, gamesPlayed=1, gamesWon=1, gamesLost=0, netRunRate=1.0, points=3]->Team [teamID=teamId1, teamName=teamName, gamesPlayed=1, gamesWon=1, gamesLost=0, netRunRate=1.0, points=3]->",
				teamList.toString());

		// delete last one
		teamList.deleteFromIndex(2);
		assertEquals(2, teamList.getSize());
		assertEquals(
				"Team [teamID=teamId2, teamName=teamName, gamesPlayed=1, gamesWon=1, gamesLost=0, netRunRate=1.0, points=3]->Team [teamID=teamId3, teamName=teamName, gamesPlayed=1, gamesWon=1, gamesLost=0, netRunRate=1.0, points=3]->",
				teamList.toString());

		// delete first one
		teamList.deleteFromIndex(0);
		assertEquals(1, teamList.getSize());
		assertEquals(
				"Team [teamID=teamId3, teamName=teamName, gamesPlayed=1, gamesWon=1, gamesLost=0, netRunRate=1.0, points=3]->",
				teamList.toString());

		// delete middle
		teamList.addToStart(new Team("teamId4", "teamName", 1, 1, 0, 1.0, 3, "group"));
		teamList.addToStart(new Team("teamId5", "teamName", 1, 1, 0, 1.0, 3, "group"));
		teamList.deleteFromIndex(1);
		assertEquals(2, teamList.getSize());
		assertEquals(
				"Team [teamID=teamId5, teamName=teamName, gamesPlayed=1, gamesWon=1, gamesLost=0, netRunRate=1.0, points=3]->Team [teamID=teamId3, teamName=teamName, gamesPlayed=1, gamesWon=1, gamesLost=0, netRunRate=1.0, points=3]->",
				teamList.toString());

		// invalid delete index
		Exception exception = assertThrows(RuntimeException.class, () -> {
			teamList.deleteFromIndex(2);
		});
		assertTrue(exception.getMessage().contains("deleteFromIndex"));
	}

	@Test
	void testDeleteFromStart() {
		TeamList teamList = new TeamList();
		teamList.addToStart(new Team("teamId1", "teamName", 1, 1, 0, 1.0, 3, "group"));

		teamList.deleteFromStart();
		assertEquals(0, teamList.getSize());

		Exception exception = assertThrows(RuntimeException.class, () -> {
			teamList.deleteFromStart();
		});
		assertTrue(exception.getMessage().contains("deleteFromStart"));
	}

	@Test
	void testReplaceAtIndex() {
		TeamList teamList = new TeamList();
		teamList.addToStart(new Team("teamId1", "teamName", 1, 1, 0, 1.0, 3, "group"));
		teamList.addToStart(new Team("teamId2", "teamName", 1, 1, 0, 1.0, 3, "group"));

		teamList.replaceAtIndex(new Team("teamId3", "teamName", 1, 1, 0, 1.0, 3, "group"), 0);
		teamList.replaceAtIndex(new Team("teamId4", "teamName", 1, 1, 0, 1.0, 3, "group"), 1);
		assertEquals(
				"Team [teamID=teamId3, teamName=teamName, gamesPlayed=1, gamesWon=1, gamesLost=0, netRunRate=1.0, points=3]->Team [teamID=teamId4, teamName=teamName, gamesPlayed=1, gamesWon=1, gamesLost=0, netRunRate=1.0, points=3]->",
				teamList.toString());
		// replace invalid index
		teamList.replaceAtIndex(new Team("teamId4", "teamName", 1, 1, 0, 1.0, 3, "group"), 2);
		assertEquals(
				"Team [teamID=teamId3, teamName=teamName, gamesPlayed=1, gamesWon=1, gamesLost=0, netRunRate=1.0, points=3]->Team [teamID=teamId4, teamName=teamName, gamesPlayed=1, gamesWon=1, gamesLost=0, netRunRate=1.0, points=3]->",
				teamList.toString());
	}

	@Test
	void testContains() {
		TeamList teamList = new TeamList();
		teamList.addToStart(new Team("teamId1", "teamName", 1, 1, 0, 1.0, 3, "group"));
		assertTrue(teamList.contains("teamId1"));
		assertFalse(teamList.contains("team"));
	}

	@Test
	void testFind() {
		TeamList teamList = new TeamList();
		teamList.addToStart(new Team("teamId1", "teamName", 1, 1, 0, 1.0, 3, "group"));
		assertEquals("teamName", teamList.find("teamId1").getTeam().getTeamName());
		assertEquals(null, teamList.find("team"));
	}

	@Test
	void testEquals() {
		TeamList teamList1 = new TeamList();
		teamList1.addToStart(new Team("teamId1", "teamName", 1, 1, 0, 1.0, 3, "group1"));

		TeamList teamList2 = new TeamList();
		teamList2.addToStart(new Team("teamId2", "teamName", 1, 1, 0, 1.0, 3, "group2"));

		assertTrue(teamList1.equals(teamList2));
		teamList2.addToStart(new Team("teamId3", "teamName", 1, 1, 0, 1.0, 3, "group2"));
		assertFalse(teamList1.equals(teamList2));
	}
}
