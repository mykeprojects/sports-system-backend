package com.tournamentmanager.sports_system.dto.userrole;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRoleDTO {
    @NotNull(message = "El usuario es obligatorio")
    private Long userId;

    @NotNull(message = "El rol es obligatorio")
    private Long roleId;
}

