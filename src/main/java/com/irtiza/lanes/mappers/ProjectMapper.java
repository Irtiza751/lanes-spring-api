package com.irtiza.lanes.mappers;

import com.irtiza.lanes.dtos.CreateProjectDto;
import com.irtiza.lanes.dtos.ProjectResponseDto;
import com.irtiza.lanes.models.Project;
import org.mapstruct.*;

@Mapper(componentModel = "Spring", uses = {UserMapper.class})
public interface ProjectMapper {
    ProjectResponseDto toDto(Project project);

    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            unmappedTargetPolicy = ReportingPolicy.IGNORE
    )
    void updateProjectFromDto(CreateProjectDto dto, @MappingTarget Project project);
}
