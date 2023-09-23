package ru.itmo.highendsystem.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.ViolationTypeMapper;
import ru.itmo.highendsystem.model.dto.full.FullViolationTypeDto;
import ru.itmo.highendsystem.model.entity.ViolationType;
import ru.itmo.highendsystem.repository.ViolationTypeRepository;
import ru.itmo.highendsystem.service.data.ViolationTypeService;

/**
 * Реализация {@link ViolationTypeService}
 */
@Service
public class ViolationTypeServiceImpl implements ViolationTypeService {

    @Autowired
    private ViolationTypeRepository violationTypeRepository;
    @Autowired
    private ViolationTypeMapper violationTypeMapper;

    @Override
    public FullViolationTypeDto getViolationTypeById(Long id) {
        ViolationType violationType = violationTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(ViolationType.class, id));
        return violationTypeMapper.violationTypeToFullDto(violationType);
    }
}
