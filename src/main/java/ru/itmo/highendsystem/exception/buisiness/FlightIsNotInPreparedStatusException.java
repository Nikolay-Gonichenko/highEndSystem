package ru.itmo.highendsystem.exception.buisiness;

import ru.itmo.highendsystem.exception.ExceptionType;
import ru.itmo.highendsystem.exception.base.BaseException;

/**
 * Исключение выбрасывается при попытке добавить работника к полёту,
 * который уже подготовлен
 */
public class FlightIsNotInPreparedStatusException extends BaseException {

    public FlightIsNotInPreparedStatusException() {
        super(ExceptionType.BUSINESS_MANAGER);
    }
}
