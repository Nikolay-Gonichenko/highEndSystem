package ru.itmo.highendsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.highendsystem.model.dto.partial.ShortEmployeeDto;
import ru.itmo.highendsystem.service.business.CreateService;

/**
 * Контроллер для работы админа
 */
@RestController
@RequestMapping("api/v1/airline/admin")
public class AdminController {

    @Autowired
    private CreateService createService;



    /**
     * Создание нового работника
     * @param employee дто работника
     * @return true если операция прошла успешно
     */
    @PostMapping("create/employee")
    public ResponseEntity<Boolean> createNewEmployee(ShortEmployeeDto employee) {
        return ResponseEntity.ok(createService.createEmployee(employee));
    }
}
