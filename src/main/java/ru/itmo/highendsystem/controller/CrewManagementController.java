package ru.itmo.highendsystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.highendsystem.model.dto.partial.ShortCrewDto;

/**
 * Контроллер для управления экипажом корабля
 */
@RestController
@RequestMapping("api/v1/airline/crew")
public class CrewManagementController {

    /**
     * Добавление работника на полёт
     * @param crewDto краткое дто
     * @return true если операция завершилась успешно
     */
    @PostMapping("add")
    public ResponseEntity<Boolean> addEmployeeToFlight(ShortCrewDto crewDto) {
        return null;
    }
}
