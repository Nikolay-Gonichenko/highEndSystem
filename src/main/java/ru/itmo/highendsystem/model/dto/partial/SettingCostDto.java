package ru.itmo.highendsystem.model.dto.partial;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Дто для установки цены на полет
 */
public record SettingCostDto (
        @NotNull(message = "ИД полёта не должен быть пустым") Long flightId,
        @NotNull(message = "Цена рождения не должна быть пустой") @Min(0) Integer cost) {
}
