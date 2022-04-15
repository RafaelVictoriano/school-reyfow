package com.br.schoolreyfow.auth.user.mapper;

import com.br.schoolreyfow.auth.user.Role;
import com.br.schoolreyfow.auth.user.User;
import com.br.schoolreyfow.auth.user.dto.UserDto;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userDtoToUser(UserDto userDto);

    @Mapping(target = "roleAuthorities", expression = "java(rolesToRoleAuthorities(user.getRoles()))")
    UserDto userToUserDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromUserDto(UserDto userDto, @MappingTarget User user);

    default Set<String> rolesToRoleAuthorities(Set<Role> roles) {
        return roles.stream().map(Role::getAuthority).collect(Collectors.toSet());
    }
}
