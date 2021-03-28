package br.com.bei.moviesapi.config.handler;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ErrorHandler {

    @ResponseStatus(code=BAD_REQUEST)
    @ExceptionHandler( MethodArgumentNotValidException.class )
    public List<ErrorHandlerResponse> handle( MethodArgumentNotValidException exception){
        List<ErrorHandlerResponse> dto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(e -> {
            ErrorHandlerResponse error = new ErrorHandlerResponse(e.getField(), e.getDefaultMessage());
            dto.add(error);
        });
        return dto;
    }
}
