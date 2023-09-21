package ru.itmo.highendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.highendsystem.model.entity.Human;

/**
 * Репозиторий сущности "Человек"
 */
@Repository
public interface HumanRepository extends JpaRepository<Human, Long> {
}
