package net.kikkirej.taskreminder;

import net.kikkirej.taskreminder.model.TaskObject;
import net.kikkirej.taskreminder.preferences.PreferenceKeys;
import net.kikkirej.taskreminder.preferences.PreferenceManagerSingleton;

public class TaskChecker {

	private String[] importantTasks;

	public TaskChecker() {
		importantTasks = PreferenceManagerSingleton.getInstance().getCSVValues(PreferenceKeys.IMPORTANTTASKS, ';');
	}
	
	public boolean isTaskRelevant(TaskObject taskObject) {
		for (String task : importantTasks) {
			if(task.replace(" ", "").equals(taskObject.taskname)){
				return true;
			}
		}
		return false;
	}

}
