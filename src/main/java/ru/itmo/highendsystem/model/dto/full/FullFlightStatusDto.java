package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Полное дто статуса полёта
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullFlightStatusDto {
    private Long id;
    private String name;
}
