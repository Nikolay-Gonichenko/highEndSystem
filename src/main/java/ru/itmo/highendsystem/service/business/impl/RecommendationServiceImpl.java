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
            Map<String, Integer> freq = new HashMap<>();
            for (FullRouteDto userRoute : userRoutes) {
                String currentKey = userRoute.getFromLocation().getCountry();
                currentKey += " " + userRoute.getFromLocation().getCity();
                currentKey += " " + userRoute.getToLocation().getCountry();
                currentKey += " " + userRoute.getToLocation().getCity();

                if (freq.containsKey(currentKey)) {
                    freq.put(currentKey, freq.get(currentKey) + 1);
                } else {
                    freq.put(currentKey, 1);
                }
            }
            List<Map.Entry<String, Integer>> temp = new LinkedList<>(freq.entrySet());
            temp.sort(Map.Entry.comparingByValue());

            List<FullRouteDto> result = new LinkedList<>();
            int max = Math.min(temp.size(), count);
            for (int i = 0; i < max; i++) {
                String[] fields = temp.get(i).getKey().split(" ");
                FullLocationDto from = new FullLocationDto();
                from.setId((long) i);
                from.setCountry(fields[0]);
                from.setCity(fields[1]);

                FullLocationDto to = new FullLocationDto();
                to.setId((long)(i + max));
                to.setCountry(fields[2]);
                to.setCity(fields[3]);

                FullRouteDto newRoute = new FullRouteDto();
                newRoute.setId((long) i);
                newRoute.setFromLocation(from);
                newRoute.setToLocation(to);

                result.add(newRoute);
            }
            return result;
        }

        return new LinkedList<FullRouteDto>();
    }
}
