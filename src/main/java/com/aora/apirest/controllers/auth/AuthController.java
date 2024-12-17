package com.aora.apirest.controllers.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aora.apirest.dto.JwtResponse;
import com.aora.apirest.dto.LoginRequest;
import com.aora.apirest.dto.RegisterRequest;
import com.aora.apirest.dto.ApiResponse;
import com.aora.apirest.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private UserService userService;

  // response entity es un objeto que se utiliza para devolver una respuesta http
  // con el status code, headers, y body

  // endpoint para registrar usuarios
  @PostMapping("/register")
  public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody RegisterRequest request) {
    try {
      // se registra el usuario
      userService.registerUser(request);
      // se retorna una respuesta con el status code 200 y el mensaje "Usuario
      // registrado con éxito"
      return ResponseEntity.ok(new ApiResponse("Usuario registrado con éxito", "success"));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(e.getMessage(), "error"));
    }
  }

  @PostMapping("/login")
  public ResponseEntity<ApiResponse> loginUser(@Valid @RequestBody LoginRequest request) {

    try {
      String token = userService.loginUser(request);
      return ResponseEntity.ok(new ApiResponse(token, "success"));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(e.getMessage(), "error"));
    }
  }

  @GetMapping("/")
  public String getMethodName() {
    return "hola";
  }
}
