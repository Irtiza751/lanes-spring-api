package com.irtiza.lanes.dtos;

import com.irtiza.lanes.enums.StatusCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStatusDto {
    @NotBlank(message = "Name is required")
    private String name;
    private Integer position;
    @NotNull(message = "Category is required")
    private StatusCategory category;
    @NotBlank(message = "Project id is required")
    private String projectId;
}
