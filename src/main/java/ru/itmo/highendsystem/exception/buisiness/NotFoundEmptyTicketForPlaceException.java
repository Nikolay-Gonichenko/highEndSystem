package ru.itmo.highendsystem.exception.buisiness;


import ru.itmo.highendsystem.exception.ExceptionType;
import ru.itmo.highendsystem.exception.base.BaseException;

/**
 * Исключение выбрасывается, когда не удалось найти свободного билета на данный рейс с данным место
 */
public class NotFoundEmptyTicketForPlaceException extends BaseException {

    private final Long flightId;
    private final String place;

    public NotFoundEmptyTicketForPlaceException(Long flightId, String place) {
        super(ExceptionType.BUSINESS_CLIENT);
        this.flightId = flightId;
        this.place = place;
    }

    public Long getFlightId() {
        return flightId;
    }

    public String getPlace() {
        return place;
    }

    @Override
    public String getDescription() {
        return "Не найдено свободное место " + place + " на рейсе " + flightId;
    }
}
