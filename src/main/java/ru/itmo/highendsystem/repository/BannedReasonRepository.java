package ru.itmo.highendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.highendsystem.model.entity.BannedReason;

/**
 * Репозиторий сущности "Причина блокировки пользователя"
 */
@Repository
public interface BannedReasonRepository extends JpaRepository<BannedReason, Long> {
}
