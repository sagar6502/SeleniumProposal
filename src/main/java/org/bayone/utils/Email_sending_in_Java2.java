package org.bayone.utils;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Email_sending_in_Java2 {
	
	public static void main(String[] args) {
		

		GmailSender1 gmail1 = new GmailSender1();
		String sender = "sagarsunar202@gmail.com";
		String to ="ssunar@bayonesolutions.com";
		String subject = "Testing Report : "+getTodayDate();
		String text = "Test is completed.";
		String reportPath = System.getProperty("user.dir")+ File.separatorChar+"extentReport.html";
		
		boolean b = gmail1.sendEmail3(sender, to, subject, text,reportPath);
		if(b) {
			System.out.println("Email is sent");
		} else {
			System.err.println("Email could not be sent");
		}
	}
	
	private static String getTodayDate() {
		// Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Define a formatter with the desired pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy HH:mm:ss", Locale.getDefault());

        // Format the date and time according to the locale
        String formattedDateTime = now.format(formatter);
        
        return formattedDateTime;
	}
}
