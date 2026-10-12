package com.tournamentmanager.sports_system.dto.session;

import lombok.Value;
import java.time.LocalDateTime;

@Value
public class SessionResponseDTO {
    Long id;
    String token;
    LocalDateTime expiration;
    String code2FA;
}
