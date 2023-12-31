package ru.itmo.highendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.highendsystem.model.entity.Document;

/**
 * Репозиторий сущности "Документ"
 */
@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
