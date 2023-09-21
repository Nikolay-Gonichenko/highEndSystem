package ru.itmo.highendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.highendsystem.model.entity.Role;

/**
 * Репозиторий сущности "Роль"
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
