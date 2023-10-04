package ru.itmo.highendsystem.controller;

import jakarta.persistence.Access;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.highendsystem.model.dto.full.FullRecommendationDto;
import ru.itmo.highendsystem.model.dto.full.FullRouteDto;
import ru.itmo.highendsystem.service.business.RecommendationService;

import java.util.List;

/**
 * Контроллер для отправки пользователю рекоммедованных маршрутов
 */
@RestController
@RequestMapping("api/v1/airline/recommendation")
public class RecommendationController {
    @Autowired
    private RecommendationService recommendationService;


    /**
     * Получение рекоммедованных маршрутов конкретному пользователю
     * @param recommendationDto дто рекоммендации
     * @return список маршрутов
     */
    @PostMapping("")
    public ResponseEntity<List<FullRouteDto>> getRecommendations(@Valid @RequestBody FullRecommendationDto recommendationDto) {
        return ResponseEntity.ok(recommendationService.getRecommendationsToUser(recommendationDto.getUserId(), recommendationDto.getCount()));
    }
}
