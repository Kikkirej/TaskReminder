package net.kikkirej.taskreminder.preferences;

import java.io.IOException;
import java.util.Properties;

public class PreferenceManagerSingleton {
	/** Die Instanz des Singletons PreferenceManager */
	private static PreferenceManagerSingleton instance;
	private Properties properties;

	/** 
	 * Ein privater Konstruktor, damit die Instanz nur über die statische Methode aufgerufen wird.
	 */
	private PreferenceManagerSingleton() {
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
	public static synchronized PreferenceManagerSingleton getInstance() {
		if (instance == null) {
			instance = new PreferenceManagerSingleton();
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
