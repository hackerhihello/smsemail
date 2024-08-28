package com.email.sms.service;

import com.email.sms.model.EmailRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender emailSender;

    @Autowired
    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendEmail(EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getEmail());
        message.setSubject("Project Submission Details");
        message.setText(
            "Name: " + emailRequest.getUsername() + "\n" +
            "Email: " + emailRequest.getEmail() + "\n" +
            "Phone: " + emailRequest.getPhone() + "\n" +
            "WhatsApp: " + emailRequest.getWhatsapp() + "\n" +
            "Project Name: " + emailRequest.getProjectName() + "\n" +
            "Programming Language: " + emailRequest.getLanguage() + "\n" +
            "Description: " + emailRequest.getDescription()
        );
        emailSender.send(message);
    }
}
