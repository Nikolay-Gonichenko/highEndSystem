package ru.itmo.highendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.highendsystem.model.entity.OptionType;

/**
 * Репозиторий сущности "Дополнительная услуга"
 */
@Repository
public interface OptionTypeRepository extends JpaRepository<OptionType, Long> {
}
