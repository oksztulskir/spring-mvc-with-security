package com.boot.example.springbootexample.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MailScheduler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailScheduler.class);
    private EmailSender emailSender;

    @Autowired
    public MailScheduler(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

//    @Scheduled(fixedRate = 15000L) //15 sec
    public void scheduleSend() {
        final String emailTo = "oksztul@gmail.com";
        emailSender.sendEmail(emailTo, "Test message", "This is just a little test!");
        LOGGER.info("Email sent to: {}", emailTo);
    }
}
