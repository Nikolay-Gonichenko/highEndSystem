package ru.itmo.highendsystem.model.dto.partial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Дто человека без id
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HumanDtoWithoutId {
    private String surname;
    private String name;
    private String lastName;
    private Date birthDate;
    private DocumentDtoWithoutId document;
}
