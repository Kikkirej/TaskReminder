package net.kikkirej.taskreminder;

import java.util.List;

import net.kikkirej.taskreminder.excel.ExcelInterpreter;
import net.kikkirej.taskreminder.model.TaskObject;
import net.kikkirej.taskreminder.preferences.PreferenceManagerSingleton;

public class Taskreminder implements Runnable {
	
	public static void main(String[] args) {
		new Taskreminder(args).run();
	}

	public Taskreminder(String[] args) {
		if(args.length>0){
			PreferenceManagerSingleton.setPathToFile(args[0]);
		}
	}
	
	public Taskreminder() {
	}

	public void run() {
		List<TaskObject> tasks = new ExcelInterpreter().getTaskObjects();
		checkTaskElements(tasks);
	}

	private void checkTaskElements(List<TaskObject> tasks) {
		TaskChecker taskChecker = new TaskChecker();
		for (TaskObject taskObject : tasks) {
			checkTaskElement(taskChecker, taskObject);
		}
	}

	private void checkTaskElement(TaskChecker taskChecker, TaskObject taskObject) {
		if(taskChecker.isTaskRelevant(taskObject)){
			new TaskRunner(taskObject).run();
		}
	}

}
