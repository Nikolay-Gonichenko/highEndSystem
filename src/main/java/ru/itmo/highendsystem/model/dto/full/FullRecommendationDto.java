package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Полное дто рекомендаций пользователю
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullRecommendationDto {
    private Long userId;
    private Integer count;
}
