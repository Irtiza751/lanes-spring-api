package com.irtiza.lanes.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProjectDto {
    @NotBlank
    private String name;
    private String key;
    private String description;
    @NotBlank
    private String ownerId;
}
