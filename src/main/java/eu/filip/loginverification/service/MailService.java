package eu.filip.loginverification.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
@AllArgsConstructor
@Slf4j
public class MailService {
    private JavaMailSender javaMailSender;

    public void sendMail(String to, String subject, String body) throws MessagingException {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("szymanski.fp@gmail.com");
        mailMessage.setTo("szymanski.fp@gmail.com");
        mailMessage.setText(body);
        mailMessage.setSubject(subject);

        javaMailSender.send(mailMessage);
        log.info("MAIL SENT");
    }
}
