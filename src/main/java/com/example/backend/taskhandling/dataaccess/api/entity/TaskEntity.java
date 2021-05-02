package com.example.backend.taskhandling.dataaccess.api.entity;


import com.example.backend.general.dataaccess.api.entity.AbstractApplicationPersistenceEntity;
import com.example.backend.userhandling.dataaccess.api.entity.UserEntity;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TASK")
public class TaskEntity extends AbstractApplicationPersistenceEntity {
    private static final long serialVersionUID = 1L;

    public  TaskEntity() {

    }

    public TaskEntity(String name, Date finalDate, UserEntity user){
        this.name = name;
        this.finalDate = finalDate;
        this.user = user;
    }

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(name = "FINAL_DATE", nullable = false)
    private Date finalDate;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", nullable = false, referencedColumnName = "id")
    private UserEntity user;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
       if (this == o) return true;
       if(!(o instanceof  TaskEntity)) return false;
       TaskEntity that = (TaskEntity) o;
       return name.equals(that.name) && finalDate.equals(that.finalDate) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, finalDate, user);
    }
}
