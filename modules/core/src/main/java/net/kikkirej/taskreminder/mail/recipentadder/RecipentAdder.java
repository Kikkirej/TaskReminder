package net.kikkirej.taskreminder.mail.recipentadder;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

public abstract class RecipentAdder implements Runnable {
	
	Logger logger = Logger.getLogger(RecipentAdder.class);
	
	private List<String> recipents;

	public RecipentAdder(List<String> recipents) {
		this.recipents = recipents;
		
	}
	
	public void run() {
		Collection<String> newRecipents = getRecipents();
		recipents.addAll(newRecipents);
		logger.debug("Added " + newRecipents.size() + " recipents");
	}

	protected abstract Collection<String> getRecipents();
}
