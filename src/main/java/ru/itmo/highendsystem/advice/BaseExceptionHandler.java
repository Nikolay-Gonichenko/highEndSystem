package ru.itmo.highendsystem.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.itmo.highendsystem.exception.base.BaseException;

@ControllerAdvice
public class BaseExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {BaseException.class})
    private ResponseEntity<Object> handle(BaseException exception, WebRequest request) {
        return handleExceptionInternal(exception, exception.getDescription(),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
