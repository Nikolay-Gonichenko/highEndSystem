package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Полное дто роли
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullRoleDto {
    private Long id;
    private String name;
}
