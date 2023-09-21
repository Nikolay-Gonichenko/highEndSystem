package ru.itmo.highendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.highendsystem.model.entity.Account;

/**
 * Репозиторий сущности "Аккаунт пользователя"
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
