package com.example.notification.listener;

import com.example.notification.model.Appointment;
import com.example.notification.service.EmailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

@Component
public class AppointmentListener {

    private final EmailService emailService;

    public AppointmentListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "appointments", containerFactory = "kafkaListenerContainerFactory")
    public void listen(Map<String, Object> payload) {
        // Converte manualmente para sua classe local
        Appointment appointment = new Appointment();
        appointment.setId((String) payload.get("id"));
        appointment.setPatientName((String) payload.get("patientName"));
        appointment.setDateTime(LocalDateTime.parse((String) payload.get("dateTime")));

        System.out.println("Recebido: " + appointment.getPatientName() +
                " às " + appointment.getDateTime());

        emailService.sendAppointmentReminder(
                "paciente@example.com",
                appointment.getPatientName(),
                appointment.getDateTime()
        );
    }
}
