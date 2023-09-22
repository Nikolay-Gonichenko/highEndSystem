package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Полное дто типа документа
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullDocumentTypeDto {
    private Long id;
    private String name;
}
