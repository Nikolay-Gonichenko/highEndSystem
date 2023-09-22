package ru.itmo.highendsystem.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.PositionMapper;
import ru.itmo.highendsystem.model.dto.full.FullPositionDto;
import ru.itmo.highendsystem.model.entity.Position;
import ru.itmo.highendsystem.repository.PositionRepository;
import ru.itmo.highendsystem.service.data.PositionService;

/**
 * Реализация {@link PositionService}
 */
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public FullPositionDto getPositionById(Long id) {
        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(Position.class, id));
        return positionMapper.positionToFullDto(position);
    }
}
