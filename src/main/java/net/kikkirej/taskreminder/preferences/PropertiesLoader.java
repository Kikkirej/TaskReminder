package net.kikkirej.taskreminder.preferences;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import net.kikkirej.taskreminder.util.FileReader;

class PropertiesLoader {

	private FileInputStream fileInputStream;

	PropertiesLoader(String pathToFile) {
		fileInputStream = null;
		try {
			fileInputStream = getFileInputStream(pathToFile);
		} catch (FileNotFoundException e) {
			System.err.println("Beim Auslesen der Einstellungen ist ein Fehleraufgetreten.");
			e.printStackTrace();
			System.exit(1);
		}finally {
			if(fileInputStream!= null){
				try {
					fileInputStream.close();
				} catch (IOException e) {
					System.err.println("Beim Schlieﬂen des Streams trat ein Fehler auf.");
					e.printStackTrace();
				}
			}
		}
	}

	private FileInputStream getFileInputStream(String pathToFile) throws FileNotFoundException {
		FileReader fileReader = new FileReader(pathToFile);
		return fileReader.getFileInputStream();
	}
	
	Properties load() throws IOException{
		Properties properties = new Properties();
		properties.load(fileInputStream);
		return properties;
	}

}
