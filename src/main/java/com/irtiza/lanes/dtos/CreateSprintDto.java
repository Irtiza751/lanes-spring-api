package com.irtiza.lanes.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSprintDto {
    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "cannot be null")
    private Boolean isActive;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @NotBlank(message = "project id is required")
    private String projectId;
}
