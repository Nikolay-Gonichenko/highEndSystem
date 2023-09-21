package ru.itmo.highendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.highendsystem.model.entity.Department;

/**
 * Репозиторий сущности "Департамент"
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
