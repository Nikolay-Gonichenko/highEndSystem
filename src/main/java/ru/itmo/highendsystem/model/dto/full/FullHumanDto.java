package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Полное дто человека
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullHumanDto {
    private Long id;
    private String surname;
    private String name;
    private String lastName;
    private Date birthDate;
    private FullDocumentDto document;
}
