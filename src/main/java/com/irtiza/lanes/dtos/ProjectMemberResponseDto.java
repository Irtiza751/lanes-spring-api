package com.irtiza.lanes.dtos;

import com.irtiza.lanes.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectMemberResponseDto {
    private UserResponseDto member;
    private ProjectResponseDto project;
    private Role role;
}
