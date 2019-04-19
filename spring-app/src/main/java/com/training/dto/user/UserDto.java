package com.training.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    private int id;
    private String username;
    private String password;
    /*private Role roles;
    private int active;*/

    UserDto(UserDto user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        /*this.roles = user.getRoles();
        this.active = user.getActive();*/
    }
}