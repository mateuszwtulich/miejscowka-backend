package com.example.backend.taskhandling.logic.api.to;

import com.example.backend.general.dataaccess.api.entity.AbstractApplicationEntityTransportObject;
import com.example.backend.userhandling.logic.api.to.SimpleUserTo;
import com.sun.istack.NotNull;

import java.util.Objects;

public class TaskEto  extends AbstractApplicationEntityTransportObject {

    @NotNull
    private String name;

    @NotNull
    private String finalDate;

    @NotNull
    private SimpleUserTo userTo;

    public TaskEto() {
    }

    public TaskEto(Long id, String name, String finalDate, SimpleUserTo userTo) {
        super(id);
        this.name = name;
        this.finalDate = finalDate;
        this.userTo = userTo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(String finalDate) {
        this.finalDate = finalDate;
    }

    public SimpleUserTo getUserTo() {
        return userTo;
    }

    public void setUserTo(SimpleUserTo userTo) {
        this.userTo = userTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskEto)) return false;
        if (!super.equals(o)) return false;
        TaskEto taskEto = (TaskEto) o;
        return name.equals(taskEto.name) &&
                finalDate.equals(taskEto.finalDate)
                && Objects.equals(userTo, taskEto.userTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, finalDate, userTo);
    }
}
