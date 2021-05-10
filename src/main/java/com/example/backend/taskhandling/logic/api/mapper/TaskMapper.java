package com.example.backend.taskhandling.logic.api.mapper;

import com.example.backend.taskhandling.dataaccess.api.entity.TaskEntity;
import com.example.backend.taskhandling.logic.api.to.TaskEto;
import com.example.backend.taskhandling.logic.api.to.TaskTo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskEntity toTaskEntity(TaskTo taskTo);

    @Mappings({
        @Mapping(target = "finalDate", source = "finalDate", dateFormat = "yyyy-MM-dd")})
    TaskEto toTaskEto(TaskEntity taskEntity);
}
