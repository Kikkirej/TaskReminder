package net.kikkirej.taskreminder.excel;

import static net.kikkirej.taskreminder.preferences.PreferenceKeys.*;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import net.kikkirej.taskreminder.model.TaskObject;
import net.kikkirej.taskreminder.preferences.PreferenceManagerSingleton;
import net.kikkirej.taskreminder.util.DefaultFileReader;

public class ExcelInterpreter {

	public List<TaskObject> getTaskObjects() {
		ExcelDocument document= null;
		try {
			document = createExcelDocument();
			TaskObjectGenerator taskObjectGenerator = getTaskObjectGenerator(document);
			List<TaskObject> taskObjects = taskObjectGenerator.getTaskObjects();
			return taskObjects;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(document != null){
				try {
					document.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	private ExcelDocument createExcelDocument() throws IOException {
		// get Preferences
		PreferenceManagerSingleton preferenceManager = PreferenceManagerSingleton.getInstance();
		String pathtoDocument = preferenceManager.get(PATHTOEXCELDOCUMENT);
		String sheetname = preferenceManager.get(SHEETNAME);
		Integer nameColumnBeginIndex = preferenceManager.getIntValue(NAMECOLUMNBEGININDEX) - 1;
		Integer nameColumnEndIndex = preferenceManager.getIntValue(NAMECOLUMNENDINDEX) - 1;
		
		// create inputstream 
		DefaultFileReader defaultFileReader = new DefaultFileReader(pathtoDocument);
		FileInputStream inputStream = defaultFileReader.getFileInputStream();
		
		// create and configure document
		ExcelDocument document = new ExcelDocument(inputStream);
		document.selectSheet(sheetname);
		document.setCheckingColumns(nameColumnBeginIndex, nameColumnEndIndex);
		return document;
	}

	private TaskObjectGenerator getTaskObjectGenerator(ExcelDocument document) {
		// get Preferences
		PreferenceManagerSingleton preferenceManager = PreferenceManagerSingleton.getInstance();
		Integer nameColumnBeginIndex = preferenceManager.getIntValue(NAMECOLUMNBEGININDEX) - 1;
		Integer nameRowIndex = preferenceManager.getIntValue(NAMEROWINDEX)-1;
		Integer dateColumnIndex = preferenceManager.getIntValue(DATECOLUMNINDEX)-1;
		
		// create Generator
		TaskObjectGenerator taskObjectGenerator = new TaskObjectGenerator(document);
		taskObjectGenerator.setDateColumnIndex(dateColumnIndex);
		taskObjectGenerator.setNameData(nameRowIndex, nameColumnBeginIndex);
		return taskObjectGenerator;
	}

}
