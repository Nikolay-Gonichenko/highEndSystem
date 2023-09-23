package ru.itmo.highendsystem.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.mapper.CrewMapper;
import ru.itmo.highendsystem.model.dto.full.FullCrewDto;
import ru.itmo.highendsystem.repository.CrewRepository;
import ru.itmo.highendsystem.service.data.CrewService;

/**
 * Реализация {@link ru.itmo.highendsystem.service.data.CrewService}
 */
@Service
public class CrewServiceImpl implements CrewService {
    @Autowired
    private CrewRepository crewRepository;
    @Autowired
    private CrewMapper crewMapper;

    @Override
    public Boolean saveCrew(FullCrewDto crewDto) {
        crewRepository.save(crewMapper.fullDtoToCrew(crewDto));
        return true;
    }
}
