package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * полное дто причины блокировки пользователя
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullBannedReasonDto {
    private Long id;
    private String name;
}
