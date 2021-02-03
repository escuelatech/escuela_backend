package com.escuela.api.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Component
public class EmailUtils {

	@Autowired
	JavaMailSender mailSender;

	/**
	 * @param body
	 * @param to
	 * @param subject
	 * @return
	 */

	public  boolean sendInDividualEmail(String to,String subject,String body) {
		try {
			String from 	= "letstalk@escuelatech.com";
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			msg.setFrom(new InternetAddress(from,"Esquela"));
			msg.setTo(to);
			msg.setSubject(subject);
			msg.setText(body,true);
			msg.addInline("aws.jpg", new ClassPathResource("aws.jpg"));
//			msg.addInline("logo.jpeg", new ClassPathResource("logo.jpeg"));
			mailSender.send(mimeMessage);
			return true;
		}  catch(Exception exc) {
			exc.printStackTrace(); //TODO handle Exception
			return false;
		}
	}
}
