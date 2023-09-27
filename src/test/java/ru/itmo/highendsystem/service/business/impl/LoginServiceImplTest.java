package ru.itmo.highendsystem.service.business.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itmo.highendsystem.exception.buisiness.WrongCredentialsException;
import ru.itmo.highendsystem.model.dto.full.FullAccountDto;
import ru.itmo.highendsystem.model.dto.partial.AccountDtoForLogin;
import ru.itmo.highendsystem.secuity.util.JwtTokenUtil;
import ru.itmo.highendsystem.service.data.AccountService;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LoginServiceImplTest {
    @Mock
    private AccountService accountService;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private JwtTokenUtil jwtTokenUtil;

    @InjectMocks
    private LoginServiceImpl loginService;

    @Test
    public void loginTestCorrect() {
        String login = "login";
        String password = "pass";
        AccountDtoForLogin accountDtoForLogin = new AccountDtoForLogin(login, password);
        FullAccountDto fullAccountDto = new FullAccountDto();
        fullAccountDto.setNickname(login);
        fullAccountDto.setPassword(password);
        when(accountService.getAccountByNickname(login))
                .thenReturn(fullAccountDto);
        when(passwordEncoder.matches(password, password)).thenReturn(true);
        when(jwtTokenUtil.generateAccessToken(login)).thenReturn("token");
        assertNotNull(loginService.login(accountDtoForLogin));
    }

    @Test
    public void loginTestShouldThrowException() {
        String login = "login";
        String password = "pass";
        AccountDtoForLogin accountDtoForLogin = new AccountDtoForLogin(login, password);
        when(accountService.getAccountByNickname(login))
                .thenReturn(null);
        assertThrows(WrongCredentialsException.class, () -> loginService.login(accountDtoForLogin));
    }
}
