package net.kikkirej.taskreminder.preferences.mapping;

import java.util.ArrayList;
import java.util.List;

import net.kikkirej.taskreminder.exceptions.MappingInvalidException;
import net.kikkirej.taskreminder.model.MappingObject;

class MappingGenerator {

	private List<String> mappingText;

	MappingGenerator(List<String> mappingText) {
		this.mappingText = mappingText;
	}
	
	List<MappingObject> getMappings() throws MappingInvalidException{
		List<MappingObject> mappings = new ArrayList<MappingObject>();
		for (String line : mappingText) {
			if(!isComment(line)){
				MappingObject mapping= getMappingObject(line);
				mappings.add(mapping);
			}
		}
		return mappings;
	}

	private boolean isComment(String line) {
		if(line.length()<2){
			return true;
		}
		String substring = line.substring(0, 1);
		return substring.equals("#");
	}

	private MappingObject getMappingObject(String line) throws MappingInvalidException {
		String[] splitedLine = line.split(",");
		if(splitedLine.length != 4){
			throw new MappingInvalidException("Das Mapping hat die falsche Anzahl Bestandteile:" + splitedLine.length);
		}
		MappingObject mappingObject = getMappingObjectOfArraz(splitedLine);
		return mappingObject;
	}

	private MappingObject getMappingObjectOfArraz(String[] splitedLine) {
		MappingObject mappingObject = new MappingObject();
		mappingObject.name = splitedLine[0];
		mappingObject.hostname = splitedLine[1].replace(" ", "");
		mappingObject.mail = splitedLine[2].replace(" ", "");
		mappingObject.shouldGetMail = splitedLine[3].replace(" ", "").equalsIgnoreCase("true");
		return mappingObject;
	}

}
