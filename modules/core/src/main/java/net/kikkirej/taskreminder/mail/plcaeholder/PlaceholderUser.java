package net.kikkirej.taskreminder.mail.plcaeholder;

import net.kikkirej.taskreminder.model.TaskObject;

public class PlaceholderUser extends Placeholder{

	public PlaceholderUser(TaskObject taskObject) {
		super(taskObject);
	}

	@Override
	protected CharSequence getPlaceholder() {
		return "{USER}";
	}

	@Override
	protected CharSequence getReplacement() {
		return taskObject.personname;
	}

}
