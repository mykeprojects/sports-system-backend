package com.tournamentmanager.sports_system.controller;

import com.tournamentmanager.sports_system.dto.permission.*;
import com.tournamentmanager.sports_system.service.PermissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/permissions")
@RequiredArgsConstructor
public class PermissionController {
    private final PermissionService service;
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public PermissionResponseDTO create(@Valid @RequestBody CreatePermissionDTO dto) { return service.create(dto); }
    @GetMapping public List<PermissionResponseDTO> findAll() { return service.findAll(); }
    @GetMapping("/{id}") public PermissionResponseDTO findById(@PathVariable Long id) { return service.findById(id); }
    @PutMapping("/{id}") public PermissionResponseDTO update(@PathVariable Long id, @Valid @RequestBody UpdatePermissionDTO dto) { return service.update(id, dto); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id) { service.delete(id); }
}
