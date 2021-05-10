package com.example.backend.taskhandling.logic.api.to;

import com.example.backend.general.dataaccess.api.entity.AbstractApplicationEntityTransportObject;
import com.example.backend.userhandling.logic.api.to.UserEto;
import com.sun.istack.NotNull;

import java.sql.Timestamp;
import java.util.Objects;

public class TaskEto  extends AbstractApplicationEntityTransportObject {

    @NotNull
    private String name;

    @NotNull
    private Timestamp finalDate;

    @NotNull
    private UserEto userEto;

    public TaskEto() {
    }

    public TaskEto(Long id, String name, Timestamp finalDate, UserEto userEto) {
        super(id);
        this.name = name;
        this.finalDate = finalDate;
        this.userEto = userEto;
    }

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

    public UserEto getUserEto() {
        return userEto;
    }

    public void setUserEto(UserEto userEto) {
        this.userEto = userEto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskEto)) return false;
        if (!super.equals(o)) return false;
        TaskEto taskEto = (TaskEto) o;
        return name.equals(taskEto.name) &&
                finalDate.equals(taskEto.finalDate)
                && Objects.equals(userEto, taskEto.userEto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, finalDate, userEto);
    }
}
