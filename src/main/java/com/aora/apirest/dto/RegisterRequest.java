package com.aora.apirest.dto;

import com.aora.apirest.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequest {
  
  @NotBlank(message = "El email no puede estar vacío")
  @Email(message = "Formato de email no válido")
  private String email;

  @NotBlank(message = "La contraseña no puede estar vacía")
  @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
  private String password;

  private Role role;

  // Constructor vacío
  public RegisterRequest() {
  }

  // Getters y setters
  public String getEmail() {
      return email;
  }

  public void setEmail(String email) {
      this.email = email;
  }

  public String getPassword() {
      return password;
  }

  public void setPassword(String password) {
      this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}