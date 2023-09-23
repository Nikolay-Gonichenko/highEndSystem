package ru.itmo.highendsystem.model.dto.full;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Полное дто нарушения
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullViolationDto {
    private Long id;
    private FullAccountDto account;
    private FullViolationTypeDto violationType;
    private Date date;
    private String message;
}
