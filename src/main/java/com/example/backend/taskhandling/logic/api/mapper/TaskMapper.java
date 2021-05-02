package com.example.backend.taskhandling.logic.api.mapper;

import com.example.backend.taskhandling.dataaccess.api.entity.TaskEntity;
import com.example.backend.taskhandling.logic.api.to.TaskEto;
import com.example.backend.taskhandling.logic.api.to.TaskTo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskEntity toTaskEntity(TaskTo taskTo);

    TaskEto toTaskEto(TaskEntity taskEntity);
}
