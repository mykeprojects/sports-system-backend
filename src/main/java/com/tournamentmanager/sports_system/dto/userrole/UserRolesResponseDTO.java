package com.tournamentmanager.sports_system.dto.userrole;

import lombok.Value;

import java.util.List;

@Value
public class UserRolesResponseDTO {
    Long id;
    String name;
    String email;
    List<UserRoleResponseDTO> roles;
}
