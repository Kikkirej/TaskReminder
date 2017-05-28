package net.kikkirej.taskreminder.excel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.kikkirej.taskreminder.model.TaskObject;

class TaskObjectGenerator {

	private ExcelDocument document;
	
	private Integer nameRowIndex;
	private Integer nameColumnBeginIndex;

	private Integer dateColumnIndex;
	
	public TaskObjectGenerator(ExcelDocument document) {
		this.document = document;
	}
	
	public void setNameData(Integer nameRowIndex, Integer nameColumnBeginIndex){
		this.nameRowIndex = nameRowIndex;
		this.nameColumnBeginIndex = nameColumnBeginIndex;
	}
	
	public void setDateColumnIndex(Integer dateColumnIndex){
		this.dateColumnIndex = dateColumnIndex;
		
	}
	
	private void checkData() throws Exception{
		if(nameRowIndex == null || nameColumnBeginIndex == null || dateColumnIndex == null){
			throw new Exception("Not all data set.");
		}
	}
	
	public List<TaskObject> getTaskObjects() throws Exception{
		checkData();
		List<TaskObject> objects = new ArrayList<TaskObject>();
		String[] rowValuesWithDate = document.getRowValuesWithDate(dateColumnIndex, new Date());
		for (int i = 0; i < rowValuesWithDate.length; i++) {
			TaskObject taskObject = new TaskObject();
			String cellValue = document.getCell(nameRowIndex, nameColumnBeginIndex+i);
			taskObject.personname=cellValue;			
			taskObject.taskname = rowValuesWithDate[i];
			objects.add(taskObject);
		}
		return objects;
	}
	

}
