package ru.itmo.highendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.highendsystem.model.entity.Crew;
import ru.itmo.highendsystem.model.entity.pk.CrewPk;

/**
 * Репозиторий сущности "Экипаж судна"
 */
@Repository
public interface CrewRepository extends JpaRepository<Crew, CrewPk> {
}
