package ru.itmo.highendsystem.service.data.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.DocumentTypeMapper;
import ru.itmo.highendsystem.model.dto.full.FullDocumentTypeDto;
import ru.itmo.highendsystem.model.entity.DocumentType;
import ru.itmo.highendsystem.repository.DocumentTypeRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DocumentTypeServiceImplTest {
    @Mock
    private DocumentTypeRepository documentTypeRepository;
    @Mock
    private DocumentTypeMapper documentTypeMapper;

    @InjectMocks
    private DocumentTypeServiceImpl documentTypeService;

    @Test
    public void getDocumentTypeByIdCorrectTest() {
        long id = 1L;
        String name = "test";
        DocumentType documentType = new DocumentType(id, name);
        when(documentTypeRepository.findById(id)).thenReturn(Optional.of(documentType));
        when(documentTypeMapper.documentTypeToFullDto(documentType)).thenReturn(new FullDocumentTypeDto(id, name));

        FullDocumentTypeDto expected = documentTypeService.getDocumentTypeById(id);
        assertEquals(expected.getId(), id);
        assertEquals(expected.getName(), name);
    }

    @Test
    public void getDocumentTypeByIdShouldThrowException() {
        long id = 1L;
        when(documentTypeRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(NotFoundEntityByIdException.class,
                () -> documentTypeService.getDocumentTypeById(id));
    }
}
