package com.example.backend.taskhandling.logic.api.to;

import com.sun.istack.NotNull;

import java.util.Date;
import java.util.Objects;

public class TaskTo {

    public TaskTo() {
    }

    public TaskTo(String name, Date finalDate) {
        this.name = name;
        this.finalDate = finalDate;
    }

    @NotNull
    private String name;

    @NotNull
    private Date finalDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskTo)) return false;
        TaskTo taskTo = (TaskTo) o;
        return name.equals(taskTo.name) &&
                finalDate.equals(taskTo.finalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, finalDate);
    }
}
