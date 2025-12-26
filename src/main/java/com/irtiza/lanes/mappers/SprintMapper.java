package com.irtiza.lanes.mappers;

import com.irtiza.lanes.dtos.CreateSprintDto;
import com.irtiza.lanes.dtos.SprintResponseDto;
import com.irtiza.lanes.dtos.UpdateSprintDto;
import com.irtiza.lanes.models.Sprint;
import org.mapstruct.*;

@Mapper(componentModel = "Spring")
public interface SprintMapper {
    SprintResponseDto toDto(Sprint sprint);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "project", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSprint(UpdateSprintDto dto, @MappingTarget Sprint target);
}
