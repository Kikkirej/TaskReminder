package net.kikkirej.taskreminder.mail.plcaeholder;

import net.kikkirej.taskreminder.model.TaskObject;

public abstract class Placeholder {
	
	protected TaskObject taskObject;
	public Placeholder(TaskObject taskObject) {
		this.taskObject = taskObject;
	}
	
	public String replacePlatzhalter(String text){
		String replacedText = text.replace(getPlaceholder(), getReplacement());
		return replacedText;
	}

	protected abstract CharSequence getPlaceholder();

	protected abstract CharSequence getReplacement();
}
