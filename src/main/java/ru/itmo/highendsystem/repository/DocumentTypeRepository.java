package ru.itmo.highendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.highendsystem.model.entity.DocumentType;

/**
 * Репозиторий сущности "Тип документа"
 */
@Repository
public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {
}
