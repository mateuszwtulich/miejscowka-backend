package com.example.backend.taskhandling.service.impl.ui;

import com.example.backend.general.logic.api.exception.EntityAlreadyExistsException;
import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.taskhandling.logic.api.TaskHandling;
import com.example.backend.taskhandling.logic.api.to.TaskEto;
import com.example.backend.taskhandling.logic.api.to.TaskTo;
import com.example.backend.taskhandling.logic.impl.TaskHandlingImpl;
import com.example.backend.taskhandling.service.api.ui.TaskRestService;
import com.example.backend.userhandling.logic.api.exception.AccountAlreadyExistsException;
import com.example.backend.userhandling.logic.api.exception.RoleHasAssignedUsersException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.inject.Inject;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class TaskRestServiceImpl implements TaskRestService {
    private static String TASKS_NOT_EXIST = "Tasks do not exist.";
    private static final String BASE_URL = "task/v1/";

    @Inject
    private TaskHandlingImpl taskHandling;

    @Override
    public ResponseEntity<TaskEto> getTask(Long id) {
        try {
            return ResponseEntity
                    .ok()
                    .body(taskHandling.findTask(id).orElseThrow(() ->
                            new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)));
        } catch (EntityDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @Override
    public List<TaskEto> getAllTasks() {
        return taskHandling.findAllTasks().map( taskEtos -> {
            if(taskEtos.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NO_CONTENT, TASKS_NOT_EXIST);
            }
            return taskEtos;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Override
    public List<TaskEto> getAllTasksByUserId(Long userId) {
        return taskHandling.findAllTasksByUserId(userId).map( taskEtos -> {
            if(taskEtos.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Tasks with user id " + userId + " do not exist.");
            }
            return taskEtos;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Override
    public ResponseEntity<TaskEto> createTask(TaskTo taskTo, HttpServletRequest request, Errors errors) {
        try {
            return ResponseEntity
                    .created(new URI(BASE_URL + "/task"))
                    .body(taskHandling.createTask(taskTo).orElseThrow(() ->
                            new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)));
        } catch (EntityAlreadyExistsException | URISyntaxException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
        } catch (EntityDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @Override
    public ResponseEntity<TaskEto> updateTask(Long id, TaskTo taskTo) {
        try {
            return ResponseEntity
                    .ok()
                    .body(taskHandling.updateTask(taskTo, id).orElseThrow(() ->
                            new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)));
        } catch (EntityDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> deleteTask(Long id) {
        try {
            taskHandling.deleteTask(id);
            return ResponseEntity.ok().build();
        } catch (EntityDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } 
    }
}
