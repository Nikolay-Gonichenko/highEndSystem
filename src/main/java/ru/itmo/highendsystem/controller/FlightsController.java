package ru.itmo.highendsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.highendsystem.model.dto.full.FullFlightDto;
import ru.itmo.highendsystem.model.dto.partial.FlightSearchDto;
import ru.itmo.highendsystem.service.business.FlightSearchService;

import java.util.List;

/**
 * Контроллер для работы с полетами
 * */
@RestController
@RequestMapping("api/v1/airline/flights")
public class FlightsController {

    @Autowired
    private FlightSearchService flightSearchService;

    @PostMapping("all")
    public ResponseEntity<List<FullFlightDto>> getFlights(@RequestBody FlightSearchDto search) {
        return ResponseEntity.ok(flightSearchService.getFlightsByFilters(search));
    }
}
