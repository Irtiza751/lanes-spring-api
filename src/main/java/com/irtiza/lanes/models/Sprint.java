package com.irtiza.lanes.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "sprints")
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private Boolean isActive;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ManyToOne
    private Project project;
}
