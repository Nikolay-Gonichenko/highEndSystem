package ru.itmo.highendsystem.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.highendsystem.model.dto.partial.ShortAccountDto;
import ru.itmo.highendsystem.model.dto.partial.ShortEmployeeDto;
import ru.itmo.highendsystem.model.dto.partial.ShortFlightDto;
import ru.itmo.highendsystem.service.business.CreateService;

/**
 * Контроллер для создания новых объектов
 */
@RestController
@RequestMapping("api/v1/airline/create")
public class CreateController {

    @Autowired
    private CreateService createService;



    /**
     * Создание нового работника
     * @param employee дто работника
     * @return true если операция прошла успешно
     */
    @PostMapping("employee")
    public ResponseEntity<Boolean> createNewEmployee(@Valid @RequestBody ShortEmployeeDto employee) {
        return ResponseEntity.ok(createService.createEmployee(employee));
    }

    /**
     * Создание нового аккаунта
     * @param account дто аккаунта без id
     * @return id аккаунта
     */
    @PostMapping("account")
    public ResponseEntity<Long> createNewAccount(@Valid @RequestBody ShortAccountDto account) {
        return ResponseEntity.ok(createService.createAccount(account));
    }

    /**
     * Создание нового полета
     * @param flight краткое дто полета
     * @return id полета
     */
    @PostMapping("flight")
    public ResponseEntity<Long> createNewFlight(@Valid @RequestBody ShortFlightDto flight) {
        return ResponseEntity.ok(createService.createFlight(flight));
    }
}
