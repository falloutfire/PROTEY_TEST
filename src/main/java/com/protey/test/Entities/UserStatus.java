package com.protey.test.Entities;

import javax.validation.constraints.NotNull;

public class UserStatus {

    @NotNull(message = "Please provide a user id")
    private long id;
    private Status oldStatus;
    @NotNull(message = "Please provide a new status user")
    private Status newStatus;

    public UserStatus() {
    }

    public UserStatus(long id, Status newStatus) {
        this.id = id;
        this.newStatus = newStatus;
    }

    public UserStatus(long id, Status oldStatus, Status newStatus) {
        this.id = id;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
    }

    public long getId() {
        return id;
    }

    public Status getOldStatus() {
        return oldStatus;
    }

    public Status getNewStatus() {
        return newStatus;
    }

    @Override
    public String toString() {
        return " id=" + id + ", new status=" + newStatus;
    }
}
