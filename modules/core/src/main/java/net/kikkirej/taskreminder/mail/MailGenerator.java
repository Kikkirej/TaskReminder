package net.kikkirej.taskreminder.mail;

import java.io.IOException;

import net.kikkirej.taskreminder.model.MailObject;
import net.kikkirej.taskreminder.model.MappingObject;
import net.kikkirej.taskreminder.model.TaskObject;

public class MailGenerator {

	
	private MailObject mailObject;

	public MailGenerator() {
		mailObject = new MailObject();
		
	}
	
	public MailObject getNewUserMail(TaskObject taskObject) throws IOException {
		//DONE message
		//DONE 
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
