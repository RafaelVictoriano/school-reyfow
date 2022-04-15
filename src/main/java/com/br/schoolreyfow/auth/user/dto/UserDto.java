package com.br.schoolreyfow.auth.user.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class UserDto implements Serializable {
    private final String email;
    private final String name;
    private final String password;
    private final Set<String> roleAuthorities;
}
