package ru.itmo.highendsystem.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.mapper.ErrorMapper;
import ru.itmo.highendsystem.model.dto.full.FullErrorDto;
import ru.itmo.highendsystem.repository.ErrorRepository;
import ru.itmo.highendsystem.service.data.ErrorService;

/**
 * реализация {@link ErrorService}
 */
@Service
public class ErrorServiceImpl implements ErrorService {

    @Autowired
    private ErrorRepository errorRepository;
    @Autowired
    private ErrorMapper errorMapper;

    @Override
    public void saveError(FullErrorDto fullErrorDto) {
        errorRepository.save(errorMapper.fullDtoToError(fullErrorDto));
    }
}
