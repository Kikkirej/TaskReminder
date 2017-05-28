package net.kikkirej.taskreminder.mail.recipentadder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class ArrayRecipentAdder extends RecipentAdder {

	public ArrayRecipentAdder(List<String> recipents) {
		super(recipents);
	}

	@Override
	protected Collection<String> getRecipents() {
		String[] array = getStringArray();
		Collection<String> collection = new ArrayList<String>();
		for (String string : array) {
			collection.add(string);
		}
		return collection;
	}

	protected abstract String[] getStringArray();

}
