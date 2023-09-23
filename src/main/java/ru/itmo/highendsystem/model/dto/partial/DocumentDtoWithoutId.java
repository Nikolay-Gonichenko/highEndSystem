package ru.itmo.highendsystem.model.dto.partial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Дто документа без id
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDtoWithoutId {
    private Integer series;
    private Integer number;
    private Long documentTypeId;
}
