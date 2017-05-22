package net.kikkirej.taskreminder.preferences;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import net.kikkirej.taskreminder.model.MappingObject;

public class MappingGeneratorTest {

	/**SUT*/
	MappingGenerator mappingGenerator;
	
	@Test
	public void singleMapping() throws Exception {
		ArrayList<String> mappingText = new ArrayList<String>();
		mappingText.add("Hans Mustermann, pc123, hans.mustermann@mail.de, true");
		mappingGenerator = new MappingGenerator(mappingText);
		List<MappingObject> mappings = mappingGenerator.getMappings();
		if(mappings == null || mappings.size()!= 1){
			fail("Die Rückgabe ist fehlerhaft.");
		}
		MappingObject expected = new MappingObject();
		expected.hostname = "pc123";
		expected.name = "Hans Mustermann";
		expected.shouldGetMail = true;
		expected.mail = "hans.mustermann@mail.de";
		assertEquals(expected, mappings.get(0));
	}
	
	@Test
	public void multiMapping() throws Exception {
		ArrayList<String> mappingText = new ArrayList<String>();
		mappingText.add("Hans Mustermann, pc123, hans.mustermann@mail.de, true");
		mappingText.add("Somebody, hostname, mail@mail, false");
		mappingGenerator = new MappingGenerator(mappingText);
		List<MappingObject> mappings = mappingGenerator.getMappings();
		if(mappings == null || mappings.size()!= 2){
			fail("Die Rückgabe ist fehlerhaft.");
		}
		MappingObject expected1 = new MappingObject();
		expected1.hostname = "pc123";
		expected1.name = "Hans Mustermann";
		expected1.shouldGetMail = true;
		expected1.mail = "hans.mustermann@mail.de";
		assertEquals(expected1, mappings.get(0));
		
		MappingObject expected2 = new MappingObject();
		expected2.hostname = "hostname";
		expected2.name = "Somebody";
		expected2.shouldGetMail = false;
		expected2.mail = "mail@mail";
		assertEquals(expected2, mappings.get(1));
	}
	
	public void tearDown() {
		mappingGenerator = null;
	}

}
