package com.example.spring_JWToken.dto;

import com.example.spring_JWToken.model.Role;

import java.util.List;

public class RecoveryUserDto {
    private Integer id;
    private String email;
    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
