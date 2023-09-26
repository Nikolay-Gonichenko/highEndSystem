package ru.itmo.highendsystem.service.business.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itmo.highendsystem.exception.buisiness.WrongCredentialsException;
import ru.itmo.highendsystem.model.dto.partial.AccountDtoForLogin;
import ru.itmo.highendsystem.service.data.AccountService;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LoginServiceImplTest {
    @Mock
    private AccountService accountService;
    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private LoginServiceImpl loginService;

    @Test
    public void loginTestCorrect() {
        String login = "login";
        String password = "pass";
        AccountDtoForLogin accountDtoForLogin = new AccountDtoForLogin(login, password);
        when(passwordEncoder.encode(password))
                .thenReturn(password);
        when(accountService.isExistAccountByNicknameAndPassword(login, password))
                .thenReturn(true);
        assertNotNull(loginService.login(accountDtoForLogin));
    }

    @Test
    public void loginTestShouldThrowException() {
        String login = "login";
        String password = "pass";
        AccountDtoForLogin accountDtoForLogin = new AccountDtoForLogin(login, password);
        when(passwordEncoder.encode(password))
                .thenReturn(password);
        when(accountService.isExistAccountByNicknameAndPassword(login, password))
                .thenReturn(false);
        assertThrows(WrongCredentialsException.class, () -> loginService.login(accountDtoForLogin));
    }
}
