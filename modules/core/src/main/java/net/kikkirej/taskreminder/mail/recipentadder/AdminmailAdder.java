package net.kikkirej.taskreminder.mail.recipentadder;

import java.util.Collection;
import java.util.List;

import net.kikkirej.taskreminder.preferences.PreferenceKeys;
import net.kikkirej.taskreminder.preferences.PreferenceManagerSingleton;

public class AdminmailAdder extends ArrayRecipentAdder {

	public AdminmailAdder(List<String> recipents) {
		super(recipents);
	}
	
	@Override
	protected String[] getStringArray() {
		String[] csvValues = PreferenceManagerSingleton.getInstance().getCSVValues(PreferenceKeys.ADMINMAIL, ';');
		return csvValues;
	}

}
