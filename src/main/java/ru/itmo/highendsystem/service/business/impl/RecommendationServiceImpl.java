package ru.itmo.highendsystem.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.model.dto.full.FullFlightDto;
import ru.itmo.highendsystem.model.dto.full.FullLocationDto;
import ru.itmo.highendsystem.model.dto.full.FullRouteDto;
import ru.itmo.highendsystem.model.dto.full.FullTicketDto;
import ru.itmo.highendsystem.service.business.RecommendationService;
import ru.itmo.highendsystem.service.data.TicketService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private TicketService ticketService;

    @Override
    public List<FullRouteDto> getRecommendationsToUser(long id, int count) {
        List<FullRouteDto> userRoutes = ticketService.getAllTicketsByUserId(id)
                .stream()
                .map(FullTicketDto::getFlight)
                .map(FullFlightDto::getRoute)
                .toList();

        if (userRoutes.size() >= count) {
            Map<FullRouteDto, Integer> freq = new HashMap<>();
            for (FullRouteDto userRoute : userRoutes) {

                if (freq.containsKey(userRoute)) {
                    freq.put(userRoute, freq.get(userRoute) + 1);
                } else {
                    freq.put(userRoute, 1);
                }
            }
            List<Map.Entry<FullRouteDto, Integer>> result = new ArrayList<>(freq.entrySet());
            result.sort(new Comparator<Map.Entry<FullRouteDto, Integer>>() {
                @Override
                public int compare(Map.Entry<FullRouteDto, Integer> o1, Map.Entry<FullRouteDto, Integer> o2) {
                    return o1.getValue() > o2.getValue() ? 1 : 0;
                }
            });

            return result.stream()
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList())
                    .subList(0, count);
        }

        return new ArrayList<>();
    }
}
