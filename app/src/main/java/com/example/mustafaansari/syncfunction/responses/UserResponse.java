package com.example.mustafaansari.syncfunction.responses;

import com.example.mustafaansari.syncfunction.model.User;

import java.util.List;

public class UserResponse {

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    private List<User> userList;
}
