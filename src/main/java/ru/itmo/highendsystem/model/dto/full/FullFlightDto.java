package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Полное дто полёта
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullFlightDto {
    private Long id;
    private Date dateStart;
    private Date dateFinish;
    private FullFlightStatusDto flightStatus;
    private FullPlaneDto plane;
    private FullRouteDto route;
}
