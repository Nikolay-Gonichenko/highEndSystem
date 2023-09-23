package ru.itmo.highendsystem.mapper;

import org.mapstruct.Mapper;
import ru.itmo.highendsystem.model.dto.full.FullRoleDto;
import ru.itmo.highendsystem.model.entity.Role;

/**
 * Мапер роли
 */
@Mapper(componentModel = "spring")
public interface RoleMapper {

    FullRoleDto roleToFullDto(Role role);

    Role fullDtoToRole(FullRoleDto role);
}
