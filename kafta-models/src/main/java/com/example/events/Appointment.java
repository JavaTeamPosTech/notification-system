package com.example.events;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;


import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    private String id;
    private String patientName;
    private LocalDateTime dateTime;
}
