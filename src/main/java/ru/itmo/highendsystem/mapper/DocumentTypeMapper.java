package ru.itmo.highendsystem.mapper;

import org.mapstruct.Mapper;
import ru.itmo.highendsystem.model.dto.full.FullDocumentTypeDto;
import ru.itmo.highendsystem.model.entity.DocumentType;

/**
 * Мапер типа документа
 */
@Mapper(componentModel = "spring")
public interface DocumentTypeMapper {

    FullDocumentTypeDto documentTypeToFullDto(DocumentType documentType);
}
