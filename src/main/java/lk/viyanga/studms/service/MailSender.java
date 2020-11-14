package lk.viyanga.studms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author - Anuradha Ranasinghe on 2020-11-14
 * @project - stud-ms
 **/
@Service
public class MailSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailSender.class);

    public void send(String address, String subject, String body) {

        LOGGER.info("MailSender | send | address : {} | subject : {}", address, subject);

        final String username = "sasip.inst@gmail.com";
        final String password = "sasip@@1234";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sasip.inst@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(address)
            );
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            LOGGER.info("MailSender | send | success | address : {} | subject : {}", address, subject);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
