package a2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

class TeamTest {
	private ByteArrayInputStream testIn;

	private void provideInput(String data) {
		testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
	}

	@Test
	void testIsInTheGroup() {
		Team t1 = new Team(null, null, 0, 0, 0, 0, 0, "group1");
		Team t2 = new Team(null, null, 0, 0, 0, 0, 0, "group1");
		assertTrue(t1.isInTheGroup(t2));
	}

	@Test
	void testClone() {
		Team t1 = new Team("teamId1", "teamName", 1, 1, 0, 1.0, 3, "group");
		String testInput = "teamId2";
		provideInput(testInput);

		Team t2 = (Team) t1.clone();
		assertEquals(testInput, t2.getTeamID());
		assertTrue(t1.equals(t2));
	}
}
