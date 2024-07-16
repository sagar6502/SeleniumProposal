package org.bayone.utils;

import java.util.Properties;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class Email_sending_in_Java {
	public static void main(String[] args) {
		// email ID of Recipient.
		String recipient = "sagarsunar202@gmail.com";

		// email ID of Sender.
		String sender = "sagarsunar202@gmail.com";

		// Gmail's SMTP server
		String host = "smtp.gmail.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Set up mail server
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");
//		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable","true");

		// Get the Session object and pass username and password
		Session session = Session.getInstance(properties, new jakarta.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("sagarsunar202@gmail.com", "fcjvfyrmxlkbwmsm");
			}
		});
		// Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header
            message.setFrom(new InternetAddress(sender));

            // Set To: header field of the header
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            // Set Subject: header field
            message.setSubject("This is Subject");

            // Now set the actual message
            message.setContent("<h1>This is a HTML text</h1>", "text/html");

            // Send message
            Transport.send(message);
            System.out.println("Mail successfully sent");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
	}
}
