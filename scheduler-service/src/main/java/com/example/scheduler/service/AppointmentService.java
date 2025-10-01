package com.example.scheduler.service;

import com.example.events.Appointment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    private final KafkaTemplate<String, Appointment> kafkaTemplate;

    public AppointmentService(KafkaTemplate<String, Appointment> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void createAppointment(Appointment appointment) {
        System.out.println("Mensagem recebida: " + appointment.getPatientName());
        kafkaTemplate.send("DEV_project_status_changed_1_0_pu", appointment);
        System.out.println("Mensagem enviada: " + appointment.getPatientName());

    }
}
