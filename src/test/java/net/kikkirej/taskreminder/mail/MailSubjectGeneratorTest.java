package net.kikkirej.taskreminder.mail;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MailSubjectGeneratorTest {

	MailSubjectGenerator mailSubjectGenerator;
	
	@Before
	public void setUp() throws Exception {
		mailSubjectGenerator = new MailSubjectGenerator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getSubjectTest() {
		//Arrange
		String expected = "empty String";
		//Act
		String actual = mailSubjectGenerator.getSubject(expected);
		//Assert
		assertEquals(expected, actual);
	}

}
