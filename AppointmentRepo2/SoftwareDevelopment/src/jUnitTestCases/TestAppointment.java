package jUnitTestCases;

import sourceCode.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAppointment {

	@Test
	public void testSetID() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPatName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNotes() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDate() {
		fail("Not yet implemented");
	}
	
	public void testID() {
		
		Appointment tester1 = new Appointment();
		String id = tester1.getID();
		assertEquals(id, "1" );
	}
	
	public void testPatName() {
		
		Appointment tester2 = new Appointment();
		String patName = tester2.getPatName();
		assertEquals(patName, "Mr Sick");
	}
	
	public void testNotes() {
		
		Appointment tester3 = new Appointment();
		String notes = tester3.getPatName();
		assertEquals(notes, "notenotenote");
	}
	
	public void testDate() {
		
		Appointment tester4 = new Appointment();
		String date = tester4.getDate();
		assertNotNull(date);
	}

}
