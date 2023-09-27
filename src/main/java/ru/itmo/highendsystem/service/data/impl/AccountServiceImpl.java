package ru.itmo.highendsystem.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.AccountMapper;
import ru.itmo.highendsystem.model.dto.full.FullAccountDto;
import ru.itmo.highendsystem.model.entity.Account;
import ru.itmo.highendsystem.repository.AccountRepository;
import ru.itmo.highendsystem.service.data.AccountService;

/**
 * Реализация {@link AccountService}
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public FullAccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(Account.class, id));
        return accountMapper.accountToFullDto(account);
    }

    @Override
    public FullAccountDto saveAccount(FullAccountDto account) {
        return accountMapper.accountToFullDto(
                accountRepository.save(accountMapper.fullDtoToAccount(account))
        );
    }

    @Override
    public boolean isExistAccountByNicknameAndPassword(String login, String password) {
        return accountRepository.getAccountByNicknameAndPassword(login, password) != null;
    }

    @Override
    public FullAccountDto getAccountByNickname(String nickname) {
        Account account = accountRepository.getAccountByNickname(nickname);
        return accountMapper.accountToFullDto(account);
    }
}
