package ru.itmo.highendsystem.service.data.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.PositionMapper;
import ru.itmo.highendsystem.model.dto.full.FullDepartmentDto;
import ru.itmo.highendsystem.model.dto.full.FullPositionDto;
import ru.itmo.highendsystem.model.entity.Department;
import ru.itmo.highendsystem.model.entity.Position;
import ru.itmo.highendsystem.repository.PositionRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PositionServiceImplTest {
    @Mock
    private PositionMapper positionMapper;
    @Mock
    private PositionRepository positionRepository;

    @InjectMocks
    private PositionServiceImpl positionService;

    @Test
    public void getPositionByIdCorrectTest() {
        long id = 1L;
        String name = "test";
        Department department = new Department(id, name);
        Position position = new Position(id, name, department);
        when(positionRepository.findById(id)).thenReturn(Optional.of(position));
        when(positionMapper.positionToFullDto(position)).thenReturn(new FullPositionDto(id, name,
                new FullDepartmentDto(id, name)));

        FullPositionDto expected = positionService.getPositionById(id);
        assertEquals(expected.getId(), id);
        assertEquals(expected.getName(), name);
    }

    @Test
    public void getPositionByIdShouldThrowException() {
        long id = 1L;
        when(positionRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(NotFoundEntityByIdException.class,
                () -> positionService.getPositionById(id));
    }
}
