package ru.itmo.highendsystem.model.dto.partial;

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
    private Long fromLocation;
    private Long toLocation;
    private Date Start = null;
    private boolean isNeedBack;
}
