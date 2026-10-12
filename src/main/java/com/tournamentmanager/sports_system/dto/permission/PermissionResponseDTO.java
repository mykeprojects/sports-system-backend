package com.tournamentmanager.sports_system.dto.permission;

import lombok.Value;

@Value
public class PermissionResponseDTO {
    Long id;
    String url;
    String method;
    String model;
}
