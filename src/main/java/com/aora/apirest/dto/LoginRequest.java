package com.aora.apirest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginRequest {
  @NotBlank(message = "El email no puede estar vacío")
  @Email(message = "Formato de email no válido")
  private String email;

  @NotBlank(message = "La contraseña no puede estar vacía")
  @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
  private String password;

  // Constructor vacío
  public LoginRequest() {
  }

  public LoginRequest(String email, String password) {
    this.email = email;
    this.password = password;
  } 

  // Getters y setters
  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
