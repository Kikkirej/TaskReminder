package net.kikkirej.taskreminder.mail.recipents;

import static org.mockito.Mockito.*;

import org.apache.commons.mail.Email;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CCRecipentCommandTest {

	CCRecipentCommand ccrecipentcommand;
	
	@Mock
	Email mailMock;
	
	@Before
	public void setUp() throws Exception {
		ccrecipentcommand= new CCRecipentCommand();
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addTotest() throws Exception{
		//Arrange
		String recipent = "testtest";
		when(mailMock.addCc(recipent)).thenReturn(null);
		//Act
		ccrecipentcommand.add(mailMock, recipent);
		//Assert
		verify(mailMock).addCc(recipent);
	}

}
