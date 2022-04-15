package com.br.schoolreyfow.auth.user;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Role implements GrantedAuthority {

    public static final String STUDENT = "ROLE_STUDENT";
    public static final String TEACHER = "ROLE_TEACHER";
    public static final String COORDINATOR = "ROLE_COORDINATOR";

    @Id
    private String authority;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public Role(String authority) {
        this.authority = authority;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
