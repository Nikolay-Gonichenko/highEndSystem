package ru.itmo.highendsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.highendsystem.model.dto.partial.ShortAccountDto;
import ru.itmo.highendsystem.model.dto.partial.ShortEmployeeDto;
import ru.itmo.highendsystem.service.business.CreateService;

/**
 * Контроллер для работы админа
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
    public ResponseEntity<Boolean> createNewEmployee(ShortEmployeeDto employee) {
        return ResponseEntity.ok(createService.createEmployee(employee));
    }

    /**
     * Создание нового аккаунта
     * @param account дто аккаунта без id
     * @return полное дто аккаунта
     */
    @PostMapping("account")
    public ResponseEntity<Long> createNewAccount(ShortAccountDto account) {
        return ResponseEntity.ok(createService.createAccount(account));
    }
}
