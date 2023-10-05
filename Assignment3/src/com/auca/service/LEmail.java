package com.auca.service;

import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LEmail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String recipientEmail = request.getParameter("recipientEmail");
        String confirmationCode = request.getParameter("confirmationCode");

        
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com"); 
        properties.put("mail.smtp.port", "587"); 
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        final String senderEmail = "nimuebwe@gmail.com";
        final String senderPassword = "0000 0000 0000 0000";
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
        try {          
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Email"); 
            message.setText("Confirmation Code: " + confirmationCode); 
            Transport.send(message);           
            response.getWriter().write("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();        
            response.getWriter().write("Failed to send email: " + e.getMessage());
        }
    }
}
