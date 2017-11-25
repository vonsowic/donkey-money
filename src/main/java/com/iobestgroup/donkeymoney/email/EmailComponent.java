package com.iobestgroup.donkeymoney.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @author Michał Wąsowicz
 * @version 1.0
 * @since 24.11.17
 */
@Component("email")
public class EmailComponent {

    public final JavaMailSender emailSender;

    @Autowired
    public EmailComponent(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage(String to, String subject, String text) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            emailSender.send(message);
    }
}
