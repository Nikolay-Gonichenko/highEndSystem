package ru.itmo.highendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.highendsystem.model.entity.Option;

/**
 * Репозиторий сущности "Дополнительная услуга"
 */
@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
}
