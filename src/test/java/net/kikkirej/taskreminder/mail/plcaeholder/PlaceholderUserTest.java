package net.kikkirej.taskreminder.mail.plcaeholder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import net.kikkirej.taskreminder.model.TaskObject;

public class PlaceholderUserTest {
	
	//SUT
	PlaceholderUser placeholderUser;

	@Test
	public void test() {
		TaskObject taskObject = new TaskObject();
		taskObject.personname = "Personenname";
		placeholderUser = new PlaceholderUser(taskObject);
		String resultingText = placeholderUser.replacePlatzhalter("The user is {USER}");
		assertEquals("The user is Personenname", resultingText);
	}

}
