package ru.itmo.highendsystem.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.model.dto.full.FullAccountDto;
import ru.itmo.highendsystem.model.dto.full.FullEmployeeDto;
import ru.itmo.highendsystem.model.dto.full.FullPositionDto;
import ru.itmo.highendsystem.model.dto.partial.ShortEmployeeDto;
import ru.itmo.highendsystem.service.business.CreateService;
import ru.itmo.highendsystem.service.data.AccountService;
import ru.itmo.highendsystem.service.data.EmployeeService;
import ru.itmo.highendsystem.service.data.PositionService;

/**
 * Реализация {@link CreateService}
 */
@Service
public class CreateServiceImpl implements CreateService {

    @Autowired
    private AccountService accountService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private EmployeeService employeeService;


    @Override
    public boolean createEmployee(ShortEmployeeDto employee) {
        FullAccountDto account = accountService.getAccountById(employee.accountId());
        FullPositionDto position = positionService.getPositionById(employee.positionId());

        FullEmployeeDto fullEmployeeDto = new FullEmployeeDto();
        fullEmployeeDto.setEmploymentDate(employee.employeeDate());
        fullEmployeeDto.setAccount(account);
        fullEmployeeDto.setPosition(position);
        fullEmployeeDto.setSalary(employee.salary());
        return employeeService.saveEmployee(fullEmployeeDto);
    }
}
