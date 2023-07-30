package com.github.siwonpawel.similarity.api.mappers;

import com.github.siwonpawel.similarity.model.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskApiMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "progress", ignore = true)
    @Mapping(target = "result", ignore = true)
    TaskDto mapToModel(com.github.siwonpawel.similarity.api.v1.model.NewTask source);

    TaskDto mapToModel(com.github.siwonpawel.similarity.api.v1.model.Task source);

    com.github.siwonpawel.similarity.api.v1.model.TaskCreated mapToCreated(TaskDto source);

}
