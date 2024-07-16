package org.bayone.utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class GmailSender1 {
	public boolean sendEmail(String from, String to, String subject, String text) {
		boolean flag = false;
		
		String host = "smtp.gmail.com";
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable","true");
		
		final String user = "sagarsunar202";
		final String password = "fcjvfyrmxlkbwmsm";
		
		Session instance = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		instance.setDebug(true);
		
		try {
			Message message = new MimeMessage(instance);
			
			message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
			message.setFrom(new InternetAddress(from));
			message.setSubject(subject);
			message.setText(text);
			
			Transport.send(message);
			flag = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean sendEmail1(String from, String to, String subject, String text) {
        boolean flag = false;

        String host = "smtp.gmail.com";
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587"); // Use 587 for STARTTLS
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS

        final String user = "sagarsunar202";
        final String password = "fcjvfyrmxlkbwmsm";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        session.setDebug(true);

        try {
            Message message = new MimeMessage(session);

            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
	
	public boolean sendEmail2(String from, String to, String subject, String text, String reportFilePath) {
        boolean flag = false;

        String host = "smtp.gmail.com";
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587"); // Use 587 for STARTTLS
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS

        final String user = "sagarsunar202";
        final String password = "fcjvfyrmxlkbwmsm";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        session.setDebug(true);

        try {
            Message message = new MimeMessage(session);
            
         // Read HTML file content
            String htmlContent = new String(Files.readAllBytes(Paths.get(reportFilePath)));

            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setText(text);
            message.setContent(htmlContent, "text/html");

            Transport.send(message);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
	
	public boolean sendEmail3(String from, String to, String subject, String text, String reportFilePath) {
        boolean flag = false;

        String host = "smtp.gmail.com";
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587"); // Use 587 for STARTTLS
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS

        final String user = "sagarsunar202";
        final String password = "fcjvfyrmxlkbwmsm";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        session.setDebug(true);

        try {
            Message message = new MimeMessage(session);
            
         // Read HTML file content
            String htmlContent = new String(Files.readAllBytes(Paths.get(reportFilePath)));

            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            
            
            // Create a multipart message for attachment
            MimeMultipart multipart = new MimeMultipart();

            // Create the message part (optional, can be used for the email body)
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Please find the attached HTML file.");
            multipart.addBodyPart(messageBodyPart);
            
         // Create the attachment part
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(reportFilePath);
            attachmentBodyPart.setDataHandler(new DataHandler(source));
            attachmentBodyPart.setFileName(new File(reportFilePath).getName());
            multipart.addBodyPart(attachmentBodyPart);
            
         // Set the complete message parts
            message.setContent(multipart);
//            message.setText(text);
//            message.setContent(htmlContent, "text/html");

            Transport.send(message);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
}
