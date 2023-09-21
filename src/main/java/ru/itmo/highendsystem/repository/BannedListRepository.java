package ru.itmo.highendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.highendsystem.model.entity.BannedList;

/**
 * Репозиторий сущности "Заблокированные пользователи"
 */
@Repository
public interface BannedListRepository extends JpaRepository<BannedList, Long> {
}
