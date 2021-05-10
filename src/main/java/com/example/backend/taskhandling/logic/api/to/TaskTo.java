package com.example.backend.taskhandling.logic.api.to;

import com.sun.istack.NotNull;

import java.sql.Timestamp;
import java.util.Objects;

public class TaskTo {

    public TaskTo() {
    }

    public TaskTo(String name, Timestamp finalDate, Long userId) {
        this.name = name;
        this.finalDate = finalDate;
        this.userId = userId;
    }

    @NotNull
    private String name;

    @NotNull
    private Timestamp finalDate;

    @NotNull
    private Long userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Timestamp finalDate) {
        this.finalDate = finalDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskTo)) return false;
        TaskTo taskTo = (TaskTo) o;
        return name.equals(taskTo.name) &&
                finalDate.equals(taskTo.finalDate) &&
                userId.equals(taskTo.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, finalDate);
    }
}
