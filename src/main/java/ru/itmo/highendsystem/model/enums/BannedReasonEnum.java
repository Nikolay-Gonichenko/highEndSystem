package ru.itmo.highendsystem.model.enums;

/**
 * Перечисление для причин блокировки пользователя
 */
public enum BannedReasonEnum {
    VIOLATION_COUNT_HIGHER_PERMITTED(1L, "Количество нарушений больше допустимого");
    private final long id;
    private final String name;

    BannedReasonEnum(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
