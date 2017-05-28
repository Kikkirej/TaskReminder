package net.kikkirej.taskreminder.mail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.kikkirej.taskreminder.mail.plcaeholder.Placeholder;
import net.kikkirej.taskreminder.util.FileReader;

class MailTextGenerator {

	private FileReader fileReader;
	List<Placeholder> placeholder;
	
	
	private String text;
	
	public MailTextGenerator(FileReader fileReader) {
		placeholder = new ArrayList<Placeholder>();
		this.fileReader = fileReader;
	}
	
	public void addPlaceholder(Placeholder placeholder) {
		this.placeholder.add(placeholder);
	}
	
	public void addPlaceholder(Collection<Placeholder> collection){
		this.placeholder.addAll(collection);
	}

	public String getText() throws IOException{
		String text = getAllText();
		text = handlePlaceholder(text);
		return text;
	}

	private String getAllText() throws IOException {
		if(text == null){
			text = fileReader.getAllText();
		}
		return text;
	}

	private String handlePlaceholder(String text) {
		for (Placeholder placeholder : this.placeholder) {
			text = placeholder.replacePlatzhalter(text);
		}
		return text;
	}	
}
