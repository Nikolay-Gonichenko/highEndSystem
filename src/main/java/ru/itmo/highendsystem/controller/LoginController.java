package ru.itmo.highendsystem.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.highendsystem.model.dto.partial.AccountDtoForLogin;
import ru.itmo.highendsystem.service.business.LoginService;

/**
 * Контроллер для входа/регистрации пользователя
 * */
@RestController
@RequestMapping("api/v1/airline/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * Вход пользователя
     * @param accountDtoForLogin дто аккаунта с никнейном и паролем
     * @return токен
     */
    @PostMapping("login")
    public ResponseEntity<String> login(@Valid @RequestBody AccountDtoForLogin accountDtoForLogin) {
        return ResponseEntity.ok(loginService.login(accountDtoForLogin));
    }
}
