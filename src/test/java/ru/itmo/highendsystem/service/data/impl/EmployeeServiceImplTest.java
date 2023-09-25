package ru.itmo.highendsystem.service.data.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.EmployeeMapper;
import ru.itmo.highendsystem.model.dto.full.FullEmployeeDto;
import ru.itmo.highendsystem.model.entity.Employee;
import ru.itmo.highendsystem.repository.EmployeeRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private EmployeeMapper employeeMapper;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    public void getByIdCorrectTest() {
        long id = 1L;
        Employee employee = new Employee();
        employee.setId(id);
        when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
        FullEmployeeDto fullEmployeeDto = new FullEmployeeDto();
        fullEmployeeDto.setId(id);
        when(employeeMapper.employeeToFullDto(employee)).thenReturn(fullEmployeeDto);

        FullEmployeeDto expected = employeeService.getById(id);
        assertEquals(expected.getId(), id);
    }

    @Test
    public void getByIdShouldThrowException() {
        long id = 1L;
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(NotFoundEntityByIdException.class,
                () -> employeeService.getById(id));
    }
}
