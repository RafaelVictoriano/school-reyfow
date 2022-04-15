package com.br.schoolreyfow.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ExceptionsController {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map> handlingException(MethodArgumentNotValidException exception) {
        var fieldError = exception.getBindingResult().getFieldError();
        var messageError = this.messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());

        log.error("school-reyfow error {}", messageError);
        return ResponseEntity.badRequest().body(Map.of("Error", fieldError.getField() + " " + messageError));
    }

    @ExceptionHandler(ResponseStatusException.class)
    public Map handlingResponseStatusException(ResponseStatusException exception) {
        log.error("school-reyfow error {}", exception.getReason());
        return Map.of("Error", exception.getReason());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Map handlingExceptionGlobal(Exception exception) {
        log.error("school-reyfow error {}", exception.getMessage());
        return Map.of("Error", "Internal server error " + exception.getMessage());
    }
}
