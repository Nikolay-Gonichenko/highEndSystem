package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Полное дто типа нарушения
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullViolationTypeDto {
    private Long id;
    private String name;
}
