package com.tournamentmanager.sports_system.controller;

import com.tournamentmanager.sports_system.dto.session.SessionRequestDTO;
import com.tournamentmanager.sports_system.dto.session.SessionResponseDTO;
import com.tournamentmanager.sports_system.service.SessionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/sessions")
@RequiredArgsConstructor
public class SessionController {
    private final SessionService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SessionResponseDTO create(@PathVariable Long userId, @Valid @RequestBody SessionRequestDTO dto) {
        return service.create(userId, dto);
    }
    @GetMapping
    public List<SessionResponseDTO> findAll(@PathVariable Long userId) {
        return service.findAllByUserId(userId);
    }
    @GetMapping("/{sessionId}")
    public SessionResponseDTO findById(@PathVariable Long userId, @PathVariable Long sessionId) {
        return service.findById(userId, sessionId);
    }
    @PutMapping("/{sessionId}")
    public SessionResponseDTO update(@PathVariable Long userId, @PathVariable Long sessionId,
                                     @Valid @RequestBody SessionRequestDTO dto) {
        return service.update(userId, sessionId, dto);
    }
    @DeleteMapping("/{sessionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long userId, @PathVariable Long sessionId) {
        service.delete(userId, sessionId);
    }
}
