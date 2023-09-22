package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Полное дто работника
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullEmployeeDto {
    private Long id;
    private FullAccountDto account;
    private Date employmentDate;
    private FullPositionDto position;
    private Integer salary;
}
