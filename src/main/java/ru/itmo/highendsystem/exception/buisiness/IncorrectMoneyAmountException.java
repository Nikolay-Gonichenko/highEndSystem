package ru.itmo.highendsystem.exception.buisiness;

import ru.itmo.highendsystem.exception.ExceptionType;
import ru.itmo.highendsystem.exception.base.BaseException;

/**
 * Исключение выбрасывается, когда пользователь перевёл неверную сумму для покупки билета
 */
public class IncorrectMoneyAmountException extends BaseException {
    private final Integer ticketCost;
    private final Integer userMoney;

    public IncorrectMoneyAmountException(Integer ticketCost, Integer userMoney) {
        super(ExceptionType.BUSINESS_CLIENT);
        this.ticketCost = ticketCost;
        this.userMoney = userMoney;
    }

    public Integer getTicketCost() {
        return ticketCost;
    }

    public Integer getUserMoney() {
        return userMoney;
    }

    @Override
    public String getDescription() {
        return "Переведна неверная сумма. Переведно " + userMoney + ". Требуется " + ticketCost;
    }
}
