package ru.itmo.highendsystem.service.data.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.HumanMapper;
import ru.itmo.highendsystem.model.dto.full.FullHumanDto;
import ru.itmo.highendsystem.model.entity.Human;
import ru.itmo.highendsystem.repository.HumanRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HumanServiceImplTest {
    @Mock
    private HumanRepository humanRepository;
    @Mock
    private HumanMapper humanMapper;

    @InjectMocks
    private HumanServiceImpl humanService;

    @Test
    public void getHumanByIdCorrectTest() {
        long id = 1L;
        String name = "test";
        Human human = new Human();
        human.setId(id);
        human.setName(name);
        when(humanRepository.findById(id)).thenReturn(Optional.of(human));
        FullHumanDto fullHumanDto = new FullHumanDto();
        fullHumanDto.setId(id);
        fullHumanDto.setName(name);
        when(humanMapper.humanToFullDto(human)).thenReturn(fullHumanDto);

        FullHumanDto expected = humanService.getHumanById(id);
        assertEquals(expected.getId(), id);
        assertEquals(expected.getName(), name);
    }

    @Test
    public void getHumanByIdShouldThrowException() {
        long id = 1L;
        when(humanRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(NotFoundEntityByIdException.class,
                () -> humanService.getHumanById(id));
    }
}
