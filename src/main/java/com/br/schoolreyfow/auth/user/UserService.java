package com.br.schoolreyfow.auth.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository
                .findByEmail(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User with username " + username + " not found"));
    }

    public void create(String email, String name, String authority) {
        var role = new Role();
        role.setAuthority(authority);

        var user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setRoles(Set.of(role));
    }

}
