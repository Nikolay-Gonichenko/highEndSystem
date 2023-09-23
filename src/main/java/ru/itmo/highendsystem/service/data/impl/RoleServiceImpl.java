package ru.itmo.highendsystem.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.RoleMapper;
import ru.itmo.highendsystem.model.dto.full.FullRoleDto;
import ru.itmo.highendsystem.model.entity.Role;
import ru.itmo.highendsystem.repository.RoleRepository;
import ru.itmo.highendsystem.service.data.RoleService;

/**
 * Реализация {@link ru.itmo.highendsystem.service.data.RoleService}
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public FullRoleDto getRoleById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(Role.class, id));
        return roleMapper.roleToFullDto(role);
    }
}
