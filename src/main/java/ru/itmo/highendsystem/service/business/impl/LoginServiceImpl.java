package ru.itmo.highendsystem.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.exception.buisiness.WrongCredentialsException;
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


    @Override
    public String login(AccountDtoForLogin accountDtoForLogin) {
        if (!accountService.isExistAccountByNicknameAndPassword(
                accountDtoForLogin.getNickname(),
                passwordEncoder.encode(accountDtoForLogin.getPassword())))
            throw new WrongCredentialsException(accountDtoForLogin);
        return JwtTokenUtil.generateAccessToken(accountDtoForLogin.getNickname());
    }
}
