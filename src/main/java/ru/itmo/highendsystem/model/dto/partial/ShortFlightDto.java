package ru.itmo.highendsystem.model.dto.partial;

import java.util.Date;

/**
 * Краткое дто полета
 */
public record ShortFlightDto(Date dateStart, Date dateFinish, Long flightStatus, Long plane, Long route) {

}
