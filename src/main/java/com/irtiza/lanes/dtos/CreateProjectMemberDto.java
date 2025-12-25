package com.irtiza.lanes.dtos;

import com.irtiza.lanes.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProjectMemberDto {
    @NotBlank
    @NotNull
    private String projectId;

    @NotNull
    @NotBlank
    private String userId;

    @NotNull
    private Role role;
}
