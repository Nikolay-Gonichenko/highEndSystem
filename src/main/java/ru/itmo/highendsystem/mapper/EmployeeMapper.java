package ru.itmo.highendsystem.mapper;

import org.mapstruct.Mapper;
import ru.itmo.highendsystem.model.dto.full.FullEmployeeDto;
import ru.itmo.highendsystem.model.entity.Employee;

/**
 * Мапер сущности Работник
 */
@Mapper(componentModel = "spring", uses = {AccountMapper.class, PositionMapper.class})
public interface EmployeeMapper {

    Employee fullDtoToEmployee(FullEmployeeDto employee);
}
