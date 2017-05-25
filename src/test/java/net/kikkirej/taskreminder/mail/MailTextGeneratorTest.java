package net.kikkirej.taskreminder.mail;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import net.kikkirej.taskreminder.mail.plcaeholder.Placeholder;
import net.kikkirej.taskreminder.util.FileReader;

public class MailTextGeneratorTest {

	//SUT
	MailTextGenerator mailTextGenerator;
	
	@Mock
	FileReader fileReader;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mailTextGenerator = new MailTextGenerator(fileReader);
	}

	@After
	public void tearDown() throws Exception {
		mailTextGenerator = null;
	}


	@Test
	public void getTextTest() throws Exception{
		//Arrange
		String resultText = null;
		String testText = "Dies ist der Testext";
		when(fileReader.getAllText()).thenReturn(testText);
		//Act
		resultText = mailTextGenerator.getText();
		//Assert
		verify(fileReader,times(1)).getAllText();
		assertEquals(testText, resultText);
	}

	@Test
	public void getText2Test() throws Exception{
		//Arrange
		String resultText = null;
		String testText = "Dies ist ein anderer Testext";
		when(fileReader.getAllText()).thenReturn(testText);
		//Act
		resultText = mailTextGenerator.getText();
		//Assert
		verify(fileReader,times(1)).getAllText();
		assertEquals(testText, resultText);
	}
	
	@Test
	public void getTextWithPlaceholder() throws Exception{
		//Arrange
		Placeholder placeholder = Mockito.mock(Placeholder.class);
		String expected = "richtiger Text";
		when(placeholder.replacePlatzhalter((String) any())).thenReturn(expected);
		mailTextGenerator.addPlaceholder(placeholder);
		//Act
		String resultingText = mailTextGenerator.getText();
		//Assert
		assertEquals(expected, resultingText);
		verify(placeholder).replacePlatzhalter((String) any());
	}
	
}
