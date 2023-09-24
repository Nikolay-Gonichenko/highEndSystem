package ru.itmo.highendsystem.model.dto.full;

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
public class FullFlightSearchDto {
    private FullLocationDto fromLocation;
    private FullLocationDto toLocation;
    private Date Start;
    private boolean isNeedBack;
}
