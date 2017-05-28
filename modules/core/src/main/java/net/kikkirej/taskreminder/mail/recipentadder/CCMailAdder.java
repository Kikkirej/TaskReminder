package net.kikkirej.taskreminder.mail.recipentadder;

import java.util.List;

import net.kikkirej.taskreminder.preferences.PreferenceKeys;
import net.kikkirej.taskreminder.preferences.PreferenceManagerSingleton;

public class CCMailAdder extends ArrayRecipentAdder {

	public CCMailAdder(List<String> recipents) {
		super(recipents);
	}

	@Override
	protected String[] getStringArray() {
		String[] csvValues = PreferenceManagerSingleton.getInstance().getCSVValues(PreferenceKeys.CCMAIL, ';');
		return csvValues;
	}

}
