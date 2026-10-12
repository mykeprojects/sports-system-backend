package com.tournamentmanager.sports_system.controller;

import com.tournamentmanager.sports_system.dto.role.*;
import com.tournamentmanager.sports_system.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService service;
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public RoleResponseDTO create(@Valid @RequestBody CreateRoleDTO dto) { return service.create(dto); }
    @GetMapping public List<RoleResponseDTO> findAll() { return service.findAll(); }
    @GetMapping("/{id}") public RoleResponseDTO findById(@PathVariable Long id) { return service.findById(id); }
    @PutMapping("/{id}") public RoleResponseDTO update(@PathVariable Long id, @Valid @RequestBody UpdateRoleDTO dto) { return service.update(id, dto); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id) { service.delete(id); }
}
