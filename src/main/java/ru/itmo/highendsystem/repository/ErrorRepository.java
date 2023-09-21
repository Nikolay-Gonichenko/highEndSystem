package ru.itmo.highendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.highendsystem.model.entity.Error;

/**
 * Репозиторий сущности "Ошибка"
 */
@Repository
public interface ErrorRepository extends JpaRepository<Error, Long> {
}
