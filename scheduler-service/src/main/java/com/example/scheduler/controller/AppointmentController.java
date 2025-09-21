package com.example.scheduler.controller;

import com.example.scheduler.model.Appointment;
import com.example.scheduler.service.AppointmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public String create(@RequestBody Appointment appointment) {
        appointmentService.createAppointment(appointment);
        return "Agendamento criado!";
    }
}
