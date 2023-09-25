package ru.itmo.highendsystem.service.data.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.RoleMapper;
import ru.itmo.highendsystem.model.dto.full.FullRoleDto;
import ru.itmo.highendsystem.model.entity.Role;
import ru.itmo.highendsystem.repository.RoleRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RoleServiceImplTest {
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private RoleMapper roleMapper;

    @InjectMocks
    private RoleServiceImpl roleService;

    @Test
    public void getRoleByIdCorrectTest() {
        long id = 1L;
        String name = "test";
        Role role = new Role(id, name);
        when(roleRepository.findById(id)).thenReturn(Optional.of(role));
        when(roleMapper.roleToFullDto(role)).thenReturn(new FullRoleDto(id, name));

        FullRoleDto expected = roleService.getRoleById(id);
        assertEquals(expected.getId(), id);
        assertEquals(expected.getName(), name);
    }

    @Test
    public void getRoleByIdShouldThrowException() {
        long id = 1L;
        when(roleRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(NotFoundEntityByIdException.class,
                () -> roleService.getRoleById(id));
    }
}
