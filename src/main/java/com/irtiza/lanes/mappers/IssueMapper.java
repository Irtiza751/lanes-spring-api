package com.irtiza.lanes.mappers;

import com.irtiza.lanes.dtos.CreateIssueDto;
import com.irtiza.lanes.dtos.IssueResponseDto;
import com.irtiza.lanes.models.Issue;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface IssueMapper {
    IssueResponseDto toDto(Issue issue);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "sprint", ignore = true)
    @Mapping(target = "project", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "reporter", ignore = true)
    @Mapping(target = "assignee", ignore = true)
    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "children", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "labels", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateIssue(CreateIssueDto dto, @MappingTarget Issue issue);
}
