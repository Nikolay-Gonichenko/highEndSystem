package ru.itmo.highendsystem.exception;

public enum ExceptionType {
    DATA("Ошибка в работе сервиса уровня сущности"),
    BUSINESS_MANAGER("Ошибка в работе сервиса менеджера"),
    BUSINESS_CLIENT("Ошибка в работе сервиса пользователя");

    private final String name;

    ExceptionType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
