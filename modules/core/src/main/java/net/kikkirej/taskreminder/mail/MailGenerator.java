package net.kikkirej.taskreminder.mail;

import static net.kikkirej.taskreminder.preferences.PreferenceKeys.MAILSUBJECTALERT;
import static net.kikkirej.taskreminder.preferences.PreferenceKeys.MAILSUBJECTREMINDER;
import static net.kikkirej.taskreminder.preferences.PreferenceKeys.MAILSUBJECTUNKOWNUSER;
import static net.kikkirej.taskreminder.preferences.PreferenceKeys.MAILTEXTALERTPATH;
import static net.kikkirej.taskreminder.preferences.PreferenceKeys.MAILTEXTREMINDERPATH;
import static net.kikkirej.taskreminder.preferences.PreferenceKeys.MAILTEXTUNKOWNUSERPATH;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import net.kikkirej.taskreminder.mail.plcaeholder.Placeholder;
import net.kikkirej.taskreminder.mail.plcaeholder.PlaceholderTask;
import net.kikkirej.taskreminder.mail.plcaeholder.PlaceholderUser;
import net.kikkirej.taskreminder.mail.recipentadder.AdminmailAdder;
import net.kikkirej.taskreminder.mail.recipentadder.AllMappingsAdder;
import net.kikkirej.taskreminder.mail.recipentadder.CCMailAdder;
import net.kikkirej.taskreminder.mail.recipentadder.SingleMappingAdder;
import net.kikkirej.taskreminder.model.MailObject;
import net.kikkirej.taskreminder.model.MappingObject;
import net.kikkirej.taskreminder.model.TaskObject;
import net.kikkirej.taskreminder.preferences.PreferenceManagerSingleton;
import net.kikkirej.taskreminder.util.DefaultFileReader;
import net.kikkirej.taskreminder.util.FileReader;

public class MailGenerator {

	private MailObject mailObject;

	public MailGenerator() {
		mailObject = new MailObject();
		MailServerGenerator mailServerGenerator = new MailServerGenerator();
		mailObject.mailserver = mailServerGenerator.getServer();
	}

	public MailObject getNewUserMail(TaskObject taskObject) throws Exception {
		generateBodyAndText(taskObject, MAILSUBJECTUNKOWNUSER, MAILTEXTUNKOWNUSERPATH);
		new AdminmailAdder(mailObject.recipents).run();
		new AllMappingsAdder(mailObject.cc).run();
		new CCMailAdder(mailObject.cc).run();
		return mailObject;
	}

	public MailObject getSimpleReminder(MappingObject mapping, TaskObject taskObject) throws Exception {
		generateBodyAndText(taskObject, MAILSUBJECTREMINDER, MAILTEXTREMINDERPATH);
		new SingleMappingAdder(mailObject.recipents, mapping);
		new CCMailAdder(mailObject.cc);
		return mailObject;

	}

	public MailObject getAlertmail(TaskObject taskObject) throws Exception {
		generateBodyAndText(taskObject, MAILSUBJECTALERT, MAILTEXTALERTPATH);
		new AllMappingsAdder(mailObject.recipents);
		new CCMailAdder(mailObject.cc);
		return mailObject;

	}

	private void generateBodyAndText(TaskObject taskObject, String keySubject, String keyPathToTemplate)
			throws FileNotFoundException, IOException {
		mailObject.subject = getSubjectOfKey(keySubject, taskObject);
		MailTextGenerator mailTextGenerator = new MailTextGenerator(getReaderForKey(keyPathToTemplate));
		mailTextGenerator.addPlaceholder(getPlaceholder(taskObject));
		mailObject.message = mailTextGenerator.getText();
	}

	private String getSubjectOfKey(String key, TaskObject taskObject) {
		String subject = PreferenceManagerSingleton.getInstance().get(key);
		MailSubjectGenerator mailSubjectGenerator = new MailSubjectGenerator();
		mailSubjectGenerator.addPlaceholder(getPlaceholder(taskObject));
		return mailSubjectGenerator.getSubject(subject);
	}

	private Collection<Placeholder> getPlaceholder(TaskObject taskObject) {
		ArrayList<Placeholder> arrayList = new ArrayList<Placeholder>();
		arrayList.add(new PlaceholderTask(taskObject));
		arrayList.add(new PlaceholderUser(taskObject));
		return arrayList;
	}

	private FileReader getReaderForKey(String key) throws FileNotFoundException {
		String path = PreferenceManagerSingleton.getInstance().get(key);
		DefaultFileReader defaultFileReader = new DefaultFileReader(path);
		return defaultFileReader;
	}

}
