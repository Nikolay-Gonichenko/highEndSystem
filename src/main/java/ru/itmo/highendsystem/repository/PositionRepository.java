package ru.itmo.highendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.highendsystem.model.entity.Position;

/**
 * Репозиторий сущности "Позиция"
 */
@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
}
