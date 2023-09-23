package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Полное дто самолёта
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullPlaneDto {
    private Long id;
    private String model;
    private Integer passengerCount;
}
