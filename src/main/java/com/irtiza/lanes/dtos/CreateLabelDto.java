package com.irtiza.lanes.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLabelDto {
    @NotBlank(message = "Project id is required")
    private String projectId;
    @NotBlank(message = "Name is required")
    private String name;
    private String color;
}
