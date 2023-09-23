package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Полное дто маршрута
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullRouteDto {
    private Long id;
    private FullLocationDto fromLocation;
    private FullLocationDto toLocation;
}
