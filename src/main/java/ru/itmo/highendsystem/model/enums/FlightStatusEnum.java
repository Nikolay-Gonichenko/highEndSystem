package ru.itmo.highendsystem.model.enums;

/**
 * Перечисление статуса полёта
 */
public enum FlightStatusEnum {
    PREPARED(1L),
    IN_SKY(2L),
    FINISHED(3L),
    CANCELLED(4L);
    private final long id;

    FlightStatusEnum(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
