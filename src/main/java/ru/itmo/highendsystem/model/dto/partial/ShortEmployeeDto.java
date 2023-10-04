package ru.itmo.highendsystem.model.dto.partial;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

/**
 * Дто работника
 */
public record ShortEmployeeDto(@NotNull(message = "ИД аккаунта не должен быть пустым") Long accountId,
                               @NotNull(message = "Дата приёма на работа не должна быть пустым") Date employeeDate,
                               @NotNull(message = "ИД должности не должен быть пустым") Long positionId,
                               @NotNull(message = "Зарпалта не должна быть пустой") @Min(value = 0, message = "Зарплата не может быть меньше 0") Integer salary) {
}
