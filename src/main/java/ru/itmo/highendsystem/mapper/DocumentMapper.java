package ru.itmo.highendsystem.mapper;

import org.mapstruct.Mapper;
import ru.itmo.highendsystem.model.dto.full.FullDocumentDto;
import ru.itmo.highendsystem.model.entity.Document;

/**
 * Маппер документов
 */
@Mapper(componentModel = "spring", uses = {DocumentTypeMapper.class})
public interface DocumentMapper {

    FullDocumentDto documentToFullDto(Document document);
}
