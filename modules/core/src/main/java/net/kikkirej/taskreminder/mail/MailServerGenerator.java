package net.kikkirej.taskreminder.mail;

import static net.kikkirej.taskreminder.preferences.PreferenceKeys.MAILFROM;
import static net.kikkirej.taskreminder.preferences.PreferenceKeys.MAILHOST;
import static net.kikkirej.taskreminder.preferences.PreferenceKeys.MAILPORT;

import net.kikkirej.taskreminder.model.MailserverObject;
import net.kikkirej.taskreminder.preferences.PreferenceManagerSingleton;

public class MailServerGenerator {
	
	private PreferenceManagerSingleton preferences;

	public MailServerGenerator() {
		preferences = PreferenceManagerSingleton.getInstance();
	}
	
	public MailserverObject getServer(){
		MailserverObject mailserver = new MailserverObject();
		mailserver.from = getFrom();
		mailserver.hostName = getHostname();
		mailserver.smtpPort = getPort();
		return mailserver;
	}

	private String getFrom() {
		return getPreference(MAILFROM);
	}
	
	private String getHostname() {
		return getPreference(MAILHOST);
	}

	private int getPort() {
		return getIntPreference(MAILPORT);
	}

	private String getPreference(String key){
		return preferences.get(key);
	}
	
	private int getIntPreference(String key){
		return preferences.getIntValue(key);
	}
}
