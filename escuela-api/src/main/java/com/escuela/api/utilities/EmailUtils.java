package com.escuela.api.utilities;

import org.springframework.stereotype.Component;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class EmailUtils {
	
	public static void main(String[] args) {
		EmailUtils email=new EmailUtils();
		Session session=email.getMailSession();
		email.sendInDividualEmail("test","shyam.ramath@gmail.com", "test");
	}
	
//	/**
//	 *
//	 * @param to
//	 * @param subject
//	 * @param message
//	 * @throws Exception
//	 */
//	public  void sendEmail(String to,String subject,String message) throws Exception{
//		Session session=getMailSession();
//		String from 	= "malabarhangouts@gmail.com";
//		MimeMessage msg = new MimeMessage(session);
//		try {
//			msg.setFrom(new InternetAddress(from));
//			msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
//			msg.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress(PRANAMA_EMAIL_BCC));
//			msg.setSubject(subject);
//			msg.setText(message);
//			Transport transport = session.getTransport("smtp");
//			transport.send(msg);
//		}  catch(Exception exc) {
//			throw exc;
//		}
//	}

	/**
	 *
	 * @param body
	 * @param to
	 * @param subject
	 * @return
	 */
	public  boolean sendInDividualEmail(String body,String to,String subject) {
		try {
			String from 	= "letstalk@escuelatech.com";
			Session session=getMailSession();
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from,"Pranama Care"));
			msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
//			msg.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress(PRANAMA_EMAIL));
			msg.setSubject(subject);
			msg.setContent(body, "text/html");
			Transport transport = session.getTransport("smtp");
			transport.send(msg);
			return true;
		}  catch(Exception exc) {
			exc.printStackTrace();
			return false;
		}
	}
	
//	/**
//	 * Email
//	 * @param body
//	 * @param to
//	 * @param username
//	 * @param password
//	 */
//	public  void sendGroupEmail(String body,String subject,String[] groupsEmail) {
//		try {
//			String from 	= "malabarhangouts@gmail.com";
//			Session session=getMailSession();
//			MimeMessage msg = new MimeMessage(session);
//			msg.setFrom(new InternetAddress(from,"Cakify Calicut"));
//			for(String email:groupsEmail){
//				msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email));
//			}
//			msg.setSubject(subject);
//			msg.setContent(body, "text/html");
//			Transport transport = session.getTransport("smtp");
//			transport.send(msg);
//		}  catch(Exception exc) {
//			exc.printStackTrace();
//		}
//	}
	
//	/**
//	 * Get email session
//	 * @return
//	 */
//	private Session getMailSession1(){
//		Session session = Session.getDefaultInstance(loadMailProperties(), new Authenticator() {
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				String username = "letstalk@escuelatech.com";
//				String password = "Kaditham@123qwq";
//				return new PasswordAuthentication(username,password);
//			}
//		});
//		return session;
//	}
//
	/**
	 * Get email session
	 * @return
	 */
	private Session getMailSession(){
		Session session = Session.getInstance(loadMailProperties(), new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				String username = "letstalk@escuelatech.com";
				String password = "Kaditham@123";
				return new PasswordAuthentication(username,password);
			}
		});
		return session;
	}
	/**
	 * Load email default properties
	 * @return
	 */
	private Properties loadMailProperties(){
		Properties props = new Properties();
		props.put("mail.smtp.host", "mail.escuelatech.com");
		props.put("mail.smtp.port", 587);
		props.put("mail.stmp.user", "username");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.password", "password");
		return props;
	}

}
