package net.kikkirej.taskreminder.mail.recipents;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

public interface RecipentCommand {
	Email add(Email mail, String recipent) throws EmailException;
}
