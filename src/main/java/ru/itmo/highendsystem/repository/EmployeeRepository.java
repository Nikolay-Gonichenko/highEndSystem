package ru.itmo.highendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.highendsystem.model.entity.Employee;

/**
 * Репозиторий сущности "Работник авиакомпании"
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
