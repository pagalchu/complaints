package com.sv.complaints.Utils;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class Email {
    public final static String to = Secret.to;
    public final static String  host = "smtp.gmail.com";
    public final static String  password = Secret.password;
    public final static String  userName = Secret.userName;
    public final static String  subject = "Email from Complaint application";



    public static void sendEmail(String message)
    {
        try
        {
            Properties props = new Properties();
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.port", "465");


            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, password);
                }
            });

            Message email = new MimeMessage(session);
            email.setFrom(new InternetAddress(userName));
            email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            email.setSubject(subject);
            email.setText(message);
            Transport.send(email);
              }
        catch(Exception e)
        {
            System.out.println(e.getMessage());

        }
    }

    public static void main(String[] args) {
        sendEmail("Jay Saraswati!!!");
    }
}
