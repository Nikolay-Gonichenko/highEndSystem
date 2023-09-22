package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Полное дто документа
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullDocumentDto {
    private Long id;
    private Integer series;
    private Integer number;
    private FullDocumentTypeDto documentType;
}
