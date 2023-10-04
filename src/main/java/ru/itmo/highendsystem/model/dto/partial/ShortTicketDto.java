package ru.itmo.highendsystem.model.dto.partial;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Дто билета
 */
public record ShortTicketDto(
        @NotNull(message = "ИД полёта не должен быть пустой") Long flight,
        @NotNull(message = "Стоимость полёта не должна быть пустой") @Min(value = 0, message = "Минимальная стоимость полёта 0") Integer cost,
        @NotBlank(message = "Место не должно быть пустым") String place) {

}
