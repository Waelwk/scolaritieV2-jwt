package com.project.scolarite.services;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.project.scolarite.entities.User;
import com.project.scolarite.repos.UserRepository;

@Service
public class EmailVerificationService {
    private static final long EXPIRATION_TIME_MS = 30 * 60 * 1000; // 30 minutes
    private static final String VERIFICATION_EMAIL_SUBJECT = "Email Verification";
    private static final String VERIFICATION_EMAIL_BODY = "Click the link to verify your email: ";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendVerificationEmail(User user) {
        // Generate a verification token
        String verificationToken = UUID.randomUUID().toString();

        // Set the token and expiration time in the user entity
        user.setVerificationToken(verificationToken);
        user.setTokenExpirationTime(Instant.now().plusMillis(EXPIRATION_TIME_MS));

        // Save the updated user entity
        userRepository.save(user);

        // Compose the verification email
        String emailBody = VERIFICATION_EMAIL_BODY + ""+getVerificationUrl(user);

        // Send the verification email
        sendEmail(user.getEmail(), VERIFICATION_EMAIL_SUBJECT, emailBody);
    }

    private void sendEmail(String recipientEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject(subject);
        message.setText(body);

        javaMailSender.send(message);
    }

    private String getVerificationUrl(User user) {
        // Construct the verification URL based on your application's endpoint
        return "http://localhost:8080/apprenant/api/apprenant/verify-email?token=" + user.getVerificationToken();
    }

    public void verifyEmail(String token) {
        User user = userRepository.findByVerificationToken(token);

        if (user == null) {
            throw new IllegalArgumentException("dd");
        }

        if (user.getTokenExpirationTime().isBefore(Instant.now())) {
            throw new IllegalArgumentException("Verification token has expired.");
        }

        user.setVerified(true);
        user.setVerificationToken(null);
        user.setTokenExpirationTime(null);
        userRepository.save(user);
    }
}

