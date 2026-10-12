package com.tournamentmanager.sports_system.dto.userrole;

import com.tournamentmanager.sports_system.dto.role.RoleResponseDTO;
import lombok.Value;

@Value
public class UserRoleResponseDTO {
    Long id;
    Long userId;
    RoleResponseDTO role;
}
