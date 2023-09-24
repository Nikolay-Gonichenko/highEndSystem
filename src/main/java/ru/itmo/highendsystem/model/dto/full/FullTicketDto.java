package ru.itmo.highendsystem.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Полное дто билета
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullTicketDto {
    private long id;
    private FullFlightDto flight;
    private FullHumanDto human;
    private int cost;
    private String place;
}
