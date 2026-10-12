package com.tournamentmanager.sports_system.controller;

import com.tournamentmanager.sports_system.dto.rolepermission.*;
import com.tournamentmanager.sports_system.service.RolePermissionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/role-permissions")
@RequiredArgsConstructor
public class RolePermissionController {
    private final RolePermissionService service;
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public RolePermissionResponseDTO create(@Valid @RequestBody CreateRolePermissionDTO dto) { return service.create(dto); }
    @GetMapping public List<RolePermissionResponseDTO> findAll() { return service.findAll(); }
    @GetMapping("/{id}") public RolePermissionResponseDTO findById(@PathVariable Long id) { return service.findById(id); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id) { service.delete(id); }
}
