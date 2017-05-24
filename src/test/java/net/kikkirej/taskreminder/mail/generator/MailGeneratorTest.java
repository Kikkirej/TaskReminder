package net.kikkirej.taskreminder.mail.generator;

import static org.junit.Assert.*;

import org.apache.commons.mail.Email;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import net.kikkirej.taskreminder.mail.MailGenerator;
import net.kikkirej.taskreminder.model.MailObject;
import net.kikkirej.taskreminder.model.TaskObject;

public class MailGeneratorTest {

	MailGenerator mailGenerator;
	
	@Before
	public void setUp() throws Exception {
		mailGenerator = new MailGenerator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getNewUserMailTest() throws Exception{
		//Arrange
		String message="blablabla";
		TaskObject task = new TaskObject();
		//Act
		MailObject expected = mailGenerator.getNewUserMail(task);
		//Assert
		assertEquals(expected.Message, message);
	}
	
	
	@Test
	public void ersetzePlatzhalterTest() throws Exception{
		//Arrange
		String message="Es ist ein unbekannter User vorhanden \n Kudo";
		
		String platzhalter="Username";
		String eingabe="Es ist ein unbekannter User vorhanden \n PERSONENNAME";
		//Act
		String expected = "bla"; //mailGenerator.ersetzePlatzhalter(eingabe, platzhalter);
		//Assert
		assertEquals(expected, message);
	}

}
