package ru.itmo.highendsystem.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.BannedReasonMapper;
import ru.itmo.highendsystem.model.dto.full.FullBannedReasonDto;
import ru.itmo.highendsystem.model.entity.BannedReason;
import ru.itmo.highendsystem.repository.BannedListRepository;
import ru.itmo.highendsystem.repository.BannedReasonRepository;
import ru.itmo.highendsystem.service.data.BannedReasonService;

/**
 * Реализация {@link ru.itmo.highendsystem.service.data.BannedReasonService}
 */
@Service
public class BannedReasonServiceImpl implements BannedReasonService {
    @Autowired
    private BannedReasonRepository bannedReasonRepository;
    @Autowired
    private BannedReasonMapper bannedReasonMapper;

    @Override
    public FullBannedReasonDto getBannedReasonById(Long id) {
        BannedReason bannedReason = bannedReasonRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(BannedReason.class, id));
        return bannedReasonMapper.bannedReasonToFullDto(bannedReason);
    }
}
