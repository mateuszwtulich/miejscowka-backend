package com.example.backend.taskhandling.logic.api.to;

import com.example.backend.general.dataaccess.api.entity.AbstractApplicationEntityTransportObject;
import com.sun.istack.NotNull;

import java.util.Date;
import java.util.Objects;

public class TaskEto  extends AbstractApplicationEntityTransportObject {

    @NotNull
    private String name;

    @NotNull
    private Date finalDate;

    public TaskEto() {
    }

    public TaskEto(Long id, String name, Date finalDate) {
        super(id);
        this.name = name;
        this.finalDate = finalDate;
    }

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
        if (!(o instanceof TaskEto)) return false;
        if (!super.equals(o)) return false;
        TaskEto taskEto = (TaskEto) o;
        return name.equals(taskEto.name) &&
                finalDate.equals(taskEto.finalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, finalDate);
    }
}
