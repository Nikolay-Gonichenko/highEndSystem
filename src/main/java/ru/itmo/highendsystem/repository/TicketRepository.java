package ru.itmo.highendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.highendsystem.model.entity.Ticket;

/**
 * Репозиторий сущности "Билет"
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
