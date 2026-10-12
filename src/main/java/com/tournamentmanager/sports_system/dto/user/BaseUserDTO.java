package com.tournamentmanager.sports_system.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseUserDTO {

    @NotBlank( //no puede venir en blanco (decorador de jakarta: @NotBlank)
            message = "El nombre es obligatorio"
    )
    @Size(
            min = 2, //Asegura la base de datos desde el backend
            max = 100, //Asegurese la base de datos desde el backend
            message = "El nombre debe tener entre 2 y 100 caracteres"
    )
    private String name;

    @NotBlank(
            message = "El email es obligatorio"
    )
    @Email( //decorador para validar emails
            message = "El email no tiene un formato válido"
    )
    private String email;
}