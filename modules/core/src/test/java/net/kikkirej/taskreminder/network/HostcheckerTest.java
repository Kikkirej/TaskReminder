package net.kikkirej.taskreminder.network;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HostcheckerTest {

	Hostchecker hostchecker;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void isHostOnlineTestLocalhost() {
		hostchecker = new Hostchecker("localhost");
		boolean expected = true;
		boolean actual = hostchecker.isHostOnline();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void isHostOnlineTestOther() {
		hostchecker = new Hostchecker("198.0.1.11");
		boolean expected = false;
		boolean actual = hostchecker.isHostOnline();
		
		assertEquals(expected, actual);
	}

}
