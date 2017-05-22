package net.kikkirej.taskreminder.preferences;

import java.io.IOException;
import java.util.Properties;

public class PreferenceManager {
	/** Die Instanz des Singletons PreferenceManager */
	private static PreferenceManager instance;
	private Properties properties;

	/** 
	 * Ein privater Konstruktor, damit die Instanz nur über die statische Methode aufgerufen wird.
	 */
	private PreferenceManager() {
		PropertiesLoader propertiesLoader = new PropertiesLoader("config.properties");
		try {
			properties = propertiesLoader.load();
		} catch (IOException e) {
			System.err.println("Das Laden der Properties ist fehlgeschlagen.");
			e.printStackTrace();
			System.exit(1);
		}
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
		return properties.getProperty(key);
	}
	
	public String[] getCSVValues(String key, Character separator){
		return get(key).split(separator.toString());
	}
}
