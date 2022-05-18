package com.practice.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.search.FromTerm;
import javax.mail.search.SearchTerm;
import java.util.Properties;

public class MailReaderUtil {

    public static void main(String[] args) {
        String host = "pop.gmail.com";// change accordingly
        String mailStoreType = "pop3";
        String username = "kumar7284kumar@gmail.com";// change accordingly
        String password = "ekpgkqvljkthmlhc";// change accordingly

        check(host,mailStoreType, username, password);
    }

    public static void check(String host,String mailStoreType,  String user,
                             String password)
    {
        try {
            System.setProperty("mail.pop3s.ssl.protocols", "TLSv1.2");
            //create properties field
            Properties properties = new Properties();

            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");

            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");

            store.connect(host, user, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);
            SearchTerm sender = new FromTerm(new InternetAddress("studentsupport@upgrad.com"));
            // retrieve the messages from the folder in an array and print it
            System.out.println(emailFolder.getMessageCount());
            System.out.println(emailFolder.getNewMessageCount());
            System.out.println(emailFolder.getFullName());
            Message[] messages = emailFolder.search(sender);
            System.out.println("messages.length---" + messages.length);

            Message message = messages[messages.length-1];
            System.out.println("---------------------------------");
            System.out.println("Subject: " + message.getSubject());
            System.out.println("From: " + message.getFrom());
            System.out.println("Text: " + message.getContent().toString());

            /*for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());

            }*/

            //close the store and folder objects
            emailFolder.close(true);
            store.close();

        }  catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean match(Message message) {
        try {
            if (message.getSubject().contains("Where are you stuck")) {
                System.out.println("match found");
                return true;
            }
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return false;
    };

}
