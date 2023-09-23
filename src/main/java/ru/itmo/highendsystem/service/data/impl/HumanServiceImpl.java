package ru.itmo.highendsystem.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.HumanMapper;
import ru.itmo.highendsystem.model.dto.full.FullHumanDto;
import ru.itmo.highendsystem.model.entity.Human;
import ru.itmo.highendsystem.repository.HumanRepository;
import ru.itmo.highendsystem.service.data.HumanService;

/**
 * Реализация {@link ru.itmo.highendsystem.service.data.HumanService}
 */
@Service
public class HumanServiceImpl implements HumanService {

    @Autowired
    private HumanRepository humanRepository;
    @Autowired
    private HumanMapper humanMapper;

    @Override
    public FullHumanDto getHumanById(Long id) {
        Human human = humanRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(Human.class, id));
        return humanMapper.humanToFullDto(human);
    }
}
