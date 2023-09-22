package ru.itmo.highendsystem.model.dto.partial;

import java.util.Date;

/**
 * Дто работника
 */
public record ShortEmployeeDto(Long accountId, Date employeeDate, Long positionId, Integer salary) {
}
