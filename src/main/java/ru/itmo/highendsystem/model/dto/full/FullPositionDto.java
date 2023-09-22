package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Полное дто для должности
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullPositionDto {
    private Long id;
    private String name;
    private FullDepartmentDto department;
}
