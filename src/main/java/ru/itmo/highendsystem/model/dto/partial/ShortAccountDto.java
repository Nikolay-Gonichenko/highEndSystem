package ru.itmo.highendsystem.model.dto.partial;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Краткое дто аккаунта без ID
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShortAccountDto {
    @NotBlank(message = "Логин не должен быть пустым")
    private String nickname;
    @NotBlank(message = "Пароль не должен быть пустым")
    private String password;
    @NotNull(message = "Человек не должен быть пустым")
    private HumanDtoWithoutId human;
    @NotNull(message = "Количество денег не должно быть пустым")
    @Min(value = 0, message = "Количество денег должно быть больше 0")
    private Integer bonusMoney;
    @NotNull(message = "Дата регистрации не должна быть пустой")
    private Date registrationDate;
    @NotNull(message = "ИД роли не должен быть пустым")
    private Long roleId;
}
