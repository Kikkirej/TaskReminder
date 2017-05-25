package net.kikkirej.taskreminder.mail;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import net.kikkirej.taskreminder.mail.plcaeholder.Placeholder;

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
	public void getSubjectTest() throws Exception{
		//Arrange
		String expected = "empty String";
		//Act
		String actual = mailSubjectGenerator.getSubject(expected);
		//Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void handlePlaceholderTest() throws Exception{
		Placeholder placeholder = Mockito.mock(Placeholder.class);
		String expected = "erwartet";
		when(placeholder.replacePlatzhalter((String) any())).thenReturn(expected);
		mailSubjectGenerator.addPlaceholder(placeholder);
		String actual = mailSubjectGenerator.handlePlaceholder(expected);
		assertEquals(expected, actual);
		verify(placeholder).replacePlatzhalter((String) any());
	}

}
