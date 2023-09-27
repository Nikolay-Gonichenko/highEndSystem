package ru.itmo.highendsystem.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.exception.buisiness.WrongCredentialsException;
import ru.itmo.highendsystem.model.dto.full.FullAccountDto;
import ru.itmo.highendsystem.model.dto.partial.AccountDtoForLogin;
import ru.itmo.highendsystem.secuity.util.JwtTokenUtil;
import ru.itmo.highendsystem.service.business.LoginService;
import ru.itmo.highendsystem.service.data.AccountService;

/**
 * реализация {@link ru.itmo.highendsystem.service.business.LoginService}
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Override
    public String login(AccountDtoForLogin accountDtoForLogin) {
        FullAccountDto fullAccountDto = accountService.getAccountByNickname(accountDtoForLogin.getNickname());
       if (fullAccountDto == null || !passwordEncoder.matches(accountDtoForLogin.getPassword(), fullAccountDto.getPassword()))
            throw new WrongCredentialsException(accountDtoForLogin);
        return jwtTokenUtil.generateAccessToken(accountDtoForLogin.getNickname());
    }
}
