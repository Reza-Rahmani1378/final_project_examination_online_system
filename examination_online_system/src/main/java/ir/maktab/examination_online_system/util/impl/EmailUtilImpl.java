package ir.maktab.examination_online_system.util.impl;

import ir.maktab.examination_online_system.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailUtilImpl implements EmailUtil {


    private final JavaMailSender sender;

    @Autowired
    public EmailUtilImpl(JavaMailSender sender) {
        this.sender = sender;
    }

    @Override
    public void sendEmail(String toAddress, String subject, String body) {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(toAddress);
            helper.setSubject(subject);
            helper.setText(body);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        sender.send(message);
    }
}
