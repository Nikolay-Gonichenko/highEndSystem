package ru.itmo.highendsystem.mapper;

import org.mapstruct.Mapper;
import ru.itmo.highendsystem.model.dto.full.FullAccountDto;
import ru.itmo.highendsystem.model.entity.Account;

/**
 * Маппер аккаунта
 */
@Mapper(componentModel = "spring", uses = {HumanMapper.class, RoleMapper.class})
public interface AccountMapper {

    FullAccountDto accountToFullDto(Account account);
}
