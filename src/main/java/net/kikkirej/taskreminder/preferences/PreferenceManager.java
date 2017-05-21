package net.kikkirej.taskreminder.preferences;

public class PreferenceManager {
	/** Die Instanz des Singletons PreferenceManager */
	private static PreferenceManager instance;

	/** 
	 * Ein privater Konstruktor, damit die Instanz nur über die statische Methode aufgerufen wird.
	 */
	private PreferenceManager() {
		//TODO Implementieren der Initalisierung des Typs
	}

	/** 
	 * Gibt eine Instanz von PreferenceManager zurück.
	 */
	public static synchronized PreferenceManager getInstance() {
		if (instance == null) {
			instance = new PreferenceManager();
		}
		return instance;
	}
	
	public String get(String key){
		//TODO
		return null;
	}
}
