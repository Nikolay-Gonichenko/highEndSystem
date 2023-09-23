package ru.itmo.highendsystem.model.dto.partial;

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
    private String nickname;
    private String password;
    private HumanDtoWithoutId human;
    private Integer bonusMoney;
    private Date registrationDate;
    private Long roleId;
}
