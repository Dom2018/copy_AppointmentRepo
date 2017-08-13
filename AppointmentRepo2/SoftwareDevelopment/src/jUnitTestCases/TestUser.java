package jUnitTestCases;

import sourceCode.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUser {

	@Test
	public void testAddAppointment() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAppointment() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNewNotes() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveAppointment() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAppointments() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetID() {
		
		User tester1 = new User("2", "Eric", "eric", "Eric L");
		assertEquals("2", tester1.getID());
	}
}
