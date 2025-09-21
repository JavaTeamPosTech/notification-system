package com.example.notification.listener;

import com.example.events.Appointment;
import com.example.notification.service.EmailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AppointmentListener {

    private final EmailService emailService;

    public AppointmentListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "DEV_project_status_changed_1_0_pu", containerFactory = "kafkaListenerContainerFactory")
    public void listen(Appointment appointment) {
        // Recebendo diretamente como objeto
        System.out.println("Recebido: " + appointment.getPatientName() +
                " às " + appointment.getDateTime());

        emailService.sendAppointmentReminder(
                "paciente@example.com",
                appointment.getPatientName(),
                appointment.getDateTime()
        );
    }
}
