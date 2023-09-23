package ru.itmo.highendsystem.service.data;

import ru.itmo.highendsystem.model.dto.full.FullDocumentTypeDto;

/**
 * Сервис для работы с сущностью типа документа
 */
public interface DocumentTypeService {

    /**
     * Получение типа документа по id
     * @param id идентификатор типа документа
     * @return полное дто типа документа
     */
    FullDocumentTypeDto getDocumentTypeById(Long id);
}
