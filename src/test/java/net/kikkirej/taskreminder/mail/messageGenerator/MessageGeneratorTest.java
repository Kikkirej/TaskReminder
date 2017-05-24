package net.kikkirej.taskreminder.mail.messageGenerator;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import net.kikkirej.taskreminder.mail.MessageGenerator;

public class MessageGeneratorTest {

MessageGenerator messageGenerator;
	
	@Before
	public void setUp() throws Exception {
		messageGenerator = new MessageGenerator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void holeDatenTest() throws Exception{
		
	}
	
	@Test
	public void verarbeitePlatzhalterTest() throws Exception{
		//Arrange
		String[] platzhalterArray={"PERSONNAME", "TASKNAME"};
		String platzhalter = "PERSONNAME\nTASKNAME";
		//Act
		ArrayList<String> expected= messageGenerator.verarbeitePlatzhalter(platzhalter);
		//Assert
		assertEquals(expected, platzhalter);	
	}
	
	@Test
	public void ersetzePlatzhalterTest() throws Exception{
		
	}

}
