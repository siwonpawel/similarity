package com.github.siwonpawel.similarity.api.mappers;

import com.github.siwonpawel.similarity.model.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskApiMapper {

    TaskDto mapToModel(com.github.siwonpawel.similarity.api.v1.model.NewTask source);

    TaskDto mapToModel(com.github.siwonpawel.similarity.api.v1.model.Task source);

    com.github.siwonpawel.similarity.api.v1.model.TaskCreated mapToCreated(TaskDto source);

}
