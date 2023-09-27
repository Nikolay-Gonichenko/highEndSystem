package ru.itmo.highendsystem.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.model.dto.full.FullFlightDto;
import ru.itmo.highendsystem.model.dto.full.FullFlightSearchDto;
import ru.itmo.highendsystem.service.business.FlightSearchService;
import ru.itmo.highendsystem.service.data.FlightService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Реализация {@link FlightSearchService}
 */
@Service
public class FlightSearchServiceImpl implements FlightSearchService {

    @Autowired
    private FlightService flightService;

    @Value("{pagination:maxSize}")
    private String maxPageSize;

    @Override
    public List<FullFlightDto> getFlightsByFilters(FullFlightSearchDto search) {
        int maxPage = Integer.parseInt(maxPageSize);
        List<FullFlightDto> flights = new ArrayList<>();
        int pageNumber = 0;
        do {
            List<FullFlightDto> fullFlightDtos = flightService.getAllFlights(pageNumber, maxPage);
            flights.addAll(fullFlightDtos);
            pageNumber++;
        } while (flights.size() % maxPage == 0);

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
