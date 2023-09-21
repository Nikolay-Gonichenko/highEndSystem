package ru.itmo.highendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.highendsystem.model.entity.Violation;

/**
 * Репозиторий сущности "Нарушение"
 */
@Repository
public interface ViolationRepository extends JpaRepository<Violation, Long> {
}
