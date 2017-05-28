package net.kikkirej.taskreminder.model;

import java.util.ArrayList;
import java.util.List;

public class MailObject {

	public MailObject() {
		recipents = new ArrayList<String>();
		cc = new ArrayList<String>();
	}
	
	public List<String> recipents;
	
	public List<String> cc;
	
	public String subject;
	
	public String message;
	
	public MailserverObject mailserver;
}
