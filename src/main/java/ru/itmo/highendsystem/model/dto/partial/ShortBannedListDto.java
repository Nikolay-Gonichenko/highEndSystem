package ru.itmo.highendsystem.model.dto.partial;

/**
 * Краткое дто для бана человека
 */
public record ShortBannedListDto(Long reasonId, Long humanId) {
}
