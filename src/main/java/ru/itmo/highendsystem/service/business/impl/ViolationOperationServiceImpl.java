package ru.itmo.highendsystem.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.highendsystem.model.dto.full.*;
import ru.itmo.highendsystem.model.dto.partial.ShortBannedListDto;
import ru.itmo.highendsystem.model.dto.partial.ShortViolationDto;
import ru.itmo.highendsystem.model.enums.BannedReasonEnum;
import ru.itmo.highendsystem.service.business.ViolationOperationService;
import ru.itmo.highendsystem.service.data.*;

/**
 * Реализация {@link ViolationOperationService}
 */
@Service
public class ViolationOperationServiceImpl implements ViolationOperationService {

    @Autowired
    private AccountService accountService;
    @Autowired
    private ViolationTypeService violationTypeService;
    @Autowired
    private ViolationService violationService;
    @Autowired
    private HumanService humanService;
    @Autowired
    private BannedReasonService bannedReasonService;
    @Autowired
    private BannedListService bannedListService;

    @Override
    @Transactional
    public Integer addViolation(ShortViolationDto violationDto) {
        FullAccountDto fullAccountDto = accountService.getAccountById(violationDto.accountId());
        FullViolationTypeDto fullViolationTypeDto = violationTypeService.getViolationTypeById(violationDto.typeId());

        FullViolationDto fullViolationDto = new FullViolationDto();
        fullViolationDto.setViolationType(fullViolationTypeDto);
        fullViolationDto.setAccount(fullAccountDto);
        fullViolationDto.setDate(violationDto.date());
        fullViolationDto.setMessage(violationDto.message());
        violationService.saveViolation(fullViolationDto);

        fullAccountDto.setViolationCount(fullAccountDto.getViolationCount() + 1);
        FullAccountDto accountDto = accountService.saveAccount(fullAccountDto);

        //если количество нарушений стало равно 3, то происходит автоматическая блокировка
        int violationCount = accountDto.getViolationCount();
        if (violationCount == 3) {
            ban(new ShortBannedListDto(
                    BannedReasonEnum.VIOLATION_COUNT_HIGHER_PERMITTED.getId(),
                    accountDto.getHuman().getId())
            );
        }
        return violationCount;
    }

    @Override
    public Boolean ban(ShortBannedListDto bannedListDto) {
        FullHumanDto fullHumanDto = humanService.getHumanById(bannedListDto.humanId());
        FullBannedReasonDto fullBannedReasonDto = bannedReasonService.getBannedReasonById(bannedListDto.reasonId());
        FullBannedListDto fullBannedListDto = new FullBannedListDto();
        fullBannedListDto.setBannedReason(fullBannedReasonDto);
        fullBannedListDto.setHuman(fullHumanDto);
        return bannedListService.saveBannedList(fullBannedListDto);
    }
}
