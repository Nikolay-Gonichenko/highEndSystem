package ru.itmo.highendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.highendsystem.model.entity.FlightStatus;

/**
 * Репозиторий сущности "Статус полёта"
 */
@Repository
public interface FlightStatusRepository extends JpaRepository<FlightStatus, Long> {
}
