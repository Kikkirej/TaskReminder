package net.kikkirej.taskreminder.mail.recipents;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

public class MainRecipentCommand implements IRecipentCommand {

	public Email add(Email mail, String recipent) throws EmailException {
		return mail.addTo(recipent);
	}

}
