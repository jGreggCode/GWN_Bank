package com.jgfbank.service;

import com.jgfbank.model.ModelMessage;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class ServiceMail {

    public void successRegistered(String toEmail) {
        String from = "jgfbank@gmail.com";
        String password = "oyyjqfdrlqrdkysb";
        String host = "smtp.gmail.com";
        Properties prop = System.getProperties();
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.user", from);
        prop.put("mail.smtp.password", password);
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(prop);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Congrats! your JGFBank account has been successfully registered!");
            message.setText("");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public ModelMessage sendMain(String toEmail, String code, String name) {
        ModelMessage ms = new ModelMessage(false, "");


        String from = "jgfbank@gmail.com";
        String password = "oyyjqfdrlqrdkysb";
        String host = "smtp.gmail.com";
        Properties prop = System.getProperties();
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.user", from);
        prop.put("mail.smtp.password", password);
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(prop);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Welcome to JGFBank");
            message.setText("Hi " + name + "!\n\nYour Verification Code is : " + code + "\n\nYou're almost dont! To finish setting up your JGFBank account, enter the code to verify your email address.");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Code sent Successfully! \nCode: " + code); // Just for logging
            ms.setSuccess(true);
        } catch (MessagingException e) {
            e.printStackTrace();
            if (e.getMessage().equals("Invalid Addresses")) {
                ms.setMessage("Invalid email");
            } else {
                ms.setMessage("Error");
            }
        }
        return ms;
    }
}