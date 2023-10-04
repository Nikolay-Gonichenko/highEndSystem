package ru.itmo.highendsystem.model.dto.partial;

import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Серия документа не должна быть пустой")
    private Integer series;
    @NotNull(message = "Номер документа не должен быть пустым")
    private Integer number;
    @NotNull(message = "Тип документа не должен быть пустым")
    private Long documentTypeId;
}
