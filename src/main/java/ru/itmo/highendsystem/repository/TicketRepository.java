package ru.itmo.highendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.highendsystem.model.entity.Flight;
import ru.itmo.highendsystem.model.entity.Ticket;

import java.util.List;

/**
 * Репозиторий сущности "Билет"
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByFlightId(Long flight);

    List<Ticket> findAllByHumanId(Long human);
}
