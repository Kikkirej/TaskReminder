package net.kikkirej.taskreminder;

import java.util.List;

import net.kikkirej.taskreminder.excel.ExcelInterpreter;
import net.kikkirej.taskreminder.model.TaskObject;

public class Taskreminder {
	
	public static void main(String[] args) {
		new Taskreminder().run(args);
	}

	private void run(String[] args) {
		List<TaskObject> tasks = new ExcelInterpreter().getTaskObjects();
		checkTaskElements(tasks);
	}

	private void checkTaskElements(List<TaskObject> tasks) {
		TaskChecker taskChecker = new TaskChecker();
		for (TaskObject taskObject : tasks) {
			checkTaskElement(taskChecker, taskObject);
		}
	}

	//TODO CRINGE MACH DAS OBJEKTORIENTIERT
	private void checkTaskElement(TaskChecker taskChecker, TaskObject taskObject) {
		if(taskChecker.isTaskRelevant(taskObject)){
			new TaskRunner(taskObject).run();
		}
	}

}
