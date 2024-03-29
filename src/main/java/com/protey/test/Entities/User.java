package com.protey.test.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;


@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    @Column(name = "username")
    @NotEmpty(message = "Please provide a username")
    private String username;
    @Column(name = "email")
    @NotEmpty(message = "Please provide a email")
    private String email;
    @Column(name = "phone_number")
    @NotEmpty(message = "Please provide a phone number")
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "online_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date onlineTime;

    public User() {
    }

    public User(String username, String email, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = Status.Online;
        this.onlineTime = new Date();
    }

    public User(String username, String email, String phoneNumber, Status status) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.onlineTime = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status=" + status +
                ", onlineTime=" + onlineTime +
                '}';
    }
}

