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
	
	public void tearDown() {
		mappingGenerator = null;
	}

}
