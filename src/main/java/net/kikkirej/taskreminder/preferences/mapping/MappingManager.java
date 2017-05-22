package net.kikkirej.taskreminder.preferences.mapping;

import static net.kikkirej.taskreminder.preferences.PreferenceKeys.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.kikkirej.taskreminder.exceptions.MappingInvalidException;
import net.kikkirej.taskreminder.model.MappingObject;
import net.kikkirej.taskreminder.preferences.PreferenceManager;
import net.kikkirej.taskreminder.util.FileReader;

public class MappingManager {
	
	/** Die Instanz des Singletons MappingManager */
	private static MappingManager instance;
	private List<MappingObject> mappingsList;
	private Map<String, MappingObject> map;

	/** 
	 * Ein privater Konstruktor, damit die Instanz nur über die statische Methode aufgerufen wird.
	 */
	private MappingManager() {
		try {
			List<String> mappingText = getMappingText();
			MappingGenerator mappingGenerator = new MappingGenerator(mappingText);
			mappingsList = mappingGenerator.getMappings();
			map = getMappingsMap();
		} catch (IOException e) {
			System.err.println("Beim Auslesen des Mappings ist ein Fehler aufgetreten:");
			e.printStackTrace();
			System.exit(1);
		} catch (MappingInvalidException e) {
			System.err.println("Beim Analysieren des Mappings ist ein Fehler aufgetreten.");
			e.printStackTrace();
			System.exit(1);
		}
	}

	private List<String> getMappingText() throws IOException {
		String pathToMappingDoc = PreferenceManager.getInstance().get(PATHTOMAPPINGDOCUMENT);
		FileReader fileReader = new FileReader(pathToMappingDoc);
		return fileReader.getLineArray();
	}

	private Map<String, MappingObject> getMappingsMap() {
		Map<String, MappingObject> map = new HashMap<String, MappingObject>();
		for (MappingObject mappingObject : mappingsList) {
			map.put(mappingObject.name,mappingObject);
		}
		return map;
	}

	/** 
	 * Gibt eine Instanz von MappingManager zurück.
	 */
	public static synchronized MappingManager getInstance() {
		if (instance == null) {
			instance = new MappingManager();
		}
		return instance;
	}

	public MappingObject getMapping(String personname) {
		return map.get(personname);
	}
	
	public List<MappingObject> getAll(){
		return mappingsList;
	}
}
