package ru.itmo.highendsystem.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.mapper.BannedListMapper;
import ru.itmo.highendsystem.model.dto.full.FullBannedListDto;
import ru.itmo.highendsystem.repository.BannedListRepository;
import ru.itmo.highendsystem.service.data.BannedListService;

/**
 * Реализация {@link ru.itmo.highendsystem.service.data.BannedListService}
 */
@Service
public class BannedListServiceImpl implements BannedListService {

    @Autowired
    private BannedListRepository bannedListRepository;
    @Autowired
    private BannedListMapper bannedListMapper;

    @Override
    public Boolean saveBannedList(FullBannedListDto bannedListDto) {
        bannedListRepository.save(bannedListMapper.fullDtoToBannedList(bannedListDto));
        return true;
    }
}
