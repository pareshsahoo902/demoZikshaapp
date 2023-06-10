package com.example.myapplication;

public class UserModel {

    public String id;
    public String username;

    public Boolean isOnline;

    public UserModel() {
    }

    public UserModel(String id, String username, Boolean isOnline) {
        this.id = id;
        this.username = username;
        this.isOnline = isOnline;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
