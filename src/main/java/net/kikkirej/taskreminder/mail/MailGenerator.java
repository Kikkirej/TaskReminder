package net.kikkirej.taskreminder.mail;

import java.io.IOException;

import net.kikkirej.taskreminder.model.MailObject;
import net.kikkirej.taskreminder.model.MappingObject;
import net.kikkirej.taskreminder.model.TaskObject;
import net.kikkirej.taskreminder.util.FileReader;

public class MailGenerator {

	MailObject mail = new MailObject();
	FileReader file;
	String pathPlaceholder;
	
	public MailObject getNewUserMail(TaskObject taskObject) {
		String path = "";
		String admin = "";
		mail.Message = erzeugeMessage(path);
		//Empfänger ist der, der in der Konfig als Admin eingetragen ist
		mail.recipents.add(admin);
		return mail;
	}

	public MailObject getSimpleReminder(MappingObject mapping, String taskname) {
		// TODO Auto-generated method stub
		return null;
		
	}

	public MailObject getAlertmail(TaskObject taskObject) {
		// noch hostname
		return null;
		
	}
	
	private String erzeugeMessage(String path) {
		String message;
		try {
			message = new FileReader("path").getAllText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "";
		}
		return ersetzePlatzhalter(message);
	}

	public String ersetzePlatzhalter(String message) {
		String platzhalter;
		try {
			platzhalter = new FileReader(pathPlaceholder).getAllText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		platzhalter = "";
		return message;
	}

}
