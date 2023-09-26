package ru.itmo.highendsystem.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.ErrorTypeMapper;
import ru.itmo.highendsystem.model.dto.full.FullErrorTypeDto;
import ru.itmo.highendsystem.model.entity.ErrorType;
import ru.itmo.highendsystem.repository.ErrorTypeRepository;
import ru.itmo.highendsystem.service.data.ErrorTypeService;

/**
 * реализация {@link ru.itmo.highendsystem.service.data.ErrorTypeService}
 */
@Service
public class ErrorTypeServiceImpl implements ErrorTypeService {
    @Autowired
    private ErrorTypeMapper errorTypeMapper;
    @Autowired
    private ErrorTypeRepository errorTypeRepository;


    @Override
    public FullErrorTypeDto getErrorTypeById(Long id) {
        ErrorType errorType = errorTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(ErrorType.class, id));
        return errorTypeMapper.errorTypeToFullDto(errorType);
    }
}
