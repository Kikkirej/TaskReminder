package net.kikkirej.taskreminder.mail.recipents;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.commons.mail.Email;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MainRecipentCommandTest {

	MainRecipentCommand mainRecipentCommand;
	
	@Mock
	Email mail;
	
	@Before
	public void setUp() throws Exception {
		mainRecipentCommand = new MainRecipentCommand();
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testAdd() throws Exception{
		//Arrange
		when(mail.addTo(anyString())).thenReturn(null);
		//Act
		mainRecipentCommand.add(mail, "dies ist die Testmail");
		//Assert
		verify(mail).addTo("dies ist die Testmail");
	}

}
