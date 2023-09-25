package ru.itmo.highendsystem.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.RouteMapper;
import ru.itmo.highendsystem.model.dto.full.FullRouteDto;
import ru.itmo.highendsystem.model.entity.Route;
import ru.itmo.highendsystem.repository.RouteRepository;
import ru.itmo.highendsystem.service.data.RouteService;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteMapper routeMapper;
    @Autowired
    RouteRepository routeRepository;

    @Override
    public FullRouteDto getRouteById(Long id) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(Route.class, id));
        return routeMapper.routeToFullDto(route);
    }
}
