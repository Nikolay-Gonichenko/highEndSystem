package ru.itmo.highendsystem.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.EmployeeMapper;
import ru.itmo.highendsystem.model.dto.full.FullEmployeeDto;
import ru.itmo.highendsystem.model.entity.Employee;
import ru.itmo.highendsystem.repository.EmployeeRepository;
import ru.itmo.highendsystem.service.data.EmployeeService;

/**
 * Реализация {@link ru.itmo.highendsystem.service.data.EmployeeService}
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public boolean saveEmployee(FullEmployeeDto employeeDto) {
        employeeRepository.save(employeeMapper.fullDtoToEmployee(employeeDto));
        return true;
    }

    @Override
    public FullEmployeeDto getById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(Employee.class, id));
        return employeeMapper.employeeToFullDto(employee);
    }
}
