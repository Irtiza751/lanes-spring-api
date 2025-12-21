package com.irtiza.lanes.mappers;

import com.irtiza.lanes.dtos.CreateUserDto;
import com.irtiza.lanes.dtos.UserResponseDto;
import com.irtiza.lanes.models.User;
import org.mapstruct.*;

@Mapper(componentModel = "Spring")
public interface UserMapper {
    UserResponseDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "projects", ignore = true)
    @Mapping(target = "projectMembers", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateUserFromDto(CreateUserDto userDto, @MappingTarget User user);
}
