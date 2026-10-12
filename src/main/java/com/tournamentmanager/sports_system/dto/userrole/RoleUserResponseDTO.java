package com.tournamentmanager.sports_system.dto.userrole;

import com.tournamentmanager.sports_system.dto.user.UserResponseDTO;
import lombok.Value;

@Value
public class RoleUserResponseDTO {
    Long id;
    Long roleId;
    UserResponseDTO user;
}
