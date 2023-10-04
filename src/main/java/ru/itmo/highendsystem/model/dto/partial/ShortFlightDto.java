package ru.itmo.highendsystem.model.dto.partial;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

/**
 * Краткое дто полета
 */
public record ShortFlightDto(
        @NotNull(message = "Дата начала полёта не должна быть пустой") Date dateStart,
        @NotNull(message = "Дата конца полёта не должна быть пустой") Date dateFinish,
        @NotNull(message = "Статус полёта не должен быть пустой") Long flightStatus,
        @NotNull(message = "ИД самолёта полёта не должен быть пустой") Long plane,
        @NotNull(message = "ИД маршрута не должен быть пустой") Long route) {

}
