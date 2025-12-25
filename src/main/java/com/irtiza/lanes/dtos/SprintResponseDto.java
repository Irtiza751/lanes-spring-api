package com.irtiza.lanes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SprintResponseDto {
    private String id;
    private String name;
    private Boolean isActive;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
