package com.example.scheduler.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment implements Serializable {
    private String id;
    private String patientName;
    private LocalDateTime dateTime;
}
