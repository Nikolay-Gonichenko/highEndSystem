package ru.itmo.highendsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.highendsystem.model.dto.partial.ShortBannedListDto;
import ru.itmo.highendsystem.model.dto.partial.ShortViolationDto;
import ru.itmo.highendsystem.service.business.ViolationOperationService;

/**
 * Контроллер для работы с нарушениями пользователей
 */
@RestController
@RequestMapping("api/v1/airline/violation")
public class ViolationOperationController {

    @Autowired
    private ViolationOperationService violationOperationService;

    /**
     * Добавление нового нарушения пользователю
     * @param violationDto краткое дто нарушения
     * @return обновлённое число нарушений у пользователя
     */
    @PostMapping("add")
    public ResponseEntity<Integer> addViolation(@RequestBody ShortViolationDto violationDto) {
        return ResponseEntity.ok(violationOperationService.addViolation(violationDto));
    }

    /**
     * Бан человека на сайте авиакомпании
     * @param shortBannedListDto краткое дто бана пользователя
     * @return true если операция завершилась успешно
     */
    @PostMapping("ban")
    public ResponseEntity<Boolean> ban(@RequestBody ShortBannedListDto shortBannedListDto) {
        return ResponseEntity.ok(violationOperationService.ban(shortBannedListDto));
    }
}
