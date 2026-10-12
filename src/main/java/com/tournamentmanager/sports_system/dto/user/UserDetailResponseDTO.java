package com.tournamentmanager.sports_system.dto.user;

import com.tournamentmanager.sports_system.dto.profile.ProfileResponseDTO;
import lombok.Value;

@Value
public class UserDetailResponseDTO {

    Long id;

    String name;

    String email;

    ProfileResponseDTO profile;
}