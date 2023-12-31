package com.example.StudentInformationSystem.util.constants;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {

    USER("ROLE_STUDENT"),ADMIN("ROLE_ADMIN"),FACULTY("ROLE_TEACHER");

    private String role;
    private Roles(String role){
        this.role=role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
