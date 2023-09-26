package ru.itmo.highendsystem.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itmo.highendsystem.exception.base.BaseException;
import ru.itmo.highendsystem.model.dto.full.FullErrorDto;
import ru.itmo.highendsystem.model.dto.full.FullErrorTypeDto;
import ru.itmo.highendsystem.service.data.ErrorService;
import ru.itmo.highendsystem.service.data.ErrorTypeService;

@Aspect
@Component
public class SaveErrorsAspect {

    @Autowired
    private ErrorTypeService errorTypeService;
    @Autowired
    private ErrorService errorService;

    @AfterThrowing(value = "execution(public * ru.itmo.highendsystem.service.*.*(..))", throwing = "ex")
    public void afterThrowingAdvice(JoinPoint joinPoint, BaseException ex) {
        FullErrorTypeDto fullErrorTypeDto = errorTypeService.getErrorTypeById(ex.getType().getId());
        FullErrorDto fullErrorDto = new FullErrorDto();
        fullErrorDto.setErrorType(fullErrorTypeDto);
        fullErrorDto.setMessage(ex.getDescription());
        errorService.saveError(fullErrorDto);
    }
}
