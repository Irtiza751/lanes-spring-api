package com.irtiza.lanes.mappers;

import com.irtiza.lanes.dtos.CreateStatusDto;
import com.irtiza.lanes.dtos.StatusResponseDto;
import com.irtiza.lanes.models.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "Spring")
public interface StatusMapper {
    StatusResponseDto toDto(Status status);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "project", ignore = true)
    void updateStatus(CreateStatusDto statusDto, @MappingTarget Status status);
}
