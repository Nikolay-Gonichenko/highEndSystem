package ru.itmo.highendsystem.model.dto.partial;

import java.util.Date;

/**
 * Краткое дто нарушения
 */
public record ShortViolationDto(Long accountId, Long typeId, Date date, String message) {
}
