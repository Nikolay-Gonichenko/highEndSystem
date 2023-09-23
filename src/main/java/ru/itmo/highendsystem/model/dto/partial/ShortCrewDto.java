package ru.itmo.highendsystem.model.dto.partial;

/**
 * Краткое дто сущности экипажа
 */
public record ShortCrewDto(Long flightId, Long employeeId, String role) {
}
