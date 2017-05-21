package net.kikkirej.taskreminder.preferences;

import java.util.List;

import net.kikkirej.taskreminder.model.MappingObject;

public class MappingManager {
	
	/** Die Instanz des Singletons MappingManager */
	private static MappingManager instance;

	/** 
	 * Ein privater Konstruktor, damit die Instanz nur über die statische Methode aufgerufen wird.
	 */
	private MappingManager() {
		//TODO Implementieren der Initalisierung des Typs
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
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<MappingObject> getAll(){
		return null;
	}
}
