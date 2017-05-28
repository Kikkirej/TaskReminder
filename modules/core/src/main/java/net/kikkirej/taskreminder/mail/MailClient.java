package net.kikkirej.taskreminder.mail;

import java.util.List;

import org.apache.commons.mail.*;

import net.kikkirej.taskreminder.mail.recipentmailconnector.CCRecipentCommand;
import net.kikkirej.taskreminder.mail.recipentmailconnector.MainRecipentCommand;
import net.kikkirej.taskreminder.mail.recipentmailconnector.RecipentCommand;
import net.kikkirej.taskreminder.model.MailObject;
import net.kikkirej.taskreminder.model.MailserverObject;

public class MailClient {

	public void sendMail(MailObject mailObject) throws EmailException {
		Email email = new SimpleEmail();
		MailserverObject mailserver = mailObject.mailserver;
		email.setHostName(mailserver.hostName);
		email.setSmtpPort(mailserver.smtpPort);
		email.setFrom(mailserver.from);
		email.setSubject(mailObject.subject);
		email.setMsg(mailObject.message);
		
		email = addRecipents(new MainRecipentCommand(), email, mailObject.recipents);
		email = addRecipents(new CCRecipentCommand(), email, mailObject.cc);
		
		email.send();
	}

	Email addRecipents(RecipentCommand recipentCommand, Email mail, List<String> recipents) throws EmailException{
		if(recipents == null){
			return mail;
		}
		for (String recipent : recipents) {
			mail=recipentCommand.add(mail, recipent);
		}
		return mail;
	}

}
