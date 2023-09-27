package ru.itmo.highendsystem.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.model.dto.full.FullFlightDto;
import ru.itmo.highendsystem.model.dto.full.FullFlightSearchDto;
import ru.itmo.highendsystem.service.business.FlightSearchService;
import ru.itmo.highendsystem.service.data.FlightService;

import java.util.List;
import java.util.stream.Stream;

/**
 * Реализация {@link FlightSearchService}
 */
@Service
public class FlightSearchServiceImpl implements FlightSearchService {

    @Autowired
    FlightService flightService;
    @Override
    public List<FullFlightDto> getFlightsByFilters(FullFlightSearchDto search) {
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
        return sorted.toList();
    }
}
