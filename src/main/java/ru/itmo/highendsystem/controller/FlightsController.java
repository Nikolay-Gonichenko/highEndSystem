package ru.itmo.highendsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.highendsystem.model.dto.full.FullFlightDto;
import ru.itmo.highendsystem.model.dto.full.FullFlightSearchDto;
import ru.itmo.highendsystem.service.business.FlightSearchService;
import ru.itmo.highendsystem.service.data.FlightService;

import java.util.List;
import java.util.stream.Stream;

/**
 * Контроллер для работы с полетами
 * */
@RestController
@RequestMapping("api/v1/airline/flights")
public class FlightsController {

    @Autowired
    private FlightSearchService flightSearchService;

    @PostMapping("all")
    public ResponseEntity<List<FullFlightDto>> getFlights(@RequestBody FullFlightSearchDto search) {
        return ResponseEntity.ok(flightSearchService.getFlightsByFilters(search));
    }
}
