package net.kikkirej.taskreminder.mail.plcaeholder;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import net.kikkirej.taskreminder.model.TaskObject;

public class PlaceholderTaskTest {

	PlaceholderTask placeholderTask;

	@Test
	public void replacePlatzhalterTest() {
		//Arrange
		TaskObject taskObject = new TaskObject();
		taskObject.taskname = "Zentrale";
		placeholderTask = new PlaceholderTask(taskObject);
		String text = "Die ist ein Beispieltask, {TASK}";
		String expectedText = "Die ist ein Beispieltask, Zentrale";
		String actualText = "";
		//Act
		actualText = placeholderTask.replacePlatzhalter(text);
		//Assert
		assertEquals(expectedText, actualText);
	}

}
