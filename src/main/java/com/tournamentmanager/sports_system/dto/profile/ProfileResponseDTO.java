package com.tournamentmanager.sports_system.dto.profile;

import lombok.Value;
import java.time.LocalDate;

@Value
public class ProfileResponseDTO {
    Long id;
    Long userId;
    String phone;
    LocalDate birthDate;
}
