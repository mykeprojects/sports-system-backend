package com.tournamentmanager.sports_system.dto.role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRoleDTO {
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50, message = "El nombre no puede superar 50 caracteres")
    private String name;
    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 255, message = "La descripción no puede superar 255 caracteres")
    private String description;
}
