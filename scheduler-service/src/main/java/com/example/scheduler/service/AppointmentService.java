package com.example.scheduler.service;

import com.example.scheduler.model.Appointment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    private final KafkaTemplate<String, Appointment> kafkaTemplate;

    public AppointmentService(KafkaTemplate<String, Appointment> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void createAppointment(Appointment appointment) {
        kafkaTemplate.send("appointments", appointment);
        System.out.println("Mensagem enviada: " + appointment.getPatientName());
    }
}
