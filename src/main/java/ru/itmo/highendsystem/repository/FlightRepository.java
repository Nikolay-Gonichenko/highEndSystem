package ru.itmo.highendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.highendsystem.model.entity.Flight;

/**
 * Репозиторий сущности "Полёт"
 */
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
