package net.kikkirej.taskreminder.network;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HostcheckerTest {

	Hostchecker hostchecker;

	@Test
	public void isHostOnlineTestLocalhost() {
		hostchecker = new Hostchecker("localhost");
		boolean actual = hostchecker.isHostOnline();
		assertTrue(actual);
	}
	
	@Test
	public void isHostOnlineTestOther() {
		hostchecker = new Hostchecker("198.0.1.11");
		hostchecker.setTimeout(300);
		boolean actual = hostchecker.isHostOnline();
		assertFalse(actual);
	}
	
	@Test
	public void isHostOnlineTestOtherHostname() {
		hostchecker = new Hostchecker("abcdefgh");
		hostchecker.setTimeout(300);
		boolean actual = hostchecker.isHostOnline();
		assertFalse(actual);
	}
}
