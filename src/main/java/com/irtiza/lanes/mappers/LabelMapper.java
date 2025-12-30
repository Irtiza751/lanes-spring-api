package com.irtiza.lanes.mappers;

import com.irtiza.lanes.dtos.CreateLabelDto;
import com.irtiza.lanes.dtos.LabelResponseDto;
import com.irtiza.lanes.models.Label;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "Spring")
public interface LabelMapper {
    LabelResponseDto toDto(Label label);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "project", ignore = true)
    @Mapping(target = "issues", ignore = true)
    void updateLabel(CreateLabelDto labelDto, @MappingTarget Label label);
}
