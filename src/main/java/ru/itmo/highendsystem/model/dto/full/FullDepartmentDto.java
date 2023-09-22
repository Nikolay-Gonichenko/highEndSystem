package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Полное дто для департамената авиакомпании
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullDepartmentDto {
    private Long id;
    private String name;
}
