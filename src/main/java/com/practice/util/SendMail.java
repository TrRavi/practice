package com.practice.util;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class SendMail {
    public static void main(String[] args) throws MessagingException {
        Properties props = new Properties();

        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kumar7284kumar@gmail.com", "ekpgkqvljkthmlhc");
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("kumar7284kumar@gmail.com"));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse("ishank.aggarwal@mediaagility.com"));
        message.setSubject("Mail Subject");

        String msg = "This is my first email using JavaMailer <br><br><img src=\"" + Chart.getChart() + "\">";

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(msg, "text/html");
        System.out.println(msg);

        Transport.send(message);
        System.out.println("mail sent");
    }
}
