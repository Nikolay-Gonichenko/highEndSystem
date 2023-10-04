package ru.itmo.highendsystem.model.dto.partial;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Дто аккаунта пользователя для входа в систему
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDtoForLogin {
    @NotBlank(message = "Логин не должен быть пустым")
    private String nickname;
    @NotBlank(message = "Пароль не должен быть пустым")
    private String password;
}
