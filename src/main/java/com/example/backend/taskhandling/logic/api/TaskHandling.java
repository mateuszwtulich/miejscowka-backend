package com.example.backend.taskhandling.logic.api;

import com.example.backend.taskhandling.logic.api.usecase.UcDeleteTask;
import com.example.backend.taskhandling.logic.api.usecase.UcFindTask;
import com.example.backend.taskhandling.logic.api.usecase.UcManageTask;

public interface TaskHandling extends
        UcDeleteTask,
        UcFindTask,
        UcManageTask
{
}
