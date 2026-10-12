package com.tournamentmanager.sports_system.dto.user;

import com.tournamentmanager.sports_system.dto.session.SessionResponseDTO;
import lombok.Value;

import java.util.List;

@Value
public class UserSessionsResponseDTO {
    Long id;
    String name;
    String email;
    List<SessionResponseDTO> sessions;
}
