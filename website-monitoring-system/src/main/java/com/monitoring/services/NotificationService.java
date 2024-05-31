package com.monitoring.services;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class NotificationService {
    private final String username = "your-email@gmail.com";
    private final String password = "your-email-password";

    public void sendEmail(String email, String message) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

        try {
            Message mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(generateRandomEmail()));
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            mimeMessage.setSubject("Website Update Notification");
            mimeMessage.setText(message);

            Transport.send(mimeMessage);

            System.out.println("Email sent to " + email);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendSMS(String phoneNumber, String message) {
        // Mock implementation of sending an SMS
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }

    private String generateRandomEmail() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder email = new StringBuilder();
        Random rnd = new Random();
        while (email.length() < 10) { // length of the random string
            int index = (int) (rnd.nextFloat() * chars.length());
            email.append(chars.charAt(index));
        }
        email.append("@example.com");
        return email.toString();
    }
}
