package com.tournamentmanager.sports_system.dto.permission;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasePermissionDTO {
    @NotBlank(message = "La URL es obligatoria")
    @Size(max = 255, message = "La URL no puede superar 255 caracteres")
    private String url;
    @NotBlank(message = "El método es obligatorio")
    @Size(max = 10, message = "El método no puede superar 10 caracteres")
    private String method;
    @NotBlank(message = "El modelo es obligatorio")
    @Size(max = 100, message = "El modelo no puede superar 100 caracteres")
    private String model;
}
