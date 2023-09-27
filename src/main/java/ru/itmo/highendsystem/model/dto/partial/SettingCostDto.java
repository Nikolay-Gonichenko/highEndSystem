package ru.itmo.highendsystem.model.dto.partial;

/**
 * Дто для установки цены на полет
 */
public record SettingCostDto (Long flightId, Integer cost) {
}
