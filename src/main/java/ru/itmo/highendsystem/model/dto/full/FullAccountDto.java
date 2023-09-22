package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Полное дто аккаунта
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullAccountDto {
    private Long id;
    private String nickname;
    private String password;
    private FullHumanDto human;
    private Integer bonusMoney;
    private Date registrationDate;
    private Integer violationCount;
    private FullRoleDto role;
}
