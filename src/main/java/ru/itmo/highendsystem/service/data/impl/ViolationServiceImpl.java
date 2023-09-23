package ru.itmo.highendsystem.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.mapper.ViolationMapper;
import ru.itmo.highendsystem.model.dto.full.FullViolationDto;
import ru.itmo.highendsystem.repository.ViolationRepository;
import ru.itmo.highendsystem.service.data.ViolationService;

/**
 * Реализация {@link ru.itmo.highendsystem.service.data.ViolationService}
 */
@Service
public class ViolationServiceImpl implements ViolationService {
    @Autowired
    private ViolationRepository violationRepository;
    @Autowired
    private ViolationMapper violationMapper;

    @Override
    public void saveViolation(FullViolationDto violationDto) {
        violationRepository.save(violationMapper.fullDtoToViolation(violationDto));
    }
}
