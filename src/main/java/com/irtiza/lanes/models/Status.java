package com.irtiza.lanes.models;

import com.irtiza.lanes.enums.StatusCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "statuses")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private Integer position;

    @Enumerated(EnumType.STRING)
    private StatusCategory status;

    @ManyToOne
    private Project project;
}
