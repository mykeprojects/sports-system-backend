package com.tournamentmanager.sports_system.mapper;

import com.tournamentmanager.sports_system.dto.session.*;
import com.tournamentmanager.sports_system.entity.Session;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class SessionMapper {
    public Session toEntity(SessionRequestDTO dto) {
        Session session = new Session();
        session.setToken(dto.getToken());
        session.setExpiration(dto.getExpiration());
        session.setCode2FA(dto.getCode2FA());
        return session;
    }
    public void updateEntity(SessionRequestDTO dto, Session session) {
        session.setToken(dto.getToken());
        session.setExpiration(dto.getExpiration());
        session.setCode2FA(dto.getCode2FA());
    }
    public SessionResponseDTO toResponseDTO(Session session) {
        return new SessionResponseDTO(session.getId(), session.getToken(), session.getExpiration(), session.getCode2FA());
    }
    public List<SessionResponseDTO> toResponseDTOList(List<Session> sessions) {
        return sessions.stream().map(this::toResponseDTO).toList();
    }
}
