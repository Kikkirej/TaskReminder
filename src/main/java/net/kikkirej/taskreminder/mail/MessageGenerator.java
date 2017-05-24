package net.kikkirej.taskreminder.mail;

import java.io.IOException;
import java.util.ArrayList;

import net.kikkirej.taskreminder.util.FileReader;

public class MessageGenerator {

	FileReader file;
	String pathPlaceholder;
	
	public String holeDaten(String path) {
		String message;
		String platzhalter;
		try {
			message = new FileReader("path").getAllText();
			platzhalter = new FileReader(pathPlaceholder).getAllText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "";
			platzhalter = "";
		}
		ArrayList<String> platzhalterArrayList = verarbeitePlatzhalter(platzhalter);
		return ersetzePlatzhalter(message,platzhalterArrayList);
	}

	public ArrayList<String> verarbeitePlatzhalter(String platzhalter) {
		ArrayList<String> platzhalterArray;
		String paraPlatzhalter="";
		for (int i = 0; i < platzhalter.length(); i++) {
			if(platzhalter.charAt(i)=='\\'&&platzhalter.charAt(i+1)=='n'){
				//ich weiß doof, wird später weiter gemacht
			}
				
		}
		
		return platzhalterArray;
	}

	public String ersetzePlatzhalter(String message, ArrayList<String> platzhalterArrayList) {
		
		
		return message;
	}
	
}
