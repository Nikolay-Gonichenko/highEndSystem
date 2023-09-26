package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Полное дто типа ошибки
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullErrorTypeDto {
    private Long id;
    private String name;
}
