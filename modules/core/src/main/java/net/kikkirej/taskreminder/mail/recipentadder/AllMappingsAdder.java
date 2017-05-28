package net.kikkirej.taskreminder.mail.recipentadder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.kikkirej.taskreminder.model.MappingObject;
import net.kikkirej.taskreminder.preferences.mapping.MappingManager;

public class AllMappingsAdder extends RecipentAdder {

	public AllMappingsAdder(List<String> recipents) {
		super(recipents);
	}

	@Override
	protected Collection<String> getRecipents() {
		List<MappingObject> mappingObjects = MappingManager.getInstance().getAll();
		ArrayList<String> arrayList = new ArrayList<String>();
		for (MappingObject mappingObject : mappingObjects) {
			arrayList.add(mappingObject.mail);
		}
		
		return arrayList;
	}

}
