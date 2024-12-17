package com.aora.apirest.errorsHandler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aora.apirest.dto.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

  // Controlador de excepciones globales
  // Se utiliza para manejar excepciones que no se pueden atrapar en el controlador

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
    // Recopila todo los errores de validación
    List<String> errors = ex.getBindingResult()
      .getFieldErrors()
      .stream()
      .map(error -> error.getDefaultMessage())
      .collect(Collectors.toList());

      ApiResponse errorResponse = new ApiResponse(
        errors.toString(),
        "error"
      );
    
      return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }
}
