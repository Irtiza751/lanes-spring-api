package com.irtiza.lanes.mappers;

import com.irtiza.lanes.dtos.UserResponseDto;
import com.irtiza.lanes.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface UserMapper {
    UserResponseDto toDto(User user);
}
