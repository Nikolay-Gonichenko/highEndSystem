package ru.itmo.highendsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.highendsystem.model.dto.full.FullFlightDto;
import ru.itmo.highendsystem.model.dto.full.FullFlightSearchDto;
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
    private FlightService flightService;

    @PostMapping("all")
    public ResponseEntity<List<FullFlightDto>> getFlights(FullFlightSearchDto search) {
        List<FullFlightDto> flights = flightService.getAllFlights();
        Stream<FullFlightDto> sorted = flights.stream()
                .filter(x -> x.getRoute().getFromLocation().equals(search.getFromLocation()) &&
                        x.getRoute().getToLocation().equals(search.getToLocation()));

        if (search.getStart() != null) {
            sorted = sorted.filter(x -> x.getDateStart().before(search.getStart()));
        }

        if (search.isNeedBack()) {
            Stream<FullFlightDto> backList = flights.stream()
                    .filter(x -> x.getRoute().getFromLocation().equals(search.getToLocation()) &&
                            x.getRoute().getToLocation().equals(search.getFromLocation()));

            if (search.getStart() != null) {
                backList = backList.filter(x -> x.getDateStart().before(search.getStart()));
            }

            sorted = Stream.concat(sorted, backList);
        }
        return ResponseEntity.ok(sorted.toList());
    }
}
