package net.kikkirej.taskreminder.mail.recipents;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import net.kikkirej.taskreminder.preferences.mapping.MappingManager;

public class RecipentHandlerNewUserMailTest {

	RecipentHandlerNewUserMail recipentHandlerNewUserMail; 
	
	@Mock
	MappingManager mappingMock;
	
	@Before
	public void setUp() throws Exception {
		recipentHandlerNewUserMail = new RecipentHandlerNewUserMail();
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getRecipentsTest() {
		
//		assertEquals(expected, actual);
//		verify().
	}

}
