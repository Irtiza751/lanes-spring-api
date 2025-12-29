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
public class StatusResponseDto {
    private String id;
    private String name;
    private Integer position;
    private StatusCategory category;
}
