package com.irtiza.lanes.mappers;

import com.irtiza.lanes.dtos.SprintResponseDto;
import com.irtiza.lanes.models.Sprint;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface SprintMapper {
    SprintResponseDto toDto(Sprint sprint);
}
