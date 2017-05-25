package net.kikkirej.taskreminder;

import java.io.IOException;

import org.apache.commons.mail.EmailException;

import net.kikkirej.taskreminder.mail.MailClient;
import net.kikkirej.taskreminder.mail.MailGenerator;
import net.kikkirej.taskreminder.model.MailObject;
import net.kikkirej.taskreminder.model.MappingObject;
import net.kikkirej.taskreminder.model.TaskObject;
import net.kikkirej.taskreminder.network.Hostchecker;
import net.kikkirej.taskreminder.preferences.mapping.MappingManager;

public class TaskRunner implements Runnable {


	private MappingObject mapping;
	private TaskObject taskObject;

	public TaskRunner(TaskObject taskObject) {
		this.taskObject = taskObject;
		mapping = MappingManager.getInstance().getMapping(taskObject.personname);
	}

	public void run() {
		try {
			MailObject mail = getMail();
			MailClient mailClient = new MailClient();
			mailClient.sendMail(mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private MailObject getMail() throws IOException {
		MailGenerator mailGenerator = new MailGenerator();
		if(mapping == null){
			return mailGenerator.getNewUserMail(taskObject);
		}
		Hostchecker hostchecker = new Hostchecker(mapping.hostname);
		if(hostchecker.isHostOnline()){
			return mailGenerator.getSimpleReminder(mapping, taskObject.taskname);
		}else{
			return mailGenerator.getAlertmail(taskObject);
		}
	}

}
