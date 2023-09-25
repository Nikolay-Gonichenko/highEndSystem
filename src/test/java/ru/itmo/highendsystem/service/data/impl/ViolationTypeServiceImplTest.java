package ru.itmo.highendsystem.service.data.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.ViolationTypeMapper;
import ru.itmo.highendsystem.model.dto.full.FullViolationTypeDto;
import ru.itmo.highendsystem.model.entity.ViolationType;
import ru.itmo.highendsystem.repository.ViolationTypeRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ViolationTypeServiceImplTest {

    @Mock
    private ViolationTypeRepository violationTypeRepository;

    @Mock
    private ViolationTypeMapper violationTypeMapper;

    @InjectMocks
    private ViolationTypeServiceImpl violationTypeService;

    @Test
    public void getViolationTypeByIdCorrectTest() {
        long id = 1L;
        String name = "test";
        ViolationType violationType = new ViolationType(id, name);
        when(violationTypeRepository.findById(id)).thenReturn(Optional.of(violationType));
        when(violationTypeMapper.violationTypeToFullDto(violationType)).thenReturn(new FullViolationTypeDto(id, name));

        FullViolationTypeDto expected = violationTypeService.getViolationTypeById(id);
        assertEquals(expected.getId(), id);
        assertEquals(expected.getName(), name);
    }

    @Test
    public void getViolationTypeByIdShouldThrowException() {
        long id = 1L;
        when(violationTypeRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(NotFoundEntityByIdException.class,
                () -> violationTypeService.getViolationTypeById(id));
    }
}
