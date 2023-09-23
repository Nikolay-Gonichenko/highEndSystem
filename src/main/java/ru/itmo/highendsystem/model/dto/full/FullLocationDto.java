package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Полное дто локации
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullLocationDto {
    private Long id;
    private String country;
    private String city;
    private String airport;
}
