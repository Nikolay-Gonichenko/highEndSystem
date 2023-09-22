package ru.itmo.highendsystem.mapper;


import org.mapstruct.Mapper;
import ru.itmo.highendsystem.model.dto.full.FullDepartmentDto;
import ru.itmo.highendsystem.model.entity.Department;

/**
 * Мапер департамента
 */
@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    FullDepartmentDto departmentToFullDto(Department department);
}
