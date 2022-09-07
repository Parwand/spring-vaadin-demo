package com.example.application.applicationservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    private final static Logger log = LoggerFactory.getLogger(MailService.class);

    private final TemplateEngine templateEngine;

    private final JavaMailSender mailSender;

    public MailService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
        this.mailSender = new JavaMailSenderImpl();
    }

    public void sendMail(String from, String to, String subject, String template, Context context) {
        final String content = templateEngine.process(template, context);

        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content, true);

            this.mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("Error sending password mail.", e);
        }
    }
}