package ru.itmo.highendsystem.service.data.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.AccountMapper;
import ru.itmo.highendsystem.model.dto.full.FullAccountDto;
import ru.itmo.highendsystem.model.entity.Account;
import ru.itmo.highendsystem.repository.AccountRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceImplTest {
    @Mock
    private AccountRepository accountRepository;
    @Mock
    private AccountMapper accountMapper;

    @InjectMocks
    private AccountServiceImpl accountService;

    @Test
    public void getAccountByIdCorrectTest() {
        long id = 1L;
        Account account = new Account();
        account.setId(id);
        when(accountRepository.findById(id)).thenReturn(Optional.of(account));
        FullAccountDto fullAccountDto = new FullAccountDto();
        fullAccountDto.setId(id);
        when(accountMapper.accountToFullDto(account)).thenReturn(fullAccountDto);

        FullAccountDto expected = accountService.getAccountById(id);
        assertEquals(expected.getId(), id);
    }

    @Test
    public void getAccountByIdShouldThrowException() {
        long id = 1L;
        when(accountRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(NotFoundEntityByIdException.class,
                () -> accountService.getAccountById(id));
    }

    @Test
    public void isExistAccountByNicknameAndPasswordShouldReturnTrue() {
        String login = "test";
        String password = "test";
        Account account = new Account();
        account.setNickname(login);
        account.setPassword(password);

        when(accountRepository.getAccountByNicknameAndPassword(login, password)).thenReturn(account);
        assertTrue(accountService.isExistAccountByNicknameAndPassword(login, password));
    }

    @Test
    public void isExistAccountByNicknameAndPasswordShouldReturnFalse() {
        String login = "test";
        String password = "test";
        when(accountRepository.getAccountByNicknameAndPassword(login, password)).thenReturn(null);
        assertFalse(accountService.isExistAccountByNicknameAndPassword(login, password));
    }
}
