package net.kikkirej.taskreminder.mail;

import java.util.ArrayList;

import net.kikkirej.taskreminder.mail.plcaeholder.Placeholder;

public class MailSubjectGenerator {

	ArrayList<Placeholder> placeholder;
	
	public MailSubjectGenerator()
	{
		placeholder = new ArrayList<Placeholder>();
	}
	
	public String getSubject(String text) {
		return text;
	}

	public void addPlaceholder(Placeholder placeholder){
		this.placeholder.add(placeholder);
	}
	
	public String handlePlaceholder(String text) {
		for (Placeholder placeholder : this.placeholder) {
			text = placeholder.replacePlatzhalter(text);
		}
		return text;
	}
	
	

}
