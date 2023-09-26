package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Полное дто ошибки
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullErrorDto {
    private Long id;
    private String message;
    private FullErrorTypeDto errorType;
}
