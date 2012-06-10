package com.ipablive.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.ipablive.vo.MailBean;

public class MailUtilities 
{
	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
	private static final String SMTP_PORT = "465";
	private static final String emailFromAddress = "*****@***.com";
	private static final String emailFromPassword = "########";
	private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

	public static void sendMail(String purpose,MailBean mb) throws AddressException,MessagingException
	{
		boolean debug = true;

		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.put("mail.smtp.socketFactory.fallback", "false");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(emailFromAddress, emailFromPassword);
					}
				});

		session.setDebug(debug);

		Message msg = new MimeMessage(session);
		InternetAddress addressFrom = new InternetAddress(emailFromAddress);
		msg.setFrom(addressFrom);

		String[] recipients = new String[1];
		recipients[0] = mb.getEmail();
		
		InternetAddress[] addressTo = new InternetAddress[recipients.length];
		for (int i = 0; i < recipients.length; i++) {
			addressTo[i] = new InternetAddress(recipients[i]);
		}
		msg.setRecipients(Message.RecipientType.TO, addressTo);

		// Setting the Subject and Content Type
		if(purpose.equalsIgnoreCase("register"))
		{
			msg.setSubject("####");
			// Set message content
			msg.setText("");
		}
		
		Transport.send(msg);
	}
}
