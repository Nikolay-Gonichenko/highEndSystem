package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Полное дто сущности экипажа судна
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullCrewDto {
    private FullFlightDto flight;
    private FullEmployeeDto employee;
    private String role;
}
