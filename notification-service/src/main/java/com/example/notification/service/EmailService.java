package com.example.notification.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendAppointmentReminder(String to, String patientName, LocalDateTime dateTime) {
        System.out.println("Agendamento recebido!");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Lembrete de Consulta");
        message.setText("Olá " + patientName + ", sua consulta está marcada para " + dateTime);
        mailSender.send(message);
    }
}

