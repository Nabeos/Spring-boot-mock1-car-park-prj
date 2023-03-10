package com.example.carpark.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.carpark.exception.custom.BadRequestCustomException;
import com.example.carpark.exception.custom.NotFoundException;

@RestControllerAdvice
public class APIExceptionHandler {
  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public String notFoundException(NotFoundException e) {
    return e.getError();
  }

  @ExceptionHandler(Exception.class)
  public String GeneralException(Exception e) {
    e.printStackTrace();
    return "Opps, Something went wrong\n Error: "+e.getLocalizedMessage();
  }

  @ExceptionHandler(BadRequestCustomException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public String badRequestException(BadRequestCustomException e) {
    return e.getMessage();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public List<String> errors(MethodArgumentNotValidException e) {
    return e.getBindingResult().getFieldErrors().stream().map(fe -> fe.getDefaultMessage())
        .collect(Collectors.toList());
  }
}
