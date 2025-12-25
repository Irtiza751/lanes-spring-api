package com.irtiza.lanes.mappers;

import com.irtiza.lanes.dtos.ProjectMemberResponseDto;
import com.irtiza.lanes.models.ProjectMember;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring", uses = {UserMapper.class, ProjectMapper.class})
public interface ProjectMemberMapper {
    ProjectMemberResponseDto toDto(ProjectMember projectMember);
}
