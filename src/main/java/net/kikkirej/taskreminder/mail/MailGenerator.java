package net.kikkirej.taskreminder.mail;

import java.io.IOException;

import net.kikkirej.taskreminder.model.MailObject;
import net.kikkirej.taskreminder.model.MappingObject;
import net.kikkirej.taskreminder.model.TaskObject;
import net.kikkirej.taskreminder.util.FileReader;

public class MailGenerator {

	MailObject mail = new MailObject();
	
	public MailObject getNewUserMail(TaskObject taskObject) {
		//Pfad und admin erfährt man aus der Konfigdatei
		String path = "";
		String admin = "";
		//Pfad zur jeweiligen Vorlage wird übergeben und das Resultat in der Message der Mail gespeichert
		mail.Message = new MessageGenerator().holeDaten(path);
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
	
	

}
