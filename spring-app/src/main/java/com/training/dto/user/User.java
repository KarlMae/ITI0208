package com.training.dto.user;

import lombok.Data;

@Data
public class User {

    private int id;
    private String username;
    private String password;
    private Role roles;
    private int active;

    User(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roles = user.getRoles();
        this.active = user.getActive();
    }
}