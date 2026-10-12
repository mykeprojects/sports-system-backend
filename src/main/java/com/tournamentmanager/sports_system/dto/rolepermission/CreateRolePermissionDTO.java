package com.tournamentmanager.sports_system.dto.rolepermission;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRolePermissionDTO {
    @NotNull(message = "El rol es obligatorio")
    private Long roleId;

    @NotNull(message = "El permiso es obligatorio")
    private Long permissionId;
}
