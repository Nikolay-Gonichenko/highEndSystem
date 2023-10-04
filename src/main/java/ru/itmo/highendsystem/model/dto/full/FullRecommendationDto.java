package ru.itmo.highendsystem.model.dto.full;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "ИД пользователя не должен быть пустой")
    private Long userId;
    @NotNull(message = "Количество рекомендация не должно быть пустым")
    @Min(value = 1, message = "Минимальное количество рекомендаций 1")
    private Integer count;
}
