package net.kikkirej.taskreminder.mail.plcaeholder;

import net.kikkirej.taskreminder.model.TaskObject;

public class PlaceholderTask extends Placeholder {

	public PlaceholderTask(TaskObject taskObject) {
		super(taskObject);
	}

	@Override
	protected CharSequence getPlaceholder() {
		return "{TASK}";
	}

	@Override
	protected CharSequence getReplacement() {
		return taskObject.taskname;
	}

}
