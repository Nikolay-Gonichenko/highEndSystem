package ru.itmo.highendsystem.model.dto.partial;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Краткое дто сущности экипажа
 */
public record ShortCrewDto(
        @NotNull(message = "ИД полёта не должен быть пустым") Long flightId,
        @NotNull(message = "ИД работника не должен быть пустым") Long employeeId,
        @NotBlank(message = "Роль не должна быть пустой") String role) {
}
