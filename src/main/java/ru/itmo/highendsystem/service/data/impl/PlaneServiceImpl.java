package ru.itmo.highendsystem.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.PlaneMapper;
import ru.itmo.highendsystem.model.dto.full.FullPlaneDto;
import ru.itmo.highendsystem.model.entity.Plane;
import ru.itmo.highendsystem.repository.PlaneRepository;
import ru.itmo.highendsystem.service.data.PlaneService;

/**
 * реализация {@link PlaneService}
 */
@Service
public class PlaneServiceImpl implements PlaneService {

    @Autowired
    PlaneMapper planeMapper;
    @Autowired
    PlaneRepository planeRepository;
    @Override
    public FullPlaneDto getPlaneById(Long id) {
        Plane plane = planeRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(Plane.class, id));
        return planeMapper.planeToFullDto(plane);
    }
}
