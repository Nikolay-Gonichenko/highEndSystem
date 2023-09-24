package ru.itmo.highendsystem.exception.buisiness;

import ru.itmo.highendsystem.exception.ExceptionType;
import ru.itmo.highendsystem.exception.base.BaseException;
import ru.itmo.highendsystem.model.dto.partial.AccountDtoForLogin;

/**
 * Иключение выбрасывает когда пользователь вводит неверный логин и/или пароль
 */
public class WrongCredentialsException extends BaseException {

    private final AccountDtoForLogin accountDtoForLogin;
    public WrongCredentialsException(AccountDtoForLogin accountDtoForLogin) {
        super(ExceptionType.BUSINESS_CLIENT);
        this.accountDtoForLogin = accountDtoForLogin;
    }

    public AccountDtoForLogin getAccountDtoForLogin() {
        return accountDtoForLogin;
    }
}
