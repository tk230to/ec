package com.example.ec.security;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_ANONYMOUS, ROLE_USER, ROLE_ADMIN;

    public static final String ANONYMOUS = "ANONYMOUS";
    public static final String USER = "USER";
    public static final String ADMIN = "ADMIN";

    @Override
    public String getAuthority() {
        return name();
    }
}
