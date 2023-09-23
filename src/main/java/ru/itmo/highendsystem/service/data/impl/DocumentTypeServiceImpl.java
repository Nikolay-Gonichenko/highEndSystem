package ru.itmo.highendsystem.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.DocumentTypeMapper;
import ru.itmo.highendsystem.model.dto.full.FullDocumentTypeDto;
import ru.itmo.highendsystem.model.entity.DocumentType;
import ru.itmo.highendsystem.repository.DocumentTypeRepository;
import ru.itmo.highendsystem.service.data.DocumentTypeService;

/**
 * Реализация {@link ru.itmo.highendsystem.service.data.DocumentTypeService}
 */
@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {
    @Autowired
    private DocumentTypeRepository documentTypeRepository;
    @Autowired
    private DocumentTypeMapper documentTypeMapper;


    @Override
    public FullDocumentTypeDto getDocumentTypeById(Long id) {
        DocumentType documentType = documentTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(DocumentType.class, id));
        return documentTypeMapper.documentTypeToFullDto(documentType);
    }
}
