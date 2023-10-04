package ru.itmo.highendsystem.model.dto.partial;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Полное дто для описания фильров по полетам
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightSearchDto {
    @NotNull(message = "Локации не должны быть пустыми")
    private Long fromLocation;
    @NotNull(message = "Локации не должны быть пустыми")
    private Long toLocation;
    private Date Start = null;
    private boolean isNeedBack;
}
