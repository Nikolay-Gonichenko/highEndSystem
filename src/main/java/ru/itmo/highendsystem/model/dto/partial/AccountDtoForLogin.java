package ru.itmo.highendsystem.model.dto.partial;

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
    private String nickname;
    private String password;
}
