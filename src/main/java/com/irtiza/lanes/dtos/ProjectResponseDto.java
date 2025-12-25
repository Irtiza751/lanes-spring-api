package com.irtiza.lanes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponseDto {
    private String id;
    private String name;
    private String key;
    private String description;
    private UserResponseDto owner;
}
