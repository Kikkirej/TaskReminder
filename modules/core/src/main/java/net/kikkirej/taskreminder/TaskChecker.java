package net.kikkirej.taskreminder;

import net.kikkirej.taskreminder.model.TaskObject;
import net.kikkirej.taskreminder.preferences.PreferenceKeys;
import net.kikkirej.taskreminder.preferences.PreferenceManagerSingleton;

public class TaskChecker {

	private String[] csvValues;

	public TaskChecker() {
		csvValues = PreferenceManagerSingleton.getInstance().getCSVValues(PreferenceKeys.IMPORTANTTASKS, ';');
	}
	
	public boolean isTaskRelevant(TaskObject taskObject) {
		for (String csvValue : csvValues) {
			if(csvValue.equals(taskObject.taskname)){
				return true;
			}
		}
		return false;
	}

}
