package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Полное дто сущности "Блокировка пользователя"
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullBannedListDto {
    private Long id;
    private FullHumanDto human;
    private FullBannedReasonDto bannedReason;
}
