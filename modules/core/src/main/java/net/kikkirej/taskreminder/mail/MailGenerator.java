package net.kikkirej.taskreminder.mail;

import java.io.IOException;

import net.kikkirej.taskreminder.mail.plcaeholder.PlaceholderTask;
import net.kikkirej.taskreminder.mail.plcaeholder.PlaceholderUser;
import net.kikkirej.taskreminder.model.MailObject;
import net.kikkirej.taskreminder.model.MappingObject;
import net.kikkirej.taskreminder.model.TaskObject;
import net.kikkirej.taskreminder.preferences.PreferenceKeys;
import net.kikkirej.taskreminder.preferences.PreferenceManagerSingleton;
import net.kikkirej.taskreminder.util.DefaultFileReader;

public class MailGenerator {

	
	private MailObject mailObject;

	public MailGenerator() {
		mailObject = new MailObject();
		
	}
	
	public MailObject getNewUserMail(TaskObject taskObject) throws IOException {
		String mailUnknownUserPath = PreferenceManagerSingleton.getInstance().get(PreferenceKeys.MAILTEXTUNKOWNUSERPATH);
		DefaultFileReader defaultFileReader = new DefaultFileReader(mailUnknownUserPath);
		MailTextGenerator mailTextGenerator = new MailTextGenerator(defaultFileReader);
		mailTextGenerator.addPlaceholder(new PlaceholderTask(taskObject));
		mailTextGenerator.addPlaceholder(new PlaceholderUser(taskObject));
		mailObject.message = mailTextGenerator.getText();
		return mailObject;
	}

	public MailObject getSimpleReminder(MappingObject mapping, String taskname) {
		// TODO Auto-generated method stub
		return null;
		
	}

	public MailObject getAlertmail(TaskObject taskObject) {
		// noch hostname
		return null;
		
	}
	
	

}
