package com.github.siwonpawel.similarity.mappers;

import com.github.siwonpawel.similarity.data.model.Task;
import com.github.siwonpawel.similarity.model.TaskDto;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TaskMapper {

    @Mapping(target = "position", source = "result.position")
    @Mapping(target = "matches", source = "result.matches")
    Task mapToEntity(TaskDto source);


    @Mapping(target = "result.position", source = "position")
    @Mapping(target = "result.matches", source = "matches")
    TaskDto mapToModel(Task source);

    @AfterMapping
    default void mapToModelCleanup(Task source, @MappingTarget TaskDto target) {
        if (target.getResult().getMatches() == null && target.getResult().getPosition() == null) {
            target.setResult(null);
        }
    }

}
