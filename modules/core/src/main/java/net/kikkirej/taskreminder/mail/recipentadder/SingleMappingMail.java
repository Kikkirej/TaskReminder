package net.kikkirej.taskreminder.mail.recipentadder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.kikkirej.taskreminder.model.MappingObject;

public class SingleMappingMail extends RecipentAdder {

	private MappingObject mapping;

	public SingleMappingMail(List<String> recipents, MappingObject mapping) {
		super(recipents);
		this.mapping = mapping;
	}

	@Override
	protected Collection<String> getRecipents() {
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add(mapping.mail);
		return arrayList;
	}

}
